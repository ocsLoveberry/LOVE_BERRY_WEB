package main.teachar.show;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dispatcher.LoveBerryDispatcher;

@WebServlet("/ShowAddSubjectsServlet")
public class ShowAddSubjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowAddSubjectsServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("seki_no") == null) {
			LoveBerryDispatcher.dispatch(request, response, "ShowTopServlet");
		}else {
			LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/add_subjects.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
