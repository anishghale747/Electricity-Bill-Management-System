package org.personal.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.personal.bean.LoginBean;
import org.personal.dao.LoginDao;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("LoginPage.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        authenticate(request, response);
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        loginBean.setRole(role);

        try {
            if (loginDao.validate(loginBean)) {
                if (role.equals("User")) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("bill-list.jsp");
                    dispatcher.forward(request, response);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("currentSessionUser", loginBean);
                } else if (role.equals("Admin")) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
                    dispatcher.forward(request, response);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("currentSessionUser", loginBean);
                }
            } else {
                HttpSession session = request.getSession();
//                response.sendRedirect("login/LoginPage.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
