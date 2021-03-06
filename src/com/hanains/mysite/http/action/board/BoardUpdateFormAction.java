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

public class BoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("::::"+request.getParameter("no"));
		
		
		BoardDao dao=new BoardDao();
		BoardVo board = dao.getView(Integer.parseInt(request.getParameter("no")));
		
		System.out.println("::::"+board);
		
		request.setAttribute("board", board);
		
		HttpUtil.forwarding(request, response, "/WEB-INF/views/board/modify.jsp");
	}

}
