package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Beer;
import model.GetBeerListsLogic;
import model.Login;
import model.LoginLogic;

@WebServlet("/top")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
//		ログイン中であることを確認
		HttpSession session = request.getSession();
		Login loginUser = (Login)session.getAttribute("loginUser");
		
		if(loginUser == null) {
//			ログインしていない場合
			response.sendRedirect("index");
		} else {
	        // ログインしている場合
			
//			ビールリストを取得してリクエストスコープに保存
			GetBeerListsLogic getBeerListLogic = new GetBeerListsLogic();
			List<Beer> beerlists = getBeerListLogic.execute();
			request.setAttribute("beerLists", beerlists);

	        // トップ画面へ遷移
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/top.jsp");
	        dispatcher.forward(request, response);
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
//		Loginインスタンス（ユーザー情報）の生成
		Login login = new Login(userName, password);
		
//		ログイン処理
		LoginLogic bo = new LoginLogic();
//		executeメソッドにLogin情報のJavabeansをいれてあげる
		boolean isLogin = bo.execute(login);
		
//		ログイン成功時の処理（失敗の場合はnullのまま）
		if(isLogin) {
//			ユーザー情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", login);
			
//			ビールリストを取得してリクエストスコープに保存
			GetBeerListsLogic getBeerListLogic = new GetBeerListsLogic();
			List<Beer> beerlists = getBeerListLogic.execute();
			request.setAttribute("beerLists", beerlists);
		
//		ログイン結果画面にフォワード（WEB-INF/jspフォルダのtop.jspファイル）
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/top.jsp");
		dispatcher.forward(request, response);
		
		} else if(userName == "" || password == "") {
//		エラーメッセージを保存してフォワード
		String errorMsg = "ユーザーIDまたはパスワードが空欄となっています";
		request.setAttribute("errorMsg", errorMsg);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
		dispatcher.forward(request, response);
		
	} else { // ログイン失敗時
//		エラーメッセージを保存してフォワード
		String errorMsg = "ユーザーIDまたはパスワードが間違っています";
		request.setAttribute("errorMsg", errorMsg);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
		dispatcher.forward(request, response);
	}
}
}
