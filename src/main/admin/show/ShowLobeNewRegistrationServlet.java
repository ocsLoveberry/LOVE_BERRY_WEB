package main.admin.show;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;

@WebServlet("/ShowLobeNewRegistrationServlet")
public class ShowLobeNewRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowLobeNewRegistrationServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/Lobi/Lobe_New_Registration.jsp");
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
