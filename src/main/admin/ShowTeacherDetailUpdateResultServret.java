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
import javaBeans.TeacherSearchBeans;
import main.dao.Admin_Detail_deleteDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

/*admin_teacher_detailのcheckboxを指定されているときに
 *確定が押されたらIDM1の値をnullに更新してresultページに
 *飛ばすんじゃ！
 */
@WebServlet("/ShowTeacherDetailUpdateResultServret")
public class ShowTeacherDetailUpdateResultServret extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ShowTeacherDetailUpdateResultServret() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String checkbox = (String) request.getParameter("update_idm_btn");
		String seki_no = (String) session.getAttribute("seki_no");
		String Confirm = (String) request.getParameter("Confirm");
		ArrayList<TeacherSearchBeans> teacherdate = (ArrayList<TeacherSearchBeans>) session.getAttribute("teacherDate");

		if (Confirm != "null") {
			if ("idm1".equals(checkbox)) {
				try {
					System.out.println("try実行しました");
					Admin_Detail_deleteDAO adDAO = new Admin_Detail_deleteDAO();
					adDAO.Admin_Detail_deleteDAO(seki_no);
				} catch (DatabaseException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		request.setAttribute("teacherDate", teacherdate);
		System.out.println("update_idm");
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Admin/Admin_Teacher_Search_Result.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
