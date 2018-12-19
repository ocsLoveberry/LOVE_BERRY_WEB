package main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowStudentPunchSearchServlet
 */
@WebServlet("/ShowStudentSearchServlet")
public class ShowStudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudentSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

//    ログインセッションの有無の確認
//    打刻検索画面への遷移
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession(false);
//		if(session.getAttribute("seki_no") == null) {
//			String view = "ShowTopServlet";
//			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//		    dispatcher.forward(request, response);
//		}else {
		String view = "/WEB-INF/admin_studentSearch.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	    dispatcher.forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
