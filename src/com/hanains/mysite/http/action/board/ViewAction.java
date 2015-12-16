package com.hanains.mysite.http.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;
import com.hanains.mysite.dao.BoardDao;
import com.hanains.mysite.vo.BoardVo;
import com.hanains.mysite.vo.UserVo;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardDao dao = new BoardDao();
		BoardVo board = dao.getView(Integer.parseInt(request.getParameter("no")));
		UserVo memberVo = (UserVo) request.getSession(true).getAttribute("authUser");
		
		System.out.println("::"+memberVo);
		
		request.setAttribute("board", board);
		request.setAttribute("authUser", memberVo);
		
		HttpUtil.forwarding(request, response, "/WEB-INF/views/board/view.jsp");
	}

}
