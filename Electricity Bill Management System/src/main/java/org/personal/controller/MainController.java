package org.personal.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.personal.bean.Bill;
import org.personal.bean.User;
import org.personal.dao.BillDao;
import org.personal.dao.UserDao;

@WebServlet("/")
public class MainController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BillDao billDao;
	private UserDao userDao;

	public void init() {
		billDao = new BillDao();
		userDao = new UserDao();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertBill(request, response);
				break;
			case "/delete":
				deleteBill(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBill(request, response);
				break;
			case "/searchBill":
				showSearch(request, response);
				break;
			case "/newUser":
				showNewUserForm(request, response);
				break;
			case "/insertUser":
				insertUser(request, response);
				break;
			case "/deleteUser":
				deleteUser(request, response);
				break;
			case "/editUser":
				showEditUserForm(request, response);
				break;
			case "/updateUser":
				updateUser(request, response);
				break;
			case "/listUser":
				listUser(request, response);
				break;
			case "/searchUser":
				showSearchUser(request, response);
				break;
			case "/logout":
				showLoginForm(request, response);
				break;
			default:
				listBill(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	
	/*
	 * //Bill Controller
	 */
	
	private void listBill(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		List<Bill> listBill = billDao.selectAllBills();
		request.setAttribute("listBill", listBill);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bill-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("bill-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, ClassNotFoundException {
		String username = request.getParameter("username");
		Bill existingBill = billDao.selectBill(username);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bill-form.jsp");
		request.setAttribute("bill", existingBill);
		dispatcher.forward(request, response);
	}

	private void insertBill(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {

		String username = request.getParameter("username");
		String month = request.getParameter("month");
		String totalAmount = request.getParameter("totalAmount");
		String isPaid = request.getParameter("isPaid");
		Bill bill = new Bill(username, month, totalAmount, isPaid);
		billDao.insertBill(bill);
		response.sendRedirect("list");
	}

	private void updateBill(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {
		String username = request.getParameter("username");
		String month = request.getParameter("month");
		String totalAmount = request.getParameter("totalAmount");
		String isPaid = request.getParameter("isPaid");
		Bill bill = new Bill(username, month, totalAmount, isPaid);
		billDao.updateBill(bill);
		response.sendRedirect("list");
	}

	private void deleteBill(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {
		String username = request.getParameter("username");
		billDao.deleteBill(username);
		response.sendRedirect("list");
	}
	
	private void showSearch(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, ClassNotFoundException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("bill-search.jsp");
		dispatcher.forward(request, response);
	}

	private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, ClassNotFoundException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("LoginPage.jsp");
		dispatcher.forward(request, response);
	}

	
	/*
	 * User Controller
	 */
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		List<User> listUser = userDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewUserForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditUserForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, ClassNotFoundException {
		String username = request.getParameter("username");
		User existingUser = userDao.selectUser(username);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String role = request.getParameter("role");
		User user = new User(username, password, firstName, lastName, role);
		userDao.insertUser(user);
		response.sendRedirect("listUser");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String role = request.getParameter("role");
		User user = new User(username, password, firstName, lastName, role);
		userDao.updateUser(user);
		response.sendRedirect("listUser");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {
		String username = request.getParameter("username");
		userDao.deleteUser(username);
		response.sendRedirect("listUser");
	}
	
	private void showSearchUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, ClassNotFoundException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-search.jsp");
		dispatcher.forward(request, response);
	}

}
