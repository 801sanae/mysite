package com.hanains.mysite.http.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;
import com.hanains.mysite.dao.BoardDao;
import com.hanains.mysite.vo.BoardVo;
import com.hanains.mysite.vo.UserVo;

public class BoardInsertFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int group_no=Integer.parseInt(request.getParameter("group_no"));
		int order_no=Integer.parseInt(request.getParameter("order_no"));
		int depth=Integer.parseInt(request.getParameter("depth"));
		
		BoardVo board= new BoardVo();
		
		System.out.println(group_no+":"+order_no+":"+depth);
		
		board.setGroup_no(group_no);
		board.setOrder_no(order_no);
		board.setDepth(depth);
		
		request.setAttribute("board", board);
		
		HttpUtil.forwarding(request, response, "/WEB-INF/views/board/write.jsp");		
	}

}
