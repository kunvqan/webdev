package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns={"/login"})

public class Login_CK extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		String name = "";
		Cookie[] cookie = request.getCookies();
		for (Cookie c : cookie) {
			if (c.getName().equals("username")) {
				name = c.getValue();
			}
		}
		if (name.equals("")) {
			response.sendRedirect(request.getContextPath() + "/login");

		}
		printWriter.println("Xin chao " + name);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

//		String user = request.getParameter("username");
//		String pass = request.getParameter("password");
//		if (user.equals("kunquan") && pass.equals("123")) {
//			Cookie cookie = new Cookie("username", user);
//			cookie.setMaxAge(30);
//			response.addCookie(cookie);
//			
//			System.out.println(request.getContextPath());
//
//			response.sendRedirect(request.getContextPath() + "/login");
//
//		} else {
//			response.sendRedirect(request.getContextPath() + "/login");
//
//		}
		
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.equals("kunquan")&& password.equals("123")) {
		out.print("Chào mừng bạn, " + username);
		HttpSession session = request.getSession();
		session.setAttribute("name", username);
		} else {
		out.print("Tài khoản hoặc mật khẩu không chính xác");
		request.getRequestDispatcher("login.html").include(request,
		response);
		}
	}

}