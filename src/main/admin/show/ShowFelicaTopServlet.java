package main.admin.show;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;
import javaBeans.FelicaData;
import main.dao.FelicaTableDAO;

@WebServlet("/ShowFelicaTopServlet")
public class ShowFelicaTopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowFelicaTopServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FelicaTableDAO ftdao = new FelicaTableDAO();
		ArrayList<FelicaData> felicaData = ftdao.selectAllFelicaTable();
		request.setAttribute("felicaData", felicaData);
		LoveBerryDispatcher.dispatch(request, response, "WEB-INF/Felica/Felica_top.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
