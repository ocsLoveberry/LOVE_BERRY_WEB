package main.admin.show;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;

@WebServlet("/ShowStudentSearchServlet")
public class ShowStudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowStudentSearchServlet() {
        super();
    }

//    ログインセッションの有無の確認
//    打刻検索画面への遷移
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Admin/Admin_StudentSearch.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
