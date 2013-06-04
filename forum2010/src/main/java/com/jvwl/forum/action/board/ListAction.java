package com.jvwl.forum.action.board;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.jvwl.forum.action.base.BaseAction;
import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.dto.BoardDto;
import com.jvwl.forum.model.Board;
import com.jvwl.forum.service.BoardService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ListAction extends BaseAction implements SessionAware,
		ModelDriven<BoardDto> {

	private BoardService boardService;
	private BoardDto boardDto = new BoardDto();
	private Pagination<Board> pagination;
	private Map<String, Object> sessionMap;
	private Integer pageNo;
	private Integer pageSize;

	@Resource
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	public Pagination<Board> getPagination() {
		return pagination;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	@JSON(serialize = false)
	public String execute() throws Exception {
		if (pageNo == null) {
			pageNo = 1;
		}
		if (sessionMap.get("pageSize") == null) {
			sessionMap.put("pageSize", 10);
		} else if (pageSize != null) {
			sessionMap.put("pageSize", pageSize);
		}
		pagination = boardService.findBoards(boardDto,
				new PageInfo(pageNo, (Integer) sessionMap.get("pageSize")));
		return SUCCESS;
	}

	@JSON(serialize = false)
	public BoardDto getModel() {
		return boardDto;
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
