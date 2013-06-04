package cn.itcast.bbs.web.struts.formbean.base;

import org.apache.struts.action.ActionForm;

import cn.itcast.bbs.dd.DDConstants;
import cn.itcast.bbs.dd.DataDict;

@SuppressWarnings("serial")
public class ActionFormBase extends ActionForm {
	private int pageNum = 1;
	private int pageSize = DataDict.getInt(DDConstants.DEFAULT_PAGE_SIZE);

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
