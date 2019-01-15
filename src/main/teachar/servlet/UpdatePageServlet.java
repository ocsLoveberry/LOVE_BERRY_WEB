package main.teachar.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dispatcher.LoveBerryDispatcher;
import main.dao.SerchTokutei_cdDAO;
import main.dao.Subjects_cd_TO_nameDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

/**
 * Servlet implementation class UpdatePageServlet
 */
@WebServlet("/UpdatePageServlet")
public class UpdatePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("seki_no") == null) {
			String view = "ShowTopServlet";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		    dispatcher.forward(request, response);
		}else {
			String subjects_cd = request.getParameter("subjects_cd");
			Subjects_cd_TO_nameDAO sctnDAO = new Subjects_cd_TO_nameDAO();
			String subjects_name = "";
			try {
				subjects_name = sctnDAO.to_name(subjects_cd);
			} catch (DatabaseException | SystemException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			//個々経由したフラグ的な
			session.setAttribute("update_page",1);
			session.setAttribute("subjects_cd",subjects_cd);
			session.setAttribute("subjects_name",subjects_name);

			//すでに同一科目が、同時限に存在した場合の処理必要
			//なんかの変数与えて変化させる、もし存在してたら特定コードから授業情報を表示+それを告知
			String Nitiji = (String)session.getAttribute("Nitiji");
			String Jigen = (String)session.getAttribute("Jigen");
			String tokutei_cd = subjects_cd + Nitiji + Jigen;
			session.setAttribute("tokutei_cd",tokutei_cd);
			SerchTokutei_cdDAO stcDAO = new SerchTokutei_cdDAO();
			try {
				if(stcDAO.serch_tokutei_cd(tokutei_cd) == 1) {
					session.setAttribute("tokutei_flag",1);
					//すでに同一科目が同時限に存在した時に、room_cd取得
					ArrayList<String> room_cd = new ArrayList<String>();
					room_cd = stcDAO.to_room_cd(tokutei_cd);
					request.setAttribute("room_cd1",room_cd.get(0));
					request.setAttribute("room_cd2",room_cd.get(1));
					request.setAttribute("room_cd3",room_cd.get(2));
				}
			} catch (DatabaseException | SystemException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/create_jugyo.jsp");
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
