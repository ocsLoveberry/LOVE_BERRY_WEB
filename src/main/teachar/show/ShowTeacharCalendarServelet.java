package main.teachar.show;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;

@WebServlet("/ShowTeacharCalendarServelet")
public class ShowTeacharCalendarServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String view = "/Teachar_Calendar.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoveBerryDispatcher.dispatch(request, response, view);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
