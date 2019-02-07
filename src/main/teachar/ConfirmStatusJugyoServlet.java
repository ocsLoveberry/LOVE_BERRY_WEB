package main.teachar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBeans.JugyoTable;
import main.dao.ConfirmStatusDAO;
import main.dao.JugyoTableDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

@WebServlet("/ConfirmStatusJugyoServlet")
public class ConfirmStatusJugyoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConfirmStatusJugyoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ju_no = request.getParameter("jugyo_no");
		int jugyo_no = Integer.parseInt(ju_no);

		String subjects_cd = request.getParameter("subjects_cd");

		//seki_no_List取得。めんどいｗ
		String count = request.getParameter("count");
		int seki_no_count = Integer.parseInt(count);
		String seki_no_List[] = new String[seki_no_count];
		for(int i=0;i<seki_no_count;i++) {
			seki_no_List[i] = request.getParameter("seki_no[" + i + "]");
		}

		String status[] = new String[seki_no_count];
		int update_count = 0;

		ArrayList<JugyoTable> jugyo;

		JugyoTableDAO jugyoTableDao  = new JugyoTableDAO();
		ConfirmStatusDAO confirmStatusDAO = new ConfirmStatusDAO();

		//授業情報取得
		jugyo = jugyoTableDao.selectWhere(subjects_cd);

		for(int i=0;i<seki_no_count;i++) {
			//確定出欠情報取得
			status[i] = request.getParameter("status" + String.valueOf(i));
			if(status[i].equals("◯")) {
				status[i] = "1";
			}else if(status[i].equals("△")) {
				status[i] = "3";
			}else {
				status[i] = "2";
			}
			try {
				//確定出欠情報反映(Update)
				update_count += confirmStatusDAO.update_status(seki_no_List[i],subjects_cd,jugyo.get(jugyo_no -1).getStart_date(),jugyo.get(jugyo_no -1).getStart_time_cd(),status[i]);
			} catch (DatabaseException | SystemException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}


		System.out.println(update_count + "件：更新しました。");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println(update_count + "件：更新しました。");
		//LoveBerryDispatcher.dispatch(request, response, "ShowTopServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}