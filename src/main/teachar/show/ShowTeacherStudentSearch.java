package main.teachar.show;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;

@WebServlet("/ShowTeacherStudentSearch")
public class ShowTeacherStudentSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowTeacherStudentSearch() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Teacher/Teacher_Student_Search.jsp" );
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
