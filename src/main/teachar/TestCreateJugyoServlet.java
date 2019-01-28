package main.teachar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dispatcher.LoveBerryDispatcher;
@WebServlet("/TestCreateJugyoServlet")
public class TestCreateJugyoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TestCreateJugyoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//とりあえず中身勝手に指定
		HttpSession session = request.getSession(true);
		session.setAttribute("Nitiji", "2018-04-01");
		session.setAttribute("Jigen", "1");
		session.setAttribute("Class", "R4A1System");
		String year = session.getAttribute("Nitiji").toString();
		String check_year = year.substring(5,7);
		year = year.substring(0,4);
		//1月2月3月の時に年度なので-1年する
		if(check_year.equals("01") || check_year.equals("02") || check_year.equals("03")){
			year = String.valueOf(Integer.parseInt(year) - 1);
		}
		session.setAttribute("year",year);

		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Teacher/Test_Create_Jugyo.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
