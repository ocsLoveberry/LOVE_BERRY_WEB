package calendar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import javaBeans.JikanwariData;
import main.dao.TimeTableDAO;

/**
 * Servlet implementation class TestCalendar
 */
@WebServlet("/TestCalendar")
public class TestCalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestCalendar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 手順
		 * ①DAOを使ってデータベースから時間割を取得(戻り値がcalendarDTO)
		 * ②カレンダーリストに登録して addするメソッドを作る
		 * ③JSONデータに加工
		 * ④PrintWriterで表示する
		 */
		System.out.println("動作チェック@loveberryweb");
		TimeTableDAO timeTableDao = new TimeTableDAO();
		ArrayList<JikanwariData> calendarList = new ArrayList<JikanwariData>();
		calendarList = timeTableDao.getJikanwari();
		setResponseSettings(response);
		checkListContents(calendarList);
		PrintWriter out = response.getWriter();
		out.write(new Gson().toJson(calendarList));
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void setResponseSettings(HttpServletResponse response) {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	}

	JikanwariData betunoyarikata(ArrayList<JikanwariData> calendarList){
		JikanwariData j1 = new JikanwariData();
		j1.setTitle(calendarList.get(0).getTitle());
		j1.setStart(calendarList.get(0).getStart());
		return j1;

	}

	void checkListContents(ArrayList<JikanwariData> calendarList){
		for(JikanwariData jikanwari: calendarList) {
			System.out.println("title:"+jikanwari.getTitle());
			System.out.println("start:"+jikanwari.getStart());
			System.out.println("end:"+jikanwari.getEnd());
			System.out.println("color:"+jikanwari.getColor());
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
