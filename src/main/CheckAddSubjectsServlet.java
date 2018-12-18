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
 * Servlet implementation class CheckAddSubjectsServlet
 */
@WebServlet("/CheckAddSubjectsServlet")
public class CheckAddSubjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAddSubjectsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String room_cd1 = request.getParameter("room_cd1");
		String room_cd2 = request.getParameter("room_cd2");
		String room_cd3 = request.getParameter("room_cd3");
		HttpSession session = request.getSession(false);
		if(session.getAttribute("seki_no") == null) {
			String view = "ShowTopServlet";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		    dispatcher.forward(request, response);
		}else {
			if(room_cd1.equals("nothing") && room_cd2.equals("nothing") && room_cd3.equals("nothing") || room_cd1.equals(room_cd2) && !room_cd1.equals("nothing") || room_cd1.equals(room_cd3) && !room_cd1.equals("nothing") || room_cd2.equals(room_cd3) && !room_cd2.equals("nothing")) {
				String view = "ShowCreateJugyoServlet";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			    dispatcher.forward(request, response);
			}else {
				if(!room_cd1.equals("nothing")) {
					session.setAttribute("room_cd1",room_cd1);
				}
				if(!room_cd2.equals("nothing")) {
					session.setAttribute("room_cd2",room_cd2);
				}
				if(!room_cd3.equals("nothing")) {
					session.setAttribute("room_cd3",room_cd3);
				}
				//確認ページに飛ばしたい
				String view = "/WEB-INF/check_add_subjects.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			    dispatcher.forward(request, response);
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
