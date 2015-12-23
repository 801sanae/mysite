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

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("contents");
		
		System.out.println(title+"/"+content+"/"+request.getParameter("no"));
		
		int no =Integer.parseInt(request.getParameter("no"));
		
		BoardDao dao=new BoardDao();
		BoardVo board = dao.getView(no);
		board.setTitle(title);
		board.setContents(content);
		
		System.out.println("updateAction="+board);
		
		dao.update(board);
		
		request.setAttribute("board", board);
		
		HttpUtil.forwarding(request, response, "/WEB-INF/views/board/view.jsp");
	}

}
