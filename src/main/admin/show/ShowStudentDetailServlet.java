package main.admin.show;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;
import main.dao.studentDetailDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

@WebServlet("/ShowStudentDetailServlet")
public class ShowStudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowStudentDetailServlet() {
        super();
    }

//    ログインセッションの有無の確認
//    打刻検索画面への遷移
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//		学生詳細情報を表示するためのデータベースの処理を書いたプログラム呼び出す
		String seki_no = (String)request.getParameter("seki_no");
		studentDetailDAO sdDAO = new studentDetailDAO();
		try {
			request.setAttribute("studentDetail", sdDAO.getStudentDetail(seki_no));
		} catch (DatabaseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
//		学生詳細情報画面を表示させる
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/Admin/Admin_Student_Detail.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
