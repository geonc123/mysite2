package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GestBookDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.GestBookVo;

@WebServlet("/gestbook")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("emailbook servlet 실행 ");
		request.setCharacterEncoding("UTF-8");

		String actionName = request.getParameter("action");

		if ("insert".equals(actionName)) {
			System.out.println("insert 요청");

			String id = request.getParameter("id");
			String password = request.getParameter("pd");
			String noticeBoard = request.getParameter("ta");

			GestBookVo vo = new GestBookVo();
			vo.setId(id);
			vo.setPassword(password);
			vo.setNoticBoard(noticeBoard);

			GestBookDao dao = new GestBookDao();
			dao.insert(vo);
			WebUtil.redirect(request, response, "/mywebproject4/gestbook?action=list");
			/* response.sendRedirect("/emailbook2/emailbook?action=list"); */
		} else if ("deform".equals(actionName)) {
			System.out.println("delete 요청 ");

			int no =Integer.parseInt(request.getParameter("no"));

			GestBookVo vo = new GestBookVo();
			vo.setNo(no);

			request.setAttribute("no", no);

			System.out.println(vo.getNo());
			WebUtil.forword(request, response, "/WEB-INF/views/geust/deleteform.jsp");

		} else if ("delete".equals(actionName)) {
			System.out.println("delete exe");
			String password = request.getParameter("password");

			
			int no =(int) request.getAttribute("no");
			GestBookVo vo = new GestBookVo();
			vo.setNo(no);
			vo.setPassword(password);

			GestBookDao dao = new GestBookDao();
			dao.delete(vo);

			response.sendRedirect("./gestbook?action=list");

		} else {

			System.out.println("list 요청 ");

			GestBookDao dao = new GestBookDao();
			List<GestBookVo> list = dao.getList();

			System.out.println(list.toString());
			request.setAttribute("emailList", list);

			WebUtil.forword(request, response, "/WEB-INF/views/geust/addlst.jsp");
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
			 * rd.forward(request, response);
			 */
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}