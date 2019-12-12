package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	protected boolean isValidSession(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean flag = false;
		HttpSession session = request.getSession(false);

		try {
			// System.out.println("here coming");
			Object str = session.getAttribute("Status");
			if (str != null) {
				flag = true;
			}
		} catch (Exception e) {
			// System.out.println("baseservlet");
			// request.getRequestDispatcher("Welcome").forward(request,
			// response);
		}
		return flag;
	}

}
