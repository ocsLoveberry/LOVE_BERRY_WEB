package main.teachar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dispatcher.LoveBerryDispatcher;

@WebServlet("/CheckAddSubjectsServlet")
public class CheckAddSubjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CheckAddSubjectsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String room_cd1 = request.getParameter("room_cd1");
		String room_cd2 = request.getParameter("room_cd2");
		String room_cd3 = request.getParameter("room_cd3");
		HttpSession session = request.getSession(false);
		if(session.getAttribute("seki_no") == null) {
			LoveBerryDispatcher.dispatch(request, response, "ShowTopServlet");
		}else {
			if(room_cd1.equals("nothing") && room_cd2.equals("nothing") && room_cd3.equals("nothing") || room_cd1.equals(room_cd2) && !room_cd1.equals("nothing") || room_cd1.equals(room_cd3) && !room_cd1.equals("nothing") || room_cd2.equals(room_cd3) && !room_cd2.equals("nothing")) {
				LoveBerryDispatcher.dispatch(request, response, "ShowCreateJugyoServlet");
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
				LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Teacher/Check_Add_Subjects.jsp");
			}
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
