package main.teachar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TeacherSearchServlet
 */
@WebServlet("/TeacherSearchServlet")
public class TeacherSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TeacherSearchServlet() {
        super();
    }

    // 	教員検索に入力された値と選択されているボタンのパラメータを取得
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		/*//1なら氏名２なら学籍番号
		if(select_btn=="1") {
			String NAME = request.getParameter("teacher_name_tb");
		}else{
			String SEKI_NUM = request.getParameter("scl_num_tb");
		}
		
		TeacherSearchBeans select_btn = new TeacherSearchBeans();
		select_btn.setSelect_btn(request.getParameter("select_textbox_btn"));
		*/



	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
