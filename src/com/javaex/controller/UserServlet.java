package com.javaex.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaex.dao.UserDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.UserVo;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("user");

		String actionName = request.getParameter("action");
		System.out.println(actionName);
		if ("joinform".equals(actionName)) {
			WebUtil.forword(request, response, "/WEB-INF/views/user/joinform.jsp");
		} else if ("join".equals(actionName)) {

			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");

			UserVo userVo = new UserVo(name, email, password, gender);
			System.out.println(userVo.toString());

			UserDao dao = new UserDao();
			dao.insert(userVo);

			WebUtil.forword(request, response, "/WEB-INF/views/user/joinsuccess.jsp");

		} else if ("loginform".equals(actionName)) {
			WebUtil.forword(request, response, "/WEB-INF/views/user/loginform.jsp");
		} else if ("login".equals(actionName)) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			System.out.println(email);
			System.out.println(password);

			UserDao dao = new UserDao();
			UserVo uservo = dao.getUser(email, password);
			// System.out.println(uservo.toString());

			if (uservo == null) {// 로그인 실패
				WebUtil.redirect(request, response, "/mywebproject4/user?action=loginform&result=fail");
			} else { // 로그인 성공
				HttpSession session = request.getSession();
				session.setAttribute("authUser", uservo);

				WebUtil.redirect(request, response, "/mywebproject4/main");

			}

		} else if ("logout".equals(actionName)) {
			HttpSession session = request.getSession();
			session.removeAttribute("authUser");
			session.invalidate();

			WebUtil.redirect(request, response, "/mywebproject4/main");

		} else if ("modifyform".equals(actionName)) {

			WebUtil.forword(request, response, "/WEB-INF/views/user/modifyform.jsp");
		} else if ("modify".equals(actionName)) {
			HttpSession session = request.getSession();
			UserVo authUser = (UserVo)session.getAttribute("authUser");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			int no =  authUser.getNo();
			authUser.setName(name);
			authUser.setPassword(password);
			authUser.setGender(gender);

			
			
			UserDao dao = new UserDao();
			int flag = dao.update(name, password, gender, no);
			if(flag == 1) {
				session.setAttribute("authUser", authUser);
			}
			WebUtil.redirect(request, response, "/mywebproject4/main");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
