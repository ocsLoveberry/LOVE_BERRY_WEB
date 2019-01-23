package main.admin;


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

@WebServlet("/CreateNewLobeServlet")
public class CreateNewLobeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CreateNewLobeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newLobeName = (String)request.getParameter("newLobeName");
		String installation_location = (String)request.getParameter("installation_location");
		Insert_LOBE_TBL_DAO iltdao = new Insert_LOBE_TBL_DAO();
		try {
			iltdao.Insert_LOBE_TBL(newLobeName, installation_location);
		} catch (DatabaseException | SystemException e) {
			e.printStackTrace();
		}
			LoveBerryDispatcher.dispatch(request, response, "WEB-INF/Lobe/Lobe_Search.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
