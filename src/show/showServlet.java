/**
 * sessionで登録された値からjspにページ遷移するためのサーブレット
 * <% session.setAttribute("view", "/WEB-INF/main/Admin/Admin_Student_Search.jsp"); %>
 * sessionはブラウザバックの際にnullPointerExceptionを出すので
 * cokkieに改定予定
 * 残りの開発期間の短さのため改定する時間もなく
 * 画面別にshowサーブレットを使いたいと思います
 *
 * @TODO 卒業後、リファクタリング案件
 *
 * @author kesera2
 * @date 2019/01/28
 */

package show;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dispatcher.LoveBerryDispatcher;

/**
 * Servlet implementation class showServlet
 */
@WebServlet("/showServlet")
public class showServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public showServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String view = (String)session.getAttribute("view");
		LoveBerryDispatcher.dispatch(request, response, view);
		session.removeAttribute("view");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


