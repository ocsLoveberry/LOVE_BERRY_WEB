package main.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dispatcher.LoveBerryDispatcher;
import javaBeans.OcsJohoData;
import javaBeans.TeacherSearchBeans;
import main.dao.Admin_Detail_deleteDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

@WebServlet("/ShowDetailUpdateResultServret")
public class ShowDetailUpdateResultServret extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowDetailUpdateResultServret() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String checkbox = (String) request.getParameter("update_idm_btn");
		String seki_no = (String) session.getAttribute("seki_no");
		String Confirm = (String) request.getParameter("Confirm");
		ArrayList<TeacherSearchBeans> teacherdate = (ArrayList<TeacherSearchBeans>) session.getAttribute("teacherDate");
		ArrayList<OcsJohoData> studentlist = (ArrayList<OcsJohoData>) session.getAttribute("studentlist");
		System.out.println("checkbox:" + checkbox);
		System.out.println("seki_no:" + seki_no);
		System.out.println("Confirm:" + Confirm);
		System.out.println("teacher:" + teacherdate);

		if ("確定".equals(Confirm)) {
			System.out.println("CONfirmの値が確定の時は表示 Confirmの値:"+Confirm);
			if ("idm1".equals(checkbox)) {
				System.out.println("checkboxがidm1のときreturn true 値は:");
				try {
					System.out.println("try実行しました");
					Admin_Detail_deleteDAO adDAO = new Admin_Detail_deleteDAO();
					adDAO.Admin_Detail_deleteDAO(seki_no);
					System.out.println("felicaの値をdeleteできました");
				} catch (DatabaseException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		if (teacherdate != null) {
			request.setAttribute("teacherDate", teacherdate);
			LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Admin/Admin_Teacher_Search_Result.jsp");
		} else {
			System.out.println("studentdata:" + studentlist);
			request.setAttribute("studentData", studentlist);
			LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Admin/Admin_StudentSearch_Result.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
