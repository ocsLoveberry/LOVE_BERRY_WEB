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

/**
 * Servlet implementation class ShowTop
 */
@WebServlet("/ShowTopServlet")
public class ShowTopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//topページ遷移したタイミングでsession開始+仮に他のsession情報持ってても破棄。
		//だからもしsession切れたらif(request.getSession(false))?でここ飛ばしたい
		HttpSession session = request.getSession(true);
		Enumeration e = session.getAttributeNames();
		while(e.hasMoreElements()) {
			String key = (String)e.nextElement();
			session.removeAttribute(key);
		}

		if (request.isUserInRole("1")){
			String view = "/WEB-INF/teacher_top.jsp";
		    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		    dispatcher.forward(request, response);

		}else if(request.isUserInRole("3")) {
			String view = "/WEB-INF/student_top.jsp";
		    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		    dispatcher.forward(request, response);

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
