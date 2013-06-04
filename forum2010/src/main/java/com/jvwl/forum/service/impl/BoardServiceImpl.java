package com.jvwl.forum.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvwl.forum.bean.YesNo;
import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.dto.BoardDto;
import com.jvwl.forum.model.Board;
import com.jvwl.forum.service.BoardService;
import com.jvwl.forum.service.base.BaseServiceImpl;

@Service("boardService")
@Transactional
public class BoardServiceImpl extends BaseServiceImpl<Board> implements
		BoardService {

	public Pagination<Board> findBoards(BoardDto dto, PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
	}

	public Pagination<Board> findBoards(BoardDto dto, PageInfo pageInfo,
			Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);
	}

	public String getSqlWhere(BoardDto dto) {
		StringBuilder sql = new StringBuilder();
		if (dto == null) {
			return "";
		} else {
			String boardName = dto.getBoardName();
			String createUserName = dto.getCreateUserName();
			YesNo isuse = dto.getIsuse();
			if (null != boardName && !"".equals(boardName)) {
				sql.append(" and e.boardName like '%" + boardName + "%'");
			}
			if (null != createUserName && !"".equals(createUserName)) {
				sql.append(" and e.createUserName like '%" + createUserName
						+ "%'");
			}
			if (null != isuse) {
				sql.append(" and e.isuse=" + isuse.ordinal());
			}
			return sql.toString();
		}
	}
}
