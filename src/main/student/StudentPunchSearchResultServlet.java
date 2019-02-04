/**
 * @author ace
 */

package main.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;
import main.dao.StudentPunchSearchDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;
@WebServlet("/StudentPunchSearchResultServlet")
public class StudentPunchSearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StudentPunchSearchResultServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formEntryDate = request.getParameter("formEntryDate");
		String formClassroom = request.getParameter("formClassroom");
		String seki_no  = request.getRemoteUser();
		List<String[]> resultStudentPunch = null;
		StudentPunchSearchDAO spsdao = new StudentPunchSearchDAO();
		try {
			resultStudentPunch = spsdao.searchStudentPunch(seki_no, formEntryDate, formClassroom);
		} catch (DatabaseException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}

//		指定した日時に打刻があれば
		if(!resultStudentPunch.isEmpty()) {
			request.setAttribute("resultStudentPunch", resultStudentPunch);
			LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Student/Student_Punch_Search_Result.jsp");
//	    指定した日時に打刻がなければ
		}else {
			request.setAttribute("isError", "true");
			LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Student/Student_Punch_Search.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
