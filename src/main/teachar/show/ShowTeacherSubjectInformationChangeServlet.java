package main.teachar.show;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;
import javaBeans.JugyoTable;
import main.dao.JugyoTableDAO;

@WebServlet("/ShowTeacherSubjectInformationChangeServlet")
public class ShowTeacherSubjectInformationChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String view = "/WEB-INF/jsp/Teacher/Teacher_Subject_Infomation_Change.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject_cd = request.getParameter("subject_cd");
		String start_date = request.getParameter("start_date");
		String start_time_cd = request.getParameter("start_time_cd");
		ArrayList<JugyoTable> jugyoDetailOneLow = new ArrayList<>();
		JugyoTableDAO jugyoTableDao = new JugyoTableDAO();
//		エラー発生箇所↓ selcetwhere2臨時で作った
//		の作り直ししなきゃかも
//		やりたいこと
//		subject_cdとstart_dateとstart_time_cdでデータベースのJUGYO_TBLから一意に値を取得できるので
//		dao使って検索する。メソッドは未実装。selectwhereは一身上の都合により再利用不可。
//		データベースから取得した一件の値（テーブルのカラムすべて）を使ってjspのformに組み込む
//		画面はdiscordのイメージ
//		できれば、DBの値全件使ってformのselectから選んで変更できるようにしたい？

		jugyoDetailOneLow = jugyoTableDao.selectWhere2("SUBJECTS_CD = '" + subject_cd + "' and START_DATE = '" + start_date + "' and START_TIME_CD = '" + start_time_cd + "'");
		System.out.println(jugyoDetailOneLow.isEmpty());
		request.setAttribute("testLow", jugyoDetailOneLow);
		LoveBerryDispatcher.dispatch(request, response, view);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopst");
		doGet(request, response);
	}

}
