package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaex.dao.GeustDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.GeustBookVo;
import com.javaex.vo.UserVo;


@WebServlet("/geust")
public class GeustController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter("action");
		
		if("list".equals(actionName)) {
			GeustDao dao = new GeustDao();
			List<GeustBookVo> vo  = dao.getList();
			request.setAttribute("geustList", vo);
			WebUtil.forword(request, response, "/WEB-INF/views/board/list.jsp");
		}else if("insert".equals(actionName)) {
			GeustDao dao = new GeustDao();
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			HttpSession session = request.getSession();
			UserVo authUser = (UserVo)session.getAttribute("authUser");
			int user_no = authUser.getNo();
			
			dao.insert(title, content, user_no);
			
			WebUtil.redirect(request, response, "/mywebproject4/geust?action=list");
		}else if("writeform".equals(actionName)) {
			WebUtil.forword(request, response, "/WEB-INF/views/board/writeform.jsp");
		}else if("modifyform".equals(actionName)) {
			int no = Integer.parseInt(request.getParameter("no"));
			GeustDao dao = new GeustDao();
			GeustBookVo vo = dao.getVo(no);
			request.setAttribute("getList", vo);
			WebUtil.forword(request, response, "/WEB-INF/views/board/modifyform.jsp");
		}else if("modify".equals(actionName)) {
			
			int no = Integer.parseInt(request.getParameter("no"));
			GeustDao dao = new GeustDao();
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			HttpSession session = request.getSession();
			UserVo authUser = (UserVo)session.getAttribute("authUser");
			int user_no = authUser.getNo();
			dao.modify(title, content, no, user_no);
			
			
			WebUtil.redirect(request, response, "/mywebproject4/geust?action=geust");
		}else if("delete".equals(actionName)) {
			
			GeustDao dao = new GeustDao();
			int no = Integer.parseInt(request.getParameter("no"));
			
			dao.delete(no);
			WebUtil.redirect(request, response, "/WEB-INF/views/board/list.jsp");
			
		}else if("read".equals(actionName)) {
			int no = Integer.parseInt(request.getParameter("no"));
			
			
			GeustDao dao = new GeustDao();
			dao.upHit(no);
			GeustBookVo vo = dao.getVo(no);
			request.setAttribute("getList", vo);
			WebUtil.forword(request, response, "/WEB-INF/views/board/read.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

