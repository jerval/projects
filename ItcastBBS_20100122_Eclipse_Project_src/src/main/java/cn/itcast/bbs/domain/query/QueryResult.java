package cn.itcast.bbs.domain.query;

import java.util.List;

/**
 * 查询结果（分页用）
 * 
 * @author 传智播客.汤阳光 Apr 26, 2009
 * 
 * @param <T>
 */
public class QueryResult<T> {

	private int recordCount;
	private List<T> recordList;

	public QueryResult(int recordCount, List<T> recordList) {
		this.recordCount = recordCount;
		this.recordList = recordList;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public List<T> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<T> recordList) {
		this.recordList = recordList;
	}

}
