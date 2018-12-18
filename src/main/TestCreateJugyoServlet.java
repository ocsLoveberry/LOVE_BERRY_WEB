package main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestCreateJugyoServlet
 */
@WebServlet("/TestCreateJugyoServlet")
public class TestCreateJugyoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestCreateJugyoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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

		String view = "/WEB-INF/test_create_jugyo.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
