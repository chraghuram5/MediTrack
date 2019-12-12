package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MedicineDao;
import dao.MedicineDaoSqlImpl;
import dao.UserDao;
import dao.UserDaoSqlImpl;
import model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (isValidSession(request, response)) {
			String id = request.getParameter("asId");
			int asId = Integer.parseInt(id);
			UserDao userDao = new UserDaoSqlImpl();
			HttpSession session = request.getSession(false);
			User user = (User) session.getAttribute("User");
			int userId = user.getUserId();
			userDao.addId(asId, userId);
			User user1 = userDao.getUser(asId);
			User user2 = userDao.getUser(user.getUserId());
			session.setAttribute("User", user2);
			session.setAttribute("asUser", user1);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action.equals("register")) {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String uname = request.getParameter("uname");
			String mobile = request.getParameter("mobile");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			UserDao userObj = new UserDaoSqlImpl();
			User user = new User(fname, lname, email, gender, uname, mobile, password, role);
			int n = userObj.addUser(user);
			if (n != 0)
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			else {
				request.setAttribute("RegistrationStatus", "Failed");
				request.getRequestDispatcher("Registration.jsp").forward(request, response);
			}
		}
		if (action.equals("authenticate")) {
			String uname = request.getParameter("uname");
			String password = request.getParameter("password");
			UserDao userDao = new UserDaoSqlImpl();
			int userId = userDao.authenticate(uname, password);
			User user = userDao.getUser(userId);
			if (userId != 0) {
				HttpSession session = request.getSession();
				MedicineDao medicineDao = new MedicineDaoSqlImpl();
				ArrayList<String> medicineList = medicineDao.getMedicine();
				session.setAttribute("medicineList", medicineList);// Used in AddMedication.jsp
				session.setAttribute("User", user);// Used in profile.jsp
				session.setAttribute("Status", "Authenticated");// Used in BaseServlet
				if (user.getAssId() != 0) {
					User user1 = userDao.getUser(user.getAssId());
					session.setAttribute("asUser", user1);
				}
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			} else {
				request.setAttribute("LoginStatus", "Failed");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
	}

}
