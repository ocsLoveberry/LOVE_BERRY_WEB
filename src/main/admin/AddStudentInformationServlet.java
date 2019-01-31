package main.admin;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.util.StringUtils;

import Dispatcher.LoveBerryDispatcher;
import javaBeans.OcsJohoData;
import main.dao.Insert_OCS_JOHO_TBL_DAO;

@WebServlet("/AddStudentInformationServlet")
public class AddStudentInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String RESULT_PAGE = "/WEB-INF/jsp/Admin/Admin_Add_Student_Information_result.jsp";
	private final String ERROR_PAGE = "/WEB-INF/jsp/Admin/Admin_Add_Student_Information_error.jsp";

    /**
     * 手順
     * ①reqestで受け取った値をBeansでDAOに渡す
     * ②daoはbeansから必要な情報を取り出してSQL文にセットする
     * ③insert文を実行する
     * ④実行が成功したら成功した画面（未制作）にdispatchする
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");


		String seki_no = request.getParameter("seki_no");
		String type = "3";
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		String password = request.getParameter("password");
		String mail_adress = request.getParameter("mail_adress");
		String gakka_cd = request.getParameter("gakka_cd");
		String senko_cd = request.getParameter("senko_cd");
		String class_cd = request.getParameter("class_gakka") + request.getParameter("class_year") + request.getParameter("class_AorB") + request.getParameter("class_1or2or3");
		class_cd = editClassCd(senko_cd, class_cd);
		String year = request.getParameter("year");
//		debugメソッド↓
//		debugSystemOut(seki_no,type,name,message,password,mail_adress,gakka_cd,senko_cd,class_cd,year);
//		↑↑↑ここまでデバッグ↑↑↑
		OcsJohoData newStudentInfomation = new OcsJohoData(seki_no, type, name, message, mail_adress, password, gakka_cd, senko_cd, class_cd, year);
		Insert_OCS_JOHO_TBL_DAO insert_OCS_DAO = new Insert_OCS_JOHO_TBL_DAO();

		validatioCheck(newStudentInfomation);
		boolean isInsertOk = false;
		try {
			isInsertOk = insert_OCS_DAO.Insert_OCS_JOHO_TBL(newStudentInfomation);
		} catch (SQLIntegrityConstraintViolationException e) {
//			@TODO:学籍番号がかぶったときにエラーを表示させる処理
			request.setAttribute("error_SQLIntegrityConstraintViolationException", "true");
		}

		if(isInsertOk) {
			LoveBerryDispatcher.dispatch(request, response, RESULT_PAGE);
		}else {
			LoveBerryDispatcher.dispatch(request, response, ERROR_PAGE);
		}
//		続けて登録する用
//		@TODO:sessionにformの値を渡して専攻とクラスの初期値を前回の入力と同じにしたかった
//		setSessionData(request,newStudentInfomation);

	}


	private void validatioCheck(OcsJohoData newStudentInfomation) {

	}


	private String editClassCd(String senko_cd,String class_cd) {
		String trimedSenko_cd = senko_cd.substring(2);
		String result = class_cd + StringUtils.capitalize(trimedSenko_cd);
		return result;
	}

	@SuppressWarnings("unused")
	private void setSessionData(HttpServletRequest request,OcsJohoData newStudentInfomation) {
		HttpSession session = request.getSession();
		session.setAttribute("retryFlag", "true");
		session.setAttribute("gakka_cd", newStudentInfomation.getGakka_cd());
		session.setAttribute("class_gakka", newStudentInfomation.getClass_cd().charAt(0));
		session.setAttribute("class_year", newStudentInfomation.getClass_cd().charAt(1));
		session.setAttribute("class_AorB", newStudentInfomation.getClass_cd().charAt(2));
		session.setAttribute("class_1or2or3", newStudentInfomation.getClass_cd().charAt(3));
		session.setAttribute("yaer", newStudentInfomation.getYear());
	}

	@SuppressWarnings("unused")
	private void debugSystemOut(String seki_no, String type, String name, String message, String password, String mail_adress, String gakka_cd, String senko_cd, String class_cd, String year) {
		System.out.println(seki_no);
		System.out.println(type);
		System.out.println(name);
		System.out.println(message);
		System.out.println(password);
		System.out.println(mail_adress);
		System.out.println(gakka_cd);
		System.out.println(senko_cd);
		System.out.println(class_cd);
		System.out.println(year);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
