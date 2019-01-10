package Dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoveBerryDispatcher {

	/**
	 * インスタンス化しても無駄なのでprivateで定義しています。
	 * インスタンスに対してメソッドを使うこともできてしまうが、
	 * 実際インスタンス化しなくても同じ操作が可能なので、
	 * インスタンスが無駄になる
	 */
	private LoveBerryDispatcher() {}

	public static void dispatch(HttpServletRequest request,HttpServletResponse response,String view) {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	    try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
