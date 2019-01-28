package main.teachar;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.dao.AddJikanwariTblDAO;
import main.dao.AddJugyoDAO;
import main.dao.CheckJikanwari;
import main.dao.SearchClassDAO;
import main.dao.SetTimeContentDAO;
import main.dao.TimeStatusDAO;
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
			String view = "ShowTopServlet";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		    dispatcher.forward(request, response);
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
				String view = "ShowCreateJugyoServlet";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			    dispatcher.forward(request, response);
			}else{
				//登録ボタン押したときの処理
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

				AddJikanwariTblDAO ajtDAO = new AddJikanwariTblDAO();
				String class_cd = session.getAttribute("Class").toString();
				String year =  session.getAttribute("year").toString();
				ArrayList<String> class_cd_List = new ArrayList<String>();
				SearchClassDAO scDAO = new SearchClassDAO();
				CheckJikanwari cjDAO = new CheckJikanwari();
				SetTimeContentDAO stcDAO = new SetTimeContentDAO();
				TimeStatusDAO tsDAO = new TimeStatusDAO();
				//登録処理
				//tokutei_flag=1の時はupdate、nullならinsert
				try {
					//insert処理→その特定コードを該当クラスの時間割テーブルに
					if(session.getAttribute("tokutei_flag")==null) {
						int num1 = ajDAO.insert_jugyo(subjects_cd, start_date, start_time_cd, room_cd1, room_cd2, room_cd3);
						//授業情報追加後、そのtokutei_cdを時間割テーブルに追加
						int num3 = ajtDAO.add_jikanwari(class_cd,start_date,start_time_cd,tokutei_cd);
					}else{
						int num2 = ajDAO.update_jugyo(tokutei_cd, room_cd1, room_cd2, room_cd3);
						//授業情報更新後、そのtokutei_cdを時間割テーブルに追加
						int num3 = ajtDAO.add_jikanwari(class_cd,start_date,start_time_cd,tokutei_cd);
					}
					//今回追加・更新した授業を他クラスが受講している場合、(class_subjects_tbl）そのクラスの時間割も更新
					//追加した科目を持つclass_cdリストを作成
					class_cd_List = scDAO.serch_class(subjects_cd,year);
					//時間割に存在しているかcheck、なければtokutei_cd追加
					cjDAO.check_update(class_cd_List,tokutei_cd,start_date,start_time_cd);
					//特定の特定コードを持つ授業情報テーブルの時刻情報更新
					stcDAO.set_timecontent(tokutei_cd);

					//授業情報追加後に出席情報テーブル追加
					//授業情報追加のタイミングで処理が変わる。
					SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date kyou = new Date();
					Date date_start_date = sdFormat.parse(start_date);

					tsDAO.add_time_status(class_cd_List, subjects_cd, start_date, start_time_cd, year);
					if(date_start_date.after(kyou)) {
						//現在以降の授業情報なので出席情報テーブルを追加して更新はしない
					}else {
						//現在以前の授業情報なので出席情報テーブルを追加した後、更新temp_status
						tsDAO.update_temp_status(tokutei_cd, subjects_cd, start_date, start_time_cd);
					}

					String view = "ShowTopServlet";
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				    dispatcher.forward(request, response);

				} catch (DatabaseException | SystemException | ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
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
