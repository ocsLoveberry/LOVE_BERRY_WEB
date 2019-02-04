package main.teachar.show;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;
import javaBeans.JugyoTable;
import main.dao.JugyoTableDAO;

@WebServlet("/ShowTeacherSubjectListServlet")
public class ShowTeacherSubjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String view = "/WEB-INF/jsp/Teacher/Teacher_Subject_Detail.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String where = request.getParameter("where");
		System.out.println("show:" + where );
		ArrayList<JugyoTable> jugyo;
		JugyoTableDAO jugyoTableDao  = new JugyoTableDAO();
		jugyo = jugyoTableDao.selectWhere(where);
		request.setAttribute("jugyo", jugyo);
		LoveBerryDispatcher.dispatch(request, response, view);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
