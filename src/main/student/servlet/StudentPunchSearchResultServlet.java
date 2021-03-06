/**
 * @author ace
 */

package main.student.servlet;

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

/**
 * Servlet implementation class StudentPunchSearchServlet
 */
@WebServlet("/StudentPunchSearchResultServlet")
public class StudentPunchSearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentPunchSearchResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
//		list<[SEKI_NO],[ENTRY_DATE],[LOBE_ID]>
//		取り出し方 resultStuPunch.get(int index【range 0 ~】)[int index【range 0 ~ 2】]
//		ex)resultStuPunch.get(0)[0]
//		解説)listの0番目に入ってるStringの配列の0番目の要素を取り出す
//		System.out.println("StudentPunchSearchResultServlet get:"+resultStudentPunch.get(0)[0]);
//		System.out.println("StudentPunchSearchResultServlet get:"+resultStudentPunch.get(0)[1]);
//		System.out.println("StudentPunchSearchResultServlet get:"+resultStudentPunch.get(0)[2]);

//		指定した日時に打刻があれば
		if(!resultStudentPunch.isEmpty()) {
			request.setAttribute("resultStudentPunch", resultStudentPunch);
			LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/student_punch_search_result.jsp");
//	    指定した日時に打刻がなければ
		}else {
			request.setAttribute("isError", "true");
			LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/student_punch_search.jsp");
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
