/**
 *
 * SUBJECTS_TBLにあるsubject_cdをJUGYO_TBLに追加できる
 * JUGYO_TBLにあるtokutei_cdを、JIKANWARI_TBLのtokutei_cdに追加できる
 * CLASS_TBLにあるclass_cdをJIKANWARI_TBLのclass_CDに追加できる
 *
 * JUGYO_TBLのtokutei_cdはJUGYO_TBLの3カラムの組み合わせ（一意）つまり同じ日の同じ時間には時間割は登録できない
 * @author 154139
 *
 * testData
 * subject_cd: insertCalendaerTestSubject
 *
 *
 */

package calendar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.dao.JikanwarTablelDAO;
import main.dao.JugyoTableDAO;
@WebServlet("/CalendarAddSubjectServlet")
public class CalendarAddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject_cd = request.getParameter("subject_cd");
		String start_date = request.getParameter("start_date");
		String start_time_cd = request.getParameter("start_time_cd");
		String room_cd1 = request.getParameter("room_cd1");
		String room_cd2 = request.getParameter("room_cd2");
		String room_cd3 = request.getParameter("room_cd3");
		String comment = request.getParameter("comment");
		String tokutei_cd = subject_cd + start_date + start_time_cd;
		System.out.println(subject_cd);
		System.out.println(start_date);
		System.out.println(start_time_cd);
		System.out.println(room_cd1);
		System.out.println(room_cd2);
		System.out.println(room_cd3);
		System.out.println(comment);

		JugyoTableDAO jugyoTableDao = new JugyoTableDAO();
		boolean insertOk = jugyoTableDao.insert(subject_cd,start_date,start_time_cd,tokutei_cd,room_cd1,room_cd2,room_cd3,comment);
		if(insertOk) {
			System.out.println("jugyoTblOK");
		}
		JikanwarTablelDAO jikanwariTbl = new JikanwarTablelDAO();
		insertOk = jikanwariTbl.insert("R4A1System", start_date, start_time_cd, tokutei_cd);
		if(insertOk) {
			System.out.println("JikawariTblOK");
		}
		response.getWriter().write("test");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
