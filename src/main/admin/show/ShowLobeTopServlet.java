package main.admin.show;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;

/**
 * Servlet implementation class showLobeTopServlet
 */
@WebServlet("/ShowLobeTopServlet")
public class ShowLobeTopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowLobeTopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-gener
//		HttpSession session = request.getSession(false);
//		if(session.getAttribute("seki_no") == null) {
//			String view = "ShowTopServlet";
//			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//		    dispatcher.forward(request, response);
//		}else {
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/lobe_search.jsp");
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
