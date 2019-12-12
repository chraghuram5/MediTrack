package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReminderDao;
import dao.ReminderDaoSqlImpl;
import model.Reminder;
import model.User;

/**
 * Servlet implementation class CalendarServlet
 */
@WebServlet("/CalendarServlet")
public class CalendarServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (isValidSession(request, response)) {
			int monthNumber = Integer.parseInt(request.getParameter("monthNumber"));
			int year = Integer.parseInt(request.getParameter("year"));
			System.out.println(monthNumber + " " + year);
			String month = request.getParameter("month");
			HttpSession session = request.getSession(false);
			User user = (User) session.getAttribute("User");
			System.out.println(user.getFname());
			int userId = user.getUserId();
			if (((user.getRole()).equals("CareTaker")))
				userId = user.getAssId();
			System.out.println(userId);
			if (month.equals("present")) {
				Calendar cal = Calendar.getInstance();
				int yearTemp = cal.get(Calendar.YEAR);
				int monthNumberTemp = cal.get(Calendar.MONTH) + 1;
				ReminderDao r = new ReminderDaoSqlImpl();
				ArrayList<Reminder> list = r.getMonth(monthNumberTemp, yearTemp, userId);
				request.setAttribute("list", list);
				request.setAttribute("year", yearTemp);
				request.setAttribute("month", monthNumberTemp);
				request.getRequestDispatcher("Calendar.jsp").forward(request, response);
			}
			if (month.equals("next")) {
				monthNumber++;
				if (monthNumber > 12) {
					year++;
					monthNumber = monthNumber % 12;
				}
				ReminderDao r = new ReminderDaoSqlImpl();
				ArrayList<Reminder> list = r.getMonth(monthNumber, year, userId);
				request.setAttribute("list", list);
				request.setAttribute("year", year);
				request.setAttribute("month", monthNumber);
				request.getRequestDispatcher("Calendar.jsp").forward(request, response);
			}
			if (month.equals("previous")) {
				monthNumber--;
				if (monthNumber <= 0) {
					year--;
					monthNumber = monthNumber + 12;
				}
				ReminderDao r = new ReminderDaoSqlImpl();
				ArrayList<Reminder> list = r.getMonth(monthNumber, year, userId);
				request.setAttribute("list", list);
				request.setAttribute("year", year);
				request.setAttribute("month", monthNumber);
				request.getRequestDispatcher("Calendar.jsp").forward(request, response);
			}
		} else
			request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

}
