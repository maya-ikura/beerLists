package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		ログアウトするため、セッションスコープを破棄する
		HttpSession session = request.getSession(); //セッションスコープ（ログイン情報）を取得
		session.invalidate(); //破棄
		
//		ログアウトした旨をログイン画面に記載
		String errorMsg = "ログアウトしました";
		request.setAttribute("errorMsg", errorMsg);
		
//		ログイン画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
		dispatcher.forward(request, response);

		
	}
}
