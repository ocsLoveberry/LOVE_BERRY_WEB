package main.admin.show;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;
import main.dao.TeacherDetailDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

@WebServlet(description = "教員検索詳細画面への遷移用サーブレット", urlPatterns = { "/ShowTeacherDetailServlet" })
public class ShowTeacherDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowTeacherDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String seki_no = (String)request.getParameter("seki_no");
		TeacherDetailDAO tsDetailDAO = new TeacherDetailDAO();
		try {
			request.setAttribute("teacherDetail", tsDetailDAO.getStudentDetail(seki_no));
		} catch (DatabaseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Admin/Admin_Teacher_Detail.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
