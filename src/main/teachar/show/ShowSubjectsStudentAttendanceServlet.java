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
import javaBeans.OcsJohoData;
import main.dao.CheckPunchDAO;
import main.dao.JugyoTableDAO;
import main.dao.SearchSubjectsNameDAO;
import main.dao.Search_OCS_JOHO_TBL_DAO;
import main.dao.Search_studentDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

@WebServlet("/ShowSubjectsStudentAttendanceServlet")
public class ShowSubjectsStudentAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowSubjectsStudentAttendanceServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjects_cd = request.getParameter("subjects_cd");
		String seki_no = request.getParameter("seki_no");
		Search_OCS_JOHO_TBL_DAO search_OCS_JOHO_TBL_DAO = new Search_OCS_JOHO_TBL_DAO();
		Search_studentDAO search_studentDAO = new Search_studentDAO();
		JugyoTableDAO jugyoTableDao  = new JugyoTableDAO();
		CheckPunchDAO checkPunchDAO = new CheckPunchDAO();
		SearchSubjectsNameDAO searchSubjectsNameDAO = new SearchSubjectsNameDAO();
		ArrayList<OcsJohoData> ocsJohoData = null;
		ArrayList<JugyoTable> jugyo;
		String subjects_name = "";

		//授業情報取得
		jugyo = jugyoTableDao.selectWhere(subjects_cd);
		//現在の登録されている授業回数取得
		int jugyo_count = jugyo.size();

		//授業回数だけのstatus保管用リスト作成
		String[] temp_status = new String[jugyo_count];
		String[] status = new String[jugyo_count];

		try {
			//学生情報取得
			ocsJohoData = search_OCS_JOHO_TBL_DAO.search_OCS_JOHO_TBL_by_sekiNo(seki_no);
			//授業名取得
			subjects_name = searchSubjectsNameDAO.search_subjects_name(subjects_cd);
			for(int i=0;i<jugyo_count;i++) {
				temp_status[i] = checkPunchDAO.check_temp_status(seki_no,jugyo.get(i).getSubjects_cd(),jugyo.get(i).getStart_date(),jugyo.get(i).getStart_time_cd());
				status[i] = checkPunchDAO.check_status(seki_no,jugyo.get(i).getSubjects_cd(),jugyo.get(i).getStart_date(),jugyo.get(i).getStart_time_cd());
			}
		} catch (DatabaseException | SystemException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//status[],temp_status[]を

		request.setAttribute("status",status);
		request.setAttribute("temp_status",temp_status);
		request.setAttribute("subjects_name",subjects_name);
		request.setAttribute("jugyo_count",jugyo_count);
		request.setAttribute("ocsJohoData",ocsJohoData);
		request.setAttribute("jugyo", jugyo);
		//request.setAttribute("seki_no",seki_no);
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Teacher/Subjects_Student_Attendance.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}