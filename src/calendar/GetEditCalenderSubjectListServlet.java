package calendar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import javaBeans.JugyoTable;
import main.dao.JugyoTableDAO;

@WebServlet("/GetEditCalenderSubjectListServlet")

public class GetEditCalenderSubjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plan");
		response.setCharacterEncoding("UTF-8");
		String tokutei_cd = request.getParameter("tokutei_cd");
		JugyoTableDAO jugyoTabledao = new JugyoTableDAO();
		ArrayList<JugyoTable> editSubjectOptionList =  jugyoTabledao.Jugyo_Detail(tokutei_cd);
		response.getWriter().println(new Gson().toJson(editSubjectOptionList));
	}

}
