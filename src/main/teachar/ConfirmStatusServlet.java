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

@WebServlet("/ConfirmStatusServlet")
public class ConfirmStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConfirmStatusServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seki_no = request.getParameter("seki_no");
		String subjects_cd = request.getParameter("subjects_cd");
		//なんかParameterでしか受け取れなさげなんでStringで受け取ってintに
		String count = request.getParameter("jugyo_count");
		int jugyo_count = Integer.parseInt(count);
		String status[] = new String[jugyo_count];
		int update_count = 0;

		ArrayList<JugyoTable> jugyo;

		JugyoTableDAO jugyoTableDao  = new JugyoTableDAO();
		ConfirmStatusDAO confirmStatusDAO = new ConfirmStatusDAO();

		//授業情報取得
		jugyo = jugyoTableDao.selectWhere(subjects_cd);

		for(int i=0;i<jugyo_count;i++) {
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
				update_count += confirmStatusDAO.update_status(seki_no,subjects_cd,jugyo.get(i).getStart_date(),jugyo.get(i).getStart_time_cd(),status[i]);
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