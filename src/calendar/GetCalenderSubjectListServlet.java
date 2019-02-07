package calendar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import javaBeans.SubjectsListTable;
import main.dao.SubjectsListTableDAO;

@WebServlet("/GetCalenderSubjectListServlet")
public class GetCalenderSubjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plan");
		response.setCharacterEncoding("UTF-8");

		SubjectsListTableDAO subjectsListTabledao = new SubjectsListTableDAO();
		ArrayList<SubjectsListTable> subjectsList =  subjectsListTabledao.selectAll();
		response.getWriter().println(new Gson().toJson(subjectsList));

	}

}
