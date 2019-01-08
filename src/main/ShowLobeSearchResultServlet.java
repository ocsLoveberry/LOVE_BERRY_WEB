package main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBeans.lobeBean;
import main.dao.Search_LOBE_TBL_DAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

/**
 * Servlet implementation class SearchLobeServlet
 */
@WebServlet("/ShowLobeSearchResultServlet")
public class ShowLobeSearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowLobeSearchResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classRoomName = request.getParameter("ClassroomName");
		String lobeName = request.getParameter("lobeName");
		ArrayList<lobeBean> lobeList = new ArrayList<>();
		Search_LOBE_TBL_DAO sltdao = new Search_LOBE_TBL_DAO();
		try {
			lobeList = sltdao.search_LOBE_TBL_by_classroomName(classRoomName);
		} catch (DatabaseException | SystemException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		request.setAttribute("lobeList", lobeList);
		String view = "/WEB-INF/lobe_search_result.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
