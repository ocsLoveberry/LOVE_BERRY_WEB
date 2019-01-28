package main.admin.show;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;
import javaBeans.lobeBean;
import main.dao.Search_LOBE_TBL_DAO;
import main.exception.DatabaseException;
import main.exception.SystemException;
@WebServlet("/ShowLobeSearchResultServlet")
public class ShowLobeSearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowLobeSearchResultServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checked = request.getParameter("classRoomNameOrLobeName");
		String classRoomName = request.getParameter("classRoomName");
		System.out.println(classRoomName);
		String lobeName = request.getParameter("lobeName");
		ArrayList<lobeBean> lobeList = new ArrayList<>();
		Search_LOBE_TBL_DAO sltdao = new Search_LOBE_TBL_DAO();
		try {
			if(checked.equals("checkedClassroom")) {
				lobeList = sltdao.search_LOBE_TBL_by_classroomName(classRoomName);
			}else if(checked.equals("checkedLobeID")) {
				lobeList = sltdao.search_OCS_JOHO_TBL_by_lobeID(lobeName);
			}
		} catch (DatabaseException | SystemException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		request.setAttribute("lobeList", lobeList);
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Lobe/Lobe_Search_Result.jsp");
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
