package main.teachar;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.dao.RemoveJugyoDAO;
import main.dao.SetTimeContentDAO;
import main.dao.TimeStatusDAO;
import main.dao.UpdateJugyoDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

/**
 * Servlet implementation class ReviseJugyoServlet
 */
@WebServlet("/ReviseJugyoServlet")
public class ReviseJugyoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviseJugyoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String room_cd1 = (String)request.getParameter("room_cd1");
		String room_cd2 = (String)request.getParameter("room_cd2");
		String room_cd3 = (String)request.getParameter("room_cd3");
		if(session.getAttribute("seki_no") == null) {
			String view = "ShowTopServlet";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		    dispatcher.forward(request, response);
		}else {
			String branch = request.getParameter("result").toString();
			if(branch.equals("revise")) {
				//修正ボタン
				if(room_cd1.equals("nothing") && room_cd2.equals("nothing") && room_cd3.equals("nothing")
						|| room_cd1.equals(room_cd2) && !room_cd1.equals("nothing")
						|| room_cd1.equals(room_cd3) && !room_cd1.equals("nothing")
						|| room_cd2.equals(room_cd3) && !room_cd2.equals("nothing")){
					String view = "/WEB-INF/revise_jugyo.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				    dispatcher.forward(request, response);
				}else {
					String nitiji = (String)request.getParameter("calendar");
					String jigen = (String)request.getParameter("jigen");
					String tokutei_cd = (String)session.getAttribute("tokutei_cd");
					String change_flag = "0";
					if(!nitiji.equals(session.getAttribute("Nitiji").toString()) || !jigen.equals(session.getAttribute("Jigen").toString())) {
						change_flag = "1";
					}
					String check_null = "nothing";
					if(room_cd1.equals(check_null)) {
						room_cd1 = null;
					}
					if(room_cd2.equals(check_null)) {
						room_cd2 = null;
					}
					if(room_cd3.equals(check_null)) {
						room_cd3 = null;
					}
					String subjects_cd = session.getAttribute("subjects_cd").toString();
					String start_date = session.getAttribute("Nitiji").toString();
					String start_time_cd = session.getAttribute("Jigen").toString();
					UpdateJugyoDAO ujDAO = new UpdateJugyoDAO();
					SetTimeContentDAO stcDAO = new SetTimeContentDAO();
					TimeStatusDAO tsDAO = new TimeStatusDAO();
					String return_tokutei_cd="";
					try {
						return_tokutei_cd = ujDAO.update_jugyo(subjects_cd,nitiji,jigen,room_cd1,room_cd2,room_cd3,change_flag,tokutei_cd);
						//追加した授業の開始時間とかアップデート
						stcDAO.set_timecontent(return_tokutei_cd);

						//日付や時限変更時に出席情報テーブルも変更+もしtemp_status保持していたら維持させたい
						if(change_flag=="1") {
							tsDAO.revise_time_status(nitiji, jigen, start_date, start_time_cd);
						}

					} catch (DatabaseException | SystemException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					Enumeration e = session.getAttributeNames();
					while(e.hasMoreElements()) {
						String key = (String)e.nextElement();
						if(!key.equals("seki_no")) {
							session.removeAttribute(key);
						}
					}
					String view = "/WEB-INF/update_result.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				    dispatcher.forward(request, response);
				}
			}else if(branch.equals("delete")){
				//削除ボタン
				String subjects_cd = session.getAttribute("subjects_cd").toString();
				String start_date = session.getAttribute("Nitiji").toString();
				String start_time_cd = session.getAttribute("Jigen").toString();
				String tokutei_cd = (String)session.getAttribute("tokutei_cd");
				RemoveJugyoDAO rjDAO = new RemoveJugyoDAO();
				TimeStatusDAO tsDAO = new TimeStatusDAO();
				int num = 0;
				try {
					tsDAO.delete_time_status(subjects_cd, start_date, start_time_cd);
					num = rjDAO.delete_jugyo(tokutei_cd);
				} catch (DatabaseException | SystemException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				Enumeration e = session.getAttributeNames();
				while(e.hasMoreElements()) {
					String key = (String)e.nextElement();
					if(!key.equals("seki_no")) {
						session.removeAttribute(key);
					}
				}
				request.setAttribute("delete_count",num);
				String view = "/WEB-INF/delete_result.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			    dispatcher.forward(request, response);
			}else {
				//戻るボタン
				//seki_no以外削除して時間割ページに
				Enumeration e = session.getAttributeNames();
				while(e.hasMoreElements()) {
					String key = (String)e.nextElement();
					if(!key.equals("seki_no")) {
						session.removeAttribute(key);
					}
				}
				String view = "CreateJikanwariServlet";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			    dispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
