package com.jvwl.forum.service;

import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.dto.BoardDto;
import com.jvwl.forum.model.Board;
import com.jvwl.forum.service.base.BaseService;

public interface BoardService extends BaseService<Board>{
	public Pagination<Board> findBoards(BoardDto dto,
			PageInfo pageInfo) ;
	public Pagination<Board> findBoards(BoardDto dto,
			PageInfo pageInfo,Boolean deleted) ;
}
