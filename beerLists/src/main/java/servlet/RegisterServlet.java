package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.RegisterLogic;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		新規登録画面へ遷移
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		入力されたアカウント情報を取得する
//		リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		int age = Integer.parseInt(request.getParameter("age"));
		
		
//		Loginインスタンス（ユーザー情報）の生成
		Account account = new Account(userName, password, nickname, age);
		RegisterLogic registerLogic = new RegisterLogic();
		
//		registerLogic.execute(account);
		
		//登録できたかどうかをisRegisterに登録
		boolean isRegister = registerLogic.execute(account);
		
//		登録成功時の処理（失敗の場合はnullのまま）
		if(isRegister) {
//		登録結果画面にフォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/registerOk.jsp");
		dispatcher.forward(request, response);
		
	} else { // 登録失敗時
//		エラーメッセージを保存してフォワード
		String errorMsg = "登録に失敗しました。内容を確認してください。";
		request.setAttribute("errorMsg2", errorMsg);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
		}
	}
}
