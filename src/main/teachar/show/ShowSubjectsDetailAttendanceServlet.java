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
import main.dao.CheckPunchDAO;
import main.dao.JugyoTableDAO;
import main.dao.SearchSubjectsNameDAO;
import main.dao.Search_OCS_JOHO_TBL_DAO;
import main.dao.Search_studentDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

@WebServlet("/ShowSubjectsDetailAttendanceServlet")
public class ShowSubjectsDetailAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowSubjectsDetailAttendanceServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjects_cd = request.getParameter("subjects_cd");
		int jugyo_no = Integer.parseInt(request.getParameter("jugyo_no"));
		Search_OCS_JOHO_TBL_DAO search_OCS_JOHO_TBL_DAO = new Search_OCS_JOHO_TBL_DAO();
		Search_studentDAO search_studentDAO = new Search_studentDAO();
		JugyoTableDAO jugyoTableDao  = new JugyoTableDAO();
		CheckPunchDAO checkPunchDAO = new CheckPunchDAO();
		SearchSubjectsNameDAO searchSubjectsNameDAO = new SearchSubjectsNameDAO();
		ArrayList<JugyoTable> jugyo;
		String subjects_name = "";
		ArrayList<String> seki_no_List = null;
		ArrayList<String> name_List = null;
		ArrayList<String> comment_List = null;

		//授業情報取得
		jugyo = jugyoTableDao.selectWhere(subjects_cd);
		//現在の登録されている授業回数取得
		int jugyo_count = jugyo.size();

		//授業回数だけのstatus保管用リスト作成
		String[] temp_status = new String[jugyo_count];
		String[] status = new String[jugyo_count];

		try {
			//授業受講してる学籍番号取得
			seki_no_List = search_studentDAO.search_student(subjects_cd);
			//学籍番号を名前に
			name_List = search_studentDAO.to_name(seki_no_List);
			//コメント取得
			comment_List = search_studentDAO.comment_get(seki_no_List,jugyo.get(jugyo_no-1).getSubjects_cd(),jugyo.get(jugyo_no-1).getStart_date(),jugyo.get(jugyo_no-1).getStart_time_cd());
			//status取得
			for(int i=0;i<seki_no_List.size();i++) {
				temp_status[i] = checkPunchDAO.check_temp_status(seki_no_List.get(i),jugyo.get(jugyo_no-1).getSubjects_cd(),jugyo.get(jugyo_no-1).getStart_date(),jugyo.get(jugyo_no-1).getStart_time_cd());
				status[i] = checkPunchDAO.check_status(seki_no_List.get(i),jugyo.get(jugyo_no-1).getSubjects_cd(),jugyo.get(jugyo_no-1).getStart_date(),jugyo.get(jugyo_no-1).getStart_time_cd());
			}
			//授業名取得
			subjects_name = searchSubjectsNameDAO.search_subjects_name(subjects_cd);
		} catch (DatabaseException | SystemException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		request.setAttribute("jugyo", jugyo);
		request.setAttribute("jugyo_no",jugyo_no);
		request.setAttribute("jugyo_count",jugyo_count);
		request.setAttribute("subjects_name",subjects_name);
		request.setAttribute("seki_no_List",seki_no_List);
		request.setAttribute("name_List",name_List);
		request.setAttribute("comment_List",comment_List);
		request.setAttribute("status",status);
		request.setAttribute("temp_status",temp_status);
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Teacher/Subjects_Detail_Attendance.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}