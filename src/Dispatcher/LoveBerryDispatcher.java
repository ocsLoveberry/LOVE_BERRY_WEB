package Dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoveBerryDispatcher {

	public static void dispatch(HttpServletRequest request,HttpServletResponse response,String target) {
		String view = target;
	    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	    try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
