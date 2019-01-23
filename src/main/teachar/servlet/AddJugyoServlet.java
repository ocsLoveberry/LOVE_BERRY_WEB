package main.teachar.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dispatcher.LoveBerryDispatcher;
import main.dao.AddJikanwariTblDAO;
import main.dao.AddJugyoDAO;
import main.dao.CheckJikanwari;
import main.dao.SearchClassDAO;
import main.dao.SetTimeContentDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

/**
 * Servlet implementation class AddJugyoServlet
 */
@WebServlet("/AddJugyoServlet")
public class AddJugyoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJugyoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("seki_no") == null) {
			LoveBerryDispatcher.dispatch(request, response, "ShowTopServlet");
		}else {
			String branch = request.getParameter("result").toString();
			//修正ボタンか、登録ボタンか
			if(branch.equals("revise")) {
				//修正ボタン押したときの処理
				//ほんとはsession管理してどこか適切なページに飛ばしたい。とりあえずShowCreateJugyoServletに
				Enumeration e = session.getAttributeNames();
				while(e.hasMoreElements()) {
					String key = (String)e.nextElement();
					if(!key.equals("Jigen") && !key.equals("year") && !key.equals("Nitiji") && !key.equals("Class") && !key.equals("seki_no")) {
						session.removeAttribute(key);
					}
				}
				LoveBerryDispatcher.dispatch(request, response, "ShowCreateJugyoServlet");
			}else{
				AddJugyoDAO ajDAO = new AddJugyoDAO();
				String subjects_cd = session.getAttribute("subjects_cd").toString();
				String start_date = session.getAttribute("Nitiji").toString();
				String start_time_cd = session.getAttribute("Jigen").toString();
				String tokutei_cd = subjects_cd + start_date + start_time_cd;
				String room_cd1=null, room_cd2=null, room_cd3=null;
				if(session.getAttribute("room_cd1")!=null){
					room_cd1 = session.getAttribute("room_cd1").toString();
				}
				if(session.getAttribute("room_cd2")!=null){
					room_cd2 = session.getAttribute("room_cd2").toString();
				}
				if(session.getAttribute("room_cd3")!=null){
					room_cd3 = session.getAttribute("room_cd3").toString();
				}
				//登録処理
				//tokutei_flag=1の時はupdate、nullならinsert
				if(session.getAttribute("tokutei_flag")==null) {
					//insert処理→その特定コードを該当クラスの時間割テーブルに
					try {
						int num1 = ajDAO.insert_jugyo(subjects_cd, start_date, start_time_cd, room_cd1, room_cd2, room_cd3);
					} catch (DatabaseException | SystemException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}

				}else{
					try {
						int num2 = ajDAO.update_jugyo(tokutei_cd, room_cd1, room_cd2, room_cd3);
					} catch (DatabaseException | SystemException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
				//授業情報追加後、そのtokutei_cdを時間割テーブルに追加
				AddJikanwariTblDAO ajtDAO = new AddJikanwariTblDAO();
				String class_cd = session.getAttribute("Class").toString();
				try {
					int num3 = ajtDAO.add_jikanwari(class_cd,start_date,start_time_cd,tokutei_cd);
				} catch (DatabaseException | SystemException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				//今回追加・更新した授業を他クラスが受講している場合、(class_subjects_tbl）そのクラスの時間割も更新
				//追加した科目を持つclass_cdリストを作成
				String year =  session.getAttribute("year").toString();
				ArrayList<String> class_cd_List = new ArrayList<String>();
				SearchClassDAO scDAO = new SearchClassDAO();
				try {
					class_cd_List = scDAO.serch_class(subjects_cd,year);
				} catch (DatabaseException | SystemException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				//時間割に存在しているかcheck、なければtokutei_cd追加
				CheckJikanwari cjDAO = new CheckJikanwari();
				try {
					cjDAO.check_update(class_cd_List,tokutei_cd,start_date,start_time_cd);
				} catch (DatabaseException | SystemException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				//追加した授業の開始時間とかアップデート
				SetTimeContentDAO stcDAO = new SetTimeContentDAO();
				try {
					stcDAO.set_timecontent(tokutei_cd);
				} catch (DatabaseException | SystemException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				LoveBerryDispatcher.dispatch(request, response, "ShowTopServlet");
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
