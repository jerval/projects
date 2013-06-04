package cn.itcast.bbs.dd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 数据字典。数据项都有一个唯一的name。数据项的值可以是某一类型或是集合（List）中的一个元素。<br>
 * 如果某name只对应一个值，此数据就是指定的类型。如果一个name对应多个值，此数据就是List类型中的一个元素
 * 
 * @author tyg
 */
@SuppressWarnings("unchecked")
public class DataDict {
	private static final Log log = LogFactory.getLog(DataDict.class);

	// 私有的
	private DataDict() {
	}

	// -----------
	private static Map<String, Object> dataItemInstanceMap = new HashMap<String, Object>();

	/**
	 * 初始化数据字典。会加载相应表中的所有记录。<br>
	 * 在数据字典表中的记录改变时，应重新初始化。
	 * 
	 * @param sessionFactory
	 */
	public static void initialize(SessionFactory sessionFactory) {
		// 先清空
		dataItemInstanceMap.clear();

		log.info("正在初始化DataDict");
		Session session = sessionFactory.openSession();

		// 1，获取所有的数据项
		List<DataItem> dataItemList = session.createCriteria(DataItem.class).list();

		// 2，处理数据项，转为相应的类型
		for (DataItem item : dataItemList) {
			Class clazz = item.getValueType();
			Object dataItemInstance = null;

			// 如果是PO，则valueType是实体类型，value是实体id
			if (item.isHibernatePO() && item.getStringValue() != null /* 主键不能为null */) {
				dataItemInstance = session.get(clazz, (Serializable) item.getStringValue());
			}
			// 否则就使用BeanUtils的转换器进行转换
			else {
				Converter converter = ConvertUtils.lookup(clazz);
				dataItemInstance = converter.convert(clazz, item.getStringValue());
			}

			String name = item.getName();
			Object value = dataItemInstanceMap.get(name);

			if (value == null) { // 一个值，存起来即可
				dataItemInstanceMap.put(name, dataItemInstance);
			}
			// 如果已对应某一值，就得用List存储多个值
			else {
				if (value instanceof List) { // 如果是List，就住List再加一个元素
					List list = (List) value;
					list.add(dataItemInstance);
				} else {
					// 如果是某一值，则把他和目前这个值放到同一个List中
					// 这样，name对应的值类型就是集合了
					List list = new ArrayList();
					list.add(value);
					list.add(dataItemInstance);
					dataItemInstanceMap.put(name, list);
				}
			}
		}

		session.close();
		log.info("DataDict初始化完毕。共有最终数据 " + dataItemInstanceMap.size() + " 条，DataItem " + dataItemList.size() + " 条");
	}

	public static Object getObject(String name) {
		ensureExists(name);
		return dataItemInstanceMap.get(name);
	}

	public static String getString(String name) {
		ensureExists(name);
		return (String) dataItemInstanceMap.get(name);
	}

	public static int getInt(String name) {
		ensureExists(name);
		return (Integer) dataItemInstanceMap.get(name);
	}

	public static List getList(String name) {
		ensureExists(name);
		return (List) dataItemInstanceMap.get(name);
	}

	/**
	 * 判断某一数据是否存在，如果不存在，就抛异常。
	 * 
	 * @param name
	 */
	private static void ensureExists(String name) {
		if (!dataItemInstanceMap.containsKey(name)) {
			throw new IllegalStateException("在数据字典中没有name=" + name + "的数据项！");
		}
	}

}
