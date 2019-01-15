package main.teachar.servlet;

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

/**
 * Servlet implementation class ShowJikanwariServlet
 */
@WebServlet("/CreateJikanwariServlet")
public class CreateJikanwariServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateJikanwariServlet() {
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
			String view = "/WEB-INF/create_jikanwari.jsp";
			ClassCountDAO countdao = new ClassCountDAO();
			String seki_no = request.getRemoteUser();
			try {
				request.setAttribute("CountClass", countdao.counts(seki_no));
			} catch (DatabaseException | SystemException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			LoveBerryDispatcher.dispatch(request, response, view);
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
