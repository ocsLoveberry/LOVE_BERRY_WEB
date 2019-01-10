package main;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dispatcher.LoveBerryDispatcher;

/**
 * Servlet implementation class JugyoDetailServlet
 */
@WebServlet("/JugyoDetailServlet")
public class JugyoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JugyoDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("seki_no") == null) {
			String view = "ShowTopServlet";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		    dispatcher.forward(request, response);
		}else {
			String branch = request.getParameter("result").toString();
			//修正ボタンか、OKボタンか
			if(branch.equals("revise")) {
				//修正ボタン
				LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/revise_jugyo.jsp");
			}else{
				//OKボタン
				Enumeration e = session.getAttributeNames();
				while(e.hasMoreElements()) {
					String key = (String)e.nextElement();
					if(!key.equals("seki_no")) {
						session.removeAttribute(key);
					}
				}
				LoveBerryDispatcher.dispatch(request, response, "CreateJikanwariServlet");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
