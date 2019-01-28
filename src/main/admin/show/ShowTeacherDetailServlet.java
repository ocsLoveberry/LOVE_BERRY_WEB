package main.admin.show;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;

@WebServlet(description = "教員検索詳細画面への遷移用サーブレット", urlPatterns = { "/ShowTeacherDetailServlet" })
public class ShowTeacherDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowTeacherDetailServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Admin/Admin_Teacher_Detail.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
