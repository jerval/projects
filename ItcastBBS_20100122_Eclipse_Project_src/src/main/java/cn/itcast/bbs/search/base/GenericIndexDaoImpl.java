package cn.itcast.bbs.search.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.compass.core.Compass;
import org.compass.core.CompassCallback;
import org.compass.core.CompassException;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.compass.core.CompassTemplate;

import cn.itcast.bbs.domain.query.QueryResult;
import cn.itcast.bbs.utils.CompassUtils;

@SuppressWarnings("unchecked")
public abstract class GenericIndexDaoImpl<T> implements GenericIndexDao<T> {

	protected Class<T> clazz;
	protected int defaultFragmentSize = 300;// FIXME 默认的摘要大小为300，要和配置文件中的一致

	public GenericIndexDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

	// public GenericIndexDaoImpl(String searchableObjectClassName) {
	// try {
	// this.clazz = (Class<T>) Class.forName(searchableObjectClassName);
	// } catch (ClassNotFoundException e) {
	// throw new RuntimeException("初始化IndexDaoImpl失败.", e);
	// }
	// }

	public void save(T searchableObject) {
		CompassTemplate ct = new CompassTemplate(getCompassSessionFactory());
		ct.create(searchableObject);
	}

	// FIXME 使用save()
	public void saveAll(final List<T> searchableObjectList) {
		CompassTemplate ct = new CompassTemplate(getCompassSessionFactory());
		ct.execute(new CompassCallback<T>() {

			public T doInCompass(CompassSession session) throws CompassException {
				for (T obj : searchableObjectList) {
					session.save(obj);
				}
				session.flush();
				return null;
			}
		});
	}

	public void delete(T searchableObject) {
		CompassTemplate ct = new CompassTemplate(getCompassSessionFactory());
		ct.delete(searchableObject);
	}

	public void delete(Serializable id) {
		CompassTemplate ct = new CompassTemplate(getCompassSessionFactory());
		ct.delete(clazz, id);
	}

	public void deleteAll(final List<T> searchableObjectList) {
		CompassTemplate ct = new CompassTemplate(getCompassSessionFactory());
		ct.execute(new CompassCallback<T>() {

			public T doInCompass(CompassSession session) throws CompassException {
				for (T obj : searchableObjectList) {
					session.delete(obj);
				}
				return null;
			}
		});
	}

	public void update(T searchableObject) {
		CompassTemplate ct = new CompassTemplate(getCompassSessionFactory());
		ct.save(searchableObject);
	}

	@SuppressWarnings("unchecked")
	public QueryResult<T> search(final String queryString, final int firstResult, final int maxResults) {
		CompassTemplate ct = new CompassTemplate(getCompassSessionFactory());
		return ct.execute(new CompassCallback<QueryResult<T>>() {
			public QueryResult<T> doInCompass(CompassSession session) throws CompassException {
				CompassHits hits = session.find(queryString);

				List<T> list = new ArrayList<T>();
				for (int i = firstResult; i < Math.min(firstResult + maxResults, hits.length()); i++) {
					T obj = hit2Object(hits, i);
					list.add(obj);
				}

				return new QueryResult<T>(hits.length(), list);
			}
		});
	}

	// public QueryResult<T> search(String queryString, int firstResult, int maxResults) {
	// CompassTemplate ct = new CompassTemplate(getCompassSessionFactory());
	// CompassDetachedHits detachedHits = ct.findWithDetach(queryString, firstResult, maxResults);
	//
	// List<T> list = new ArrayList<T>();
	// for (CompassHit hit : detachedHits) {
	// T obj = hit2Object(hit);
	// list.add(obj);
	// }
	// return new QueryResult<T>(detachedHits.getLength(), list);
	// }

	// public QueryResult<T> search(CompassQuery query, int firstResult, int maxResults) {
	// throw new UnsupportedOperationException();
	// }

	/**
	 * 转换结果，可以进行高亮（如果需要）
	 */
	// protected abstract T hit2Object(CompassHit hit);
	protected abstract T hit2Object(CompassHits hits, int index);

	public int getCount() {
		CompassTemplate ct = new CompassTemplate(getCompassSessionFactory());
		return (Integer) ct.execute(new CompassCallback<Integer>() {

			public Integer doInCompass(CompassSession session) throws CompassException {
				return session.queryBuilder().matchAll().hits().length();
			}
		});
	}

	/**
	 * 返回可用的Compass
	 * 
	 * @return
	 */
	protected Compass getCompassSessionFactory() {
		return CompassUtils.getCompass();
	}
}
