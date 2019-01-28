package main.admin.show;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dispatcher.LoveBerryDispatcher;
import javaBeans.TeacherSearchBeans;
import main.dao.Search_teacherDAO;
import main.exception.DatabaseException;
import main.exception.SystemException;

@WebServlet("/ShowTeacherSearchResultServlet")
public class ShowTeacherSearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowTeacherSearchResultServlet() {
        super();
    }

    //adminの教員検索結果画面に飛ばすんやけど、ラジオボタンの判定一緒に処理してる
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select_textbox_btn =(String)request.getParameter("select_textbox_btn");
		String teacher_name_tb = (String)request.getParameter("teacher_name_tb");
		String scl_num_tb = (String)request.getParameter("scl_num_tb");
		ArrayList<TeacherSearchBeans> teacherDate = new ArrayList<>();

		System.out.println("select_textbox_btn:"+select_textbox_btn);
		System.out.println("scl_num_tb:"+scl_num_tb);
		System.out.println("teacher_name_tb:"+teacher_name_tb);

		Search_teacherDAO SearchteacherDao = new Search_teacherDAO();
//		学籍番号が選ばれているとき
		if(select_textbox_btn.equals("select_num")) {
			System.out.println("select_num:true");
		try {
			teacherDate = SearchteacherDao.search_teacher_select_seki_num(scl_num_tb);
			}catch (DatabaseException e) {
				e.printStackTrace();
				}catch (SystemException e) {
				e.printStackTrace();
				}
//		氏名のラジオボタンを選択時
		}else if(select_textbox_btn.equals("select_name")) {
				System.out.println("select_name:true");
//		searchteacherDaoでDBから氏名でOCS_JOHO_TBLを検索する
				try {
					teacherDate = SearchteacherDao.search_teacher_select_name(teacher_name_tb);
					System.out.println("teacherDate.isNullEmpty():" + !teacherDate.isEmpty());

				} catch (DatabaseException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
		}
	}
//		ArrayList<teacherSearchBeans>をrequestに登録する
		request.setAttribute("teacherDate", teacherDate);
		LoveBerryDispatcher.dispatch(request, response, "/WEB-INF/jsp/Admin/Admin_Teacher_Search_Result.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}

