package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MedicationDao;
import dao.MedicationDaoSqlImpl;
import model.Medication;
import model.User;

/**
 * Servlet implementation class MedicationServlet
 */
@WebServlet("/MedicationServlet")
public class MedicationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isValidSession(request, response)) {
			HttpSession session = request.getSession();
			User user=(User)session.getAttribute("User");
			int userId=user.getUserId();
			if(user.getRole().equals("CareTaker"))
				userId=user.getAssId();
			String action = request.getParameter("action");
			MedicationDao medicationDao = new MedicationDaoSqlImpl();
			if (action.equals("DELETE")) {
				int medicationId = Integer.parseInt(request.getParameter("Id"));
				medicationDao.deleteMedication(medicationId);
			}
			if (action.equals("EDIT")) {
				int medicationId = Integer.parseInt(request.getParameter("medicationId"));
				Medication medication = medicationDao.getMedication(medicationId);
				request.setAttribute("medication", medication);
				request.getRequestDispatcher("EditMedication.jsp").forward(request, response);
			}
			ArrayList<Medication> list = medicationDao.getMedicationList(userId);
			session.setAttribute("medicationData", list);
			session.setAttribute("medicationData", list);
			request.getRequestDispatcher("Medication.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (isValidSession(request, response)) {
			HttpSession session=request.getSession();
			User user=(User)session.getAttribute("User");
			int userId=user.getUserId();
			if(user.getRole().equals("CareTaker"))
				userId=user.getAssId();
			MedicationDao m = new MedicationDaoSqlImpl();
			String medication = request.getParameter("medication");
			int morning = Integer.parseInt(request.getParameter("morning"));
			int afternoon = Integer.parseInt(request.getParameter("afternoon"));
			int evening = Integer.parseInt(request.getParameter("evening"));
			int night = Integer.parseInt(request.getParameter("night"));
			String action = (String) request.getParameter("action");
			if (action.equals("ADD")) {
				Medication medi = new Medication(medication, morning, afternoon, evening, night, userId);
				m.addMedication(medi);
			}
			if (action.equals("EDIT")) {
				int id = Integer.parseInt(request.getParameter("Id"));
				Medication medi = new Medication(id, medication, morning, afternoon, evening, night, userId);
				m.editMedication(medi);
			}
			request.setAttribute("MedicationStatus", "added");
			request.getRequestDispatcher("AddMedication.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
}
