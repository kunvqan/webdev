package controller;

import dao.UserDAO;
import model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");

        User u = new User(user, pass, email);
        UserDAO dao = new UserDAO();

        if (dao.register(u)) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("error", "Đăng ký thất bại!");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        }
    }
}
