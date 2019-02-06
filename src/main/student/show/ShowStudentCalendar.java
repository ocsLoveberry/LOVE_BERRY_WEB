package main.student.show;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;
@WebServlet("/ShowStudentCalendar")
public class ShowStudentCalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String view = "/WEB-INF/jsp/Student/Student_Calendar.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoveBerryDispatcher.dispatch(request, response, view);
	}
}
