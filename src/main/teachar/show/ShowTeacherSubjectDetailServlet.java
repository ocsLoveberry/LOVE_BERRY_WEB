package main.teachar.show;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;

@WebServlet("/ShowTeacherSubjectDetailServlet")
public class ShowTeacherSubjectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String view = "/WEB-INF/jsp/Teacher/Teacher_Subject_Detail.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println(request.getParameter("subject_cd"));
		System.out.println(request.getParameter("start_date"));
		System.out.println(request.getParameter("start_time"));

		LoveBerryDispatcher.dispatch(request, response, view);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
