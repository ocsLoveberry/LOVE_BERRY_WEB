package main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dispatcher.LoveBerryDispatcher;
import main.dao.AddClassSubjectsDAO;
import main.dao.Subjects_cd_TO_nameDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;
/**
 * Servlet implementation class AddSubjectsServlet
 */
@WebServlet("/AddSubjectsServlet")
public class AddSubjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjectsServlet() {
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
			LoveBerryDispatcher.dispatch(request, response, view);
		}else {
			String subjects_cd = request.getParameter("subjects_cd");
			//ラジオボタン未選択時の処理
			if(subjects_cd.equals("no_choice")) {
				//ほんとはアラートとか欲しいかも
				String view = "ShowAddSubjectsServlet";
				LoveBerryDispatcher.dispatch(request, response, view);
			}else {
				AddClassSubjectsDAO acsDAO = new AddClassSubjectsDAO();
				String class_cd = session.getAttribute("Class").toString();
				String year = session.getAttribute("year").toString();
				int add_count = 0;
				try {
					add_count = acsDAO.add_subjects(class_cd,subjects_cd,year);
				} catch (DatabaseException | SystemException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				Subjects_cd_TO_nameDAO sctnDAO = new Subjects_cd_TO_nameDAO();
				String subjects_name = "";
				try {
					subjects_name = sctnDAO.to_name(subjects_cd);
				} catch (DatabaseException | SystemException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				//クラス単位で授業追加された際にクラスに所属している個人をsubjectsに追加
				try {
					acsDAO.add_student(class_cd,subjects_cd,year);
				} catch (DatabaseException | SystemException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				request.setAttribute("subjects_name",subjects_name);
				request.setAttribute("add_count",add_count);
				String view = "/WEB-INF/add_result.jsp";
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
