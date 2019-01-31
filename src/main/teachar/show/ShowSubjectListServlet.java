package main.teachar.show;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;
import javaBeans.ClassSubjects;
import main.dao.ClassSubjectsDAO;

@WebServlet("/ShowSubjectListServlet")
public class ShowSubjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowSubjectListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dao
		ClassSubjectsDAO classSubjectsDAO = new ClassSubjectsDAO();
		ArrayList<ClassSubjects> classSubject = classSubjectsDAO.selectAll();
		//req.setpara
		request.setAttribute("classSubject", classSubject);
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Teacher/Teachar_Subject_List.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
