package main.admin.show;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dispatcher.LoveBerryDispatcher;
import main.dao.SearchJugyoDetailDAO;
import main.dao.Subjects_cd_TO_nameDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

@WebServlet("/ShowJugyoDetailServlet")
public class ShowJugyoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowJugyoDetailServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String tokutei_cd = "test_subjects12018-04-011";
		String class_cd = "R4A1_system";
		session.setAttribute("Class",class_cd);
		if(session.getAttribute("seki_no") == null) {
			LoveBerryDispatcher.dispatch(request, response, "ShowTopServlet");
		}else {
			//request.getAttribute?かなんかで受け取った前提
			session.setAttribute("tokutei_cd", tokutei_cd);
			ArrayList<String> jugyo_detail = new ArrayList<String>();
			SearchJugyoDetailDAO sjdDAO = new SearchJugyoDetailDAO();
			try {
				jugyo_detail = sjdDAO.serch_jugyo(tokutei_cd);
			} catch (DatabaseException | SystemException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			//時間あればループに
			session.setAttribute("subjects_cd",jugyo_detail.get(0));
			session.setAttribute("Nitiji",jugyo_detail.get(1));
			session.setAttribute("Jigen",jugyo_detail.get(2));
			session.setAttribute("room_cd1",jugyo_detail.get(3));
			session.setAttribute("room_cd2",jugyo_detail.get(4));
			session.setAttribute("room_cd3",jugyo_detail.get(5));
			Subjects_cd_TO_nameDAO sctnDAO = new Subjects_cd_TO_nameDAO();
			String subjects_cd = jugyo_detail.get(0);
			String subjects_name="";
			try {
				subjects_name = sctnDAO.to_name(subjects_cd);
			} catch (DatabaseException | SystemException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			session.setAttribute("subjects_name",subjects_name);

			//@TODO Jugyo_detail.jspのjsp/配下のファルダにリンク
			LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Jugyo_Detail.jsp");
			//dispatchメモ：らいだー
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
