package com.jvwl.forum.action.board;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.json.annotations.JSON;

import com.jvwl.forum.action.base.BaseAction;
import com.jvwl.forum.common.Message;
import com.jvwl.forum.model.Board;
import com.jvwl.forum.service.BoardService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class EditAction extends BaseAction implements ModelDriven<Board> {

	private BoardService boardService;
	private Board board = new Board();
	private String[] ids;
	private Message message;

	public Message getMessage() {
		return message;
	}

	@Resource
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	public Board getBoard() {
		return board;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	@JSON(serialize = false)
	@Action("update")
	public String update() throws Exception {
		board = boardService.findClassById(board.getId());
		return SUCCESS;
	}

	@JSON(serialize = false)
	@Action("delete")
	public String delete() throws Exception {
		try {
			boardService.delete(ids);
			message = new Message(getText("operate_ok"), "删除数据成功！", true, null);
		} catch (Exception e) {
			message = new Message(getText("operate_fail"),
					"删除数据失败！！！\n部分数据删除时发生异常", false, null);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public Board getModel() {
		return board;
	}
}
