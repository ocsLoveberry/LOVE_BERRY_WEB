package main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.dao.studentDetailDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

/**
 * Servlet implementation class ShowStudentPunchSearchServlet
 */
@WebServlet("/showStudentDetailServlet")
public class showStudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public showStudentDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

//    ログインセッションの有無の確認
//    打刻検索画面への遷移
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession(false);
//		if(session.getAttribute("seki_no") == null) {
//			String view = "ShowTopServlet";
//			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//		    dispatcher.forward(request, response);
//		}else {

//		学生詳細情報を表示するためのデータベースの処理を書いたプログラム呼び出す
			studentDetailDAO sdDAO = new studentDetailDAO();
			try {
				request.setAttribute("studentDetail", sdDAO.getStudentDetail("154102"));
			} catch (DatabaseException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
//		学生詳細情報画面を表示させる
		String view = "/WEB-INF/admin_student_detail.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	    dispatcher.forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
