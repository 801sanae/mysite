package com.hanains.mysite.http.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;
import com.hanains.mysite.dao.BoardDao;
import com.hanains.mysite.vo.BoardVo;
import com.hanains.mysite.vo.UserVo;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("contents");
		UserVo memberVo = (UserVo) request.getSession(true).getAttribute("authUser");
		
		int group_no = Integer.parseInt(request.getParameter("group_no"));
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		int depth = Integer.parseInt(request.getParameter("depth"));
		
		BoardVo vo =new BoardVo();
		BoardDao dao = new BoardDao();
		
		vo.setTitle(title);
		vo.setContents(content);
		vo.setMember_no(memberVo.getNo());
		vo.setUserVo(memberVo);
		vo.setGroup_no(group_no);
		vo.setOrder_no(order_no);
		vo.setDepth(depth);
		System.out.println("WriteAction:" + vo);
		
		
		dao.insert(vo);

		HttpUtil.redirect(response, "/mysite/board?a=list");
	}

}
