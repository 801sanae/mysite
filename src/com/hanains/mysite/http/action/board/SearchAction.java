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

public class SearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String kwd = request.getParameter("kwd");
		
		BoardDao dao = new BoardDao();
		List<BoardVo> slist = dao.getSearch(kwd);
		
		request.setAttribute("slist", slist);
		
		HttpUtil.forwarding(request, response, "/WEB-INF/views/board/list.jsp");
	}

}
