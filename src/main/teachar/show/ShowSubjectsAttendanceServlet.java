package main.teachar.show;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dispatcher.LoveBerryDispatcher;
import javaBeans.JugyoTable;
import main.dao.JugyoTableDAO;
import main.dao.SearchSubjectsNameDAO;
import main.dao.Search_studentDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

@WebServlet("/ShowSubjectsAttendanceServlet")
public class ShowSubjectsAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowSubjectsAttendanceServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

        String where = (String) session.getAttribute("Subjects_cd");
		System.out.println(where);
		ArrayList<JugyoTable> jugyo;
		ArrayList<String> seki_no_List = null;
		ArrayList<String> name_List = null;
		String subjects_name = "";

		JugyoTableDAO jugyoTableDao  = new JugyoTableDAO();
		SearchSubjectsNameDAO searchSubjectsNameDAO = new SearchSubjectsNameDAO();
		Search_studentDAO search_studentDAO = new Search_studentDAO();

		//SELECT * FROM JUGYO_TBL WHERE SUBJECTS_CD = ?のリストを配列でjugyoに格納
		jugyo = jugyoTableDao.selectWhere(where);
		//現在の登録されている授業回数取得
		int jugyo_count = jugyo.size();

		try {
			//授業名取得
			subjects_name = searchSubjectsNameDAO.search_subjects_name(where);
			//授業受講してる学籍番号取得
			seki_no_List = search_studentDAO.search_student(where);
			//学籍番号を名前に
			name_List = search_studentDAO.to_name(seki_no_List);

		} catch (DatabaseException | SystemException e) {
			e.printStackTrace();
		}
		request.setAttribute("subjects_name",subjects_name);
		request.setAttribute("jugyo_count",jugyo_count);
		request.setAttribute("jugyo", jugyo);
		request.setAttribute("seki_no_List", seki_no_List);
		request.setAttribute("name_List", name_List);
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Teacher/Subjects_Attendance.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
