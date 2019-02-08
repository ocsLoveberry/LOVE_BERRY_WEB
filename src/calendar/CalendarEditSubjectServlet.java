package calendar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBeans.JugyoTable;
import main.dao.JugyoTableDAO;

/**
 * Servlet implementation class CalendarEditSubjectServlet
 */
@WebServlet("/CalendarEditSubjectServlet")
public class CalendarEditSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject_cd = request.getParameter("subject_cd");
		String start_date = request.getParameter("start_date");
		String start_time_cd = request.getParameter("start_time_cd");
		String tokutei_cd = subject_cd + start_date + start_time_cd;

		JugyoTable jugyoData = new JugyoTable();
		jugyoData.setSubjects_cd(request.getParameter("subject_cd"));
		jugyoData.setStart_date(request.getParameter("start_date"));
		jugyoData.setStart_time_cd(request.getParameter("start_time_cd"));
		jugyoData.setRoom_cd1(request.getParameter("room_cd1"));
		jugyoData.setRoom_cd2(request.getParameter("room_cd2"));
		jugyoData.setRoom_cd3(request.getParameter("room_cd3"));
		jugyoData.setComment(request.getParameter("comment"));
		jugyoData.setTokutei_cd(tokutei_cd);
		JugyoTableDAO jugyoTableDao = new JugyoTableDAO();
		jugyoTableDao.update(jugyoData);

	}

}
