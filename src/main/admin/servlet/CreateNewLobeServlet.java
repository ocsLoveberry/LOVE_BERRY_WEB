package main.admin.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;
import main.dao.Insert_LOBE_TBL_DAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

/**
 * Servlet implementation class CreateNewLobeServlet
 */
@WebServlet("/CreateNewLobeServlet")
public class CreateNewLobeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewLobeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newLobeName = (String)request.getParameter("newLobeName");
		String installation_location = (String)request.getParameter("installation_location");
		int result = 0;
		Insert_LOBE_TBL_DAO iltdao = new Insert_LOBE_TBL_DAO();
		try {
			result = iltdao.Insert_LOBE_TBL(newLobeName, installation_location);
		} catch (DatabaseException | SystemException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
			LoveBerryDispatcher.dispatch(request, response, "WEB-INF/lobe_search.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
