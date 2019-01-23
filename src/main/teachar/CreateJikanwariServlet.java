package main.teachar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dispatcher.LoveBerryDispatcher;
import main.dao.ClassCountDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

@WebServlet("/CreateJikanwariServlet")
public class CreateJikanwariServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CreateJikanwariServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("seki_no") == null) {
			String view = "ShowTopServlet";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		    dispatcher.forward(request, response);
		}else {
			String view = "/WEB-INF/Teacher/Create_Jikanwari.jsp";
			ClassCountDAO countdao = new ClassCountDAO();
			String seki_no = request.getRemoteUser();
			try {
				request.setAttribute("CountClass", countdao.counts(seki_no));
			} catch (DatabaseException | SystemException e) {
				e.printStackTrace();
			}
			LoveBerryDispatcher.dispatch(request, response, view);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
