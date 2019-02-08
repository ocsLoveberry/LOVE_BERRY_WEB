/**
 * 生徒用のみ
 * 出席日とその科目の単位数
 *
 */

package calendar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import javaBeans.JugyoTable;
import main.dao.JugyoTableDAO;
import main.dao.TimeStatusTableDAO;


/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/CalendarDetailServlet")
public class CalendarDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plan");
		response.setCharacterEncoding("UTF-8");
		String seki_no = request.getParameter("seki_no");
		String tokutei_cd = request.getParameter("tokutei_cd");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String subject_cd = cutSubjectCd(tokutei_cd);

		JugyoTableDAO jugyoTableDao = new JugyoTableDAO();
		ArrayList<JugyoTable> JugyoList = jugyoTableDao.Jugyo_Detail(tokutei_cd);
		String room_cd1 = JugyoList.get(0).getRoom_cd1();
		String room_cd2 = JugyoList.get(0).getRoom_cd2();
		String room_cd3 = JugyoList.get(0).getRoom_cd3();

		TimeStatusTableDAO tdao = new TimeStatusTableDAO();
		int count = tdao.selectCount(seki_no,subject_cd);
		ArrayList<SubjectJsonData> testJsonList = new ArrayList<>();
		testJsonList.add(new SubjectJsonData(subject_cd,start,end,count,room_cd1,room_cd2,room_cd3));
//		return jsonファイルとしてリターン！！
		response.getWriter().println(new Gson().toJson(testJsonList));
	}

	private String cutSubjectCd(String tokutei_cd) {
		int strLength = tokutei_cd.length() - 11; //特定コード下11桁。2099-99-990で11桁
		return tokutei_cd.substring(0,strLength);
	}
	@SuppressWarnings("unused")
	private void debug(String... param) {
//		System.out.println(strLength);
//		System.out.println("seki_no:" + request.getParameter("seki_no"));
//		System.out.println("subjects_cd:" + request.getParameter("subjectID"));
//		System.out.println("subject_cd:"+subject_cd);
	}
}

