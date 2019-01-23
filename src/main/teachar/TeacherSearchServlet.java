package main.teachar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherSearchServlet")
public class TeacherSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TeacherSearchServlet() {
        super();
    }

    // 	教員検索に入力された値と選択されているボタンのパラメータを取得
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//TODO：Showにはいってる処理をここでする
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
