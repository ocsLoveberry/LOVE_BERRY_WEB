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

@WebServlet("/ShowTeacherSubjectListServlet")
public class ShowTeacherSubjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String view = "/WEB-INF/jsp/Teacher/Teacher_Subject_List.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dao
		ClassSubjectsDAO classSubjectsDAO = new ClassSubjectsDAO();
		ArrayList<ClassSubjects> classSubject = classSubjectsDAO.selectAll();
		//req.setpara
		request.setAttribute("classSubject", classSubject);
		LoveBerryDispatcher.dispatch(request, response, view);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
