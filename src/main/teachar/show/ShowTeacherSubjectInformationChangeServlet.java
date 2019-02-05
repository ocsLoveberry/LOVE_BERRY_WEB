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

@WebServlet("/ShowTeacherSubjectInformationChangeServlet")
public class ShowTeacherSubjectInformationChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String view = "/WEB-INF/jsp/Teacher/Teacher_Subject_Infomation_Change.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//	String subject_cd = request.getParameter("subject_cd");
		//	String start_date = request.getParameter("start_date");
		//	String start_time_cd = request.getParameter("start_time_cd");
		//	String Jugyo_cnt = request.getParameter("Jugyo_cnt");
		String tokutei_cd = request.getParameter("tokutei_cd");
		ArrayList<JugyoTable> jugyoDetailList = new ArrayList<>();
		JugyoTableDAO jugyoTableDao = new JugyoTableDAO();

		System.out.println("tokutei_cd:" + tokutei_cd);
		jugyoDetailList = jugyoTableDao.Jugyo_Detail(tokutei_cd);
		System.out.println("jugyoDetailOneLowの値は:" + jugyoDetailList);

		request.setAttribute("jugyoDetailList", jugyoDetailList);
		LoveBerryDispatcher.dispatch(request, response, view);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopst");
		doGet(request, response);
	}
}
