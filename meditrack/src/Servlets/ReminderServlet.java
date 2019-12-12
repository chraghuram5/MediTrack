package Servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReminderDao;
import dao.ReminderDaoSqlImpl;
import dao.sendSMS;
import model.Reminder;
import model.User;

/**
 * Servlet implementation class AddReminderServlet
 */
@WebServlet("/ReminderServlet")
public class ReminderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			HttpSession session=request.getSession(false);
			String action = (String) request.getParameter("action");
			//int Id = Integer.parseInt(request.getParameter("reminderId"));
			ReminderDao reminderDao = new ReminderDaoSqlImpl();
			if (action.equals("EDIT")) {
				int Id = Integer.parseInt(request.getParameter("reminderId"));
				Reminder reminder = reminderDao.getReminder(Id);
				request.setAttribute("editReminder", reminder);
				request.getRequestDispatcher("EditReminder.jsp").forward(request, response);
			}
			if (action.equals("DELETE")) {
				int Id = Integer.parseInt(request.getParameter("reminderId"));
				reminderDao.deleteReminder(Id);
				Calendar cal = Calendar.getInstance();
				request.setAttribute("ReminderStatus", "deleted");
				request.getRequestDispatcher("AddReminder.jsp").forward(request, response);
			}
			if (action.equals("ADD")) {
				String day = request.getParameter("day1");
				String month = request.getParameter("month1");
				String year = request.getParameter("year1");
				session.setAttribute("day2", day);
				session.setAttribute("month2", month);
				session.setAttribute("year2", year);
				request.getRequestDispatcher("AddReminder.jsp").forward(request, response);
			}
		} else
			request.getRequestDispatcher("Login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (isValidSession(request, response)) {
			String event = request.getParameter("event");
			int day = Integer.parseInt(request.getParameter("day"));
			int month = Integer.parseInt(request.getParameter("month"));
			int year = Integer.parseInt(request.getParameter("year"));
			int hours = Integer.parseInt(request.getParameter("hours"));
			int minutes = Integer.parseInt(request.getParameter("minutes"));
			int seconds = 0;
			String reminder = request.getParameter("reminder");
			String repeat = request.getParameter("repeat");
			String type = request.getParameter("type");
			String when = request.getParameter("when");
			User user = (User) session.getAttribute("User");
			User user1 = (User) session.getAttribute("asUser");
			int userId = user1.getUserId();
			Reminder r = new Reminder(userId, event, day, month, year, hours, minutes, reminder, repeat, type);
			ReminderDao dao = new ReminderDaoSqlImpl();
			int count = dao.count(r);
			if (count > 6) {
				session.setAttribute("Count", "Exceeded");
				request.getRequestDispatcher("AddReminder.jsp").forward(request, response);
			} else {
				String action = (String) request.getParameter("action");
				if (action.equals("ADD")) {
					request.setAttribute("ReminderStatus", "added");
					dao.addReminder(r);
				}
				if (action.equals("EDIT")) {
					int id = Integer.parseInt(request.getParameter("Id"));
					request.setAttribute("ReminderStatus", "edited");
					Reminder editReminder = new Reminder(userId, event, day, month, year, hours, minutes, reminder,
							repeat, type, id);
					dao.editReminder(editReminder);
				}
				if (repeat.equals("Every Month")) {
					int i = 12;
					while (i > 0) {
						month++;
						if (month >= 13) {
							month = month % 12;
							year++;
						}
						Reminder r1 = new Reminder(userId, event, day, month, year, hours, minutes, reminder, repeat,
								type);
						dao.addReminder(r1);
						i--;
					}
				}
				if (repeat.equals("Every year")) {
					int i = 5;
					while (i > 0) {
						year++;
						Reminder r1 = new Reminder(userId, event, day, month, year, hours, minutes, reminder, repeat,
								type);
						dao.addReminder(r1);
						i--;
					}
				}
				if (when.equals("15")) {
					if (minutes >= 15)
						minutes = minutes - 15;
					else {
						hours--;
						minutes = minutes - 15 + 60;
					}
				}
				if (when.equals("10")) {
					if (minutes >= 10)
						minutes = minutes - 10;
					else {
						hours--;
						minutes = minutes - 10 + 60;
					}
				}
				if (when.equals("5")) {
					if (minutes >= 5)
						minutes = minutes - 5;
					else {
						hours--;
						minutes = minutes - 5 + 60;
					}
				}
				Date localTime = new Date(year - 1900, month - 1, day, hours, minutes, seconds);
				DateFormat converter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				converter.setTimeZone(TimeZone.getTimeZone("GMT"));
				String time = converter.format(localTime);
				sendSMS sms = new sendSMS();
				String mobile = user.getMobile();
				String message = sms.sendSms(time, mobile, event + reminder);
				System.out.println(time);
				request.getRequestDispatcher("AddReminder.jsp").forward(request, response);
			}
		} else
			request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
}