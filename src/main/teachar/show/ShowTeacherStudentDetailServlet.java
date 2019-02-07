package main.teachar.show;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;
import main.dao.studentDetailDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

@WebServlet("/ShowTeacherStudentDetailServlet")
public class ShowTeacherStudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowTeacherStudentDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String seki_no = (String) request.getParameter("seki_no");
		studentDetailDAO sdDAO = new studentDetailDAO();
		try {
			request.setAttribute("studentDetail", sdDAO.getStudentDetail(seki_no));
		} catch (DatabaseException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Teacher/Teacher_Student_Detail.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
