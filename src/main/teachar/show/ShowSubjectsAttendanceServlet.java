package main.teachar.show;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dispatcher.LoveBerryDispatcher;
import javaBeans.JugyoTable;
import main.dao.JugyoTableDAO;
import main.dao.SearchSubjectsNameDAO;

@WebServlet("/ShowSubjectsAttendanceServlet")
public class ShowSubjectsAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowSubjectsAttendanceServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String where = (String) session.getAttribute("Subjects_cd");
		System.out.println("whereの値は:"+where);
		System.out.println("print確認");
		System.out.println(where);
		ArrayList<JugyoTable> jugyo;
		JugyoTableDAO jugyoTableDao  = new JugyoTableDAO();
		jugyo = jugyoTableDao.selectWhere(where);
		//現在の登録されている授業回数取得
		int jugyo_count = jugyo.size();
		SearchSubjectsNameDAO searchSubjectsNameDAO = new SearchSubjectsNameDAO();
		String subjects_name = "";
		/*
		try {
			//授業名取得しておく
			subjects_name = searchSubjectsNameDAO.search_subjects_name(where);
		} catch (DatabaseException | SystemException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		*/
		request.setAttribute("subjects_name",subjects_name);
		request.setAttribute("jugyo_count",jugyo_count);
		request.setAttribute("jugyo", jugyo);
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Teacher/Subjects_Attendance.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
