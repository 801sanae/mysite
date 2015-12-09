package com.hanains.mysite.http.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;
import com.hanains.mysite.dao.GuestBookDao;
import com.hanains.mysite.vo.GuestBookVo;

public class InsertAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name=req.getParameter("name");
		String password=req.getParameter("pass");
		String message=req.getParameter("content");
		
		GuestBookDao dao = new GuestBookDao();
		GuestBookVo vo = new GuestBookVo();
		
		
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);
		
		System.out.println("::"+vo);
		
		
		dao.insert(vo);
		
		HttpUtil.redirect(resp, "/mysite/gb?a=list");
	}

}
