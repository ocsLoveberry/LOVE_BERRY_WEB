package main.teachar.show;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;
import javaBeans.OcsJohoData;
import main.dao.Search_OCS_JOHO_TBL_DAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

@WebServlet("/ShowTeacherStudentResultServlet")
public class ShowTeacherStudentResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowTeacherStudentResultServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String radio_Name_or_SekiNo = (String) request.getParameter("radio_Name_or_SekiNo");
		String student_name = (String) request.getParameter("text_Student_name");
		String seki_no = (String) request.getParameter("text_Student_SekiNo");
		ArrayList<OcsJohoData> studentData = new ArrayList<>();

		System.out.println("radio_Name_or_SekiNo:" + radio_Name_or_SekiNo);
		System.out.println("student_name:" + student_name);
		System.out.println("seki_no:" + seki_no);

		if (radio_Name_or_SekiNo.equals("select_sekiNo")) {
			System.out.println("select_sekiNo:true");
			Search_OCS_JOHO_TBL_DAO sojtd = new Search_OCS_JOHO_TBL_DAO();
			try {
				studentData = sojtd.search_OCS_JOHO_TBL_by_sekiNo(seki_no);
			} catch (DatabaseException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}

		} else if (radio_Name_or_SekiNo.equals("select_Name")) {
			System.out.println("select_Name:true");
			Search_OCS_JOHO_TBL_DAO sojtd = new Search_OCS_JOHO_TBL_DAO();
			try {
				studentData = sojtd.search_OCS_JOHO_TBL_by_name(student_name);
			} catch (DatabaseException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		System.out.println("studentData.isEmpty():" + studentData.isEmpty());
		request.setAttribute("studentData", studentData);
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Teacher/Teacher_Student_Searcher_Result.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}