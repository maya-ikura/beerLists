package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Beer;
import model.DeleteBeerLogic;
import model.GetBeerDetailLogic;
import model.Login;

@MultipartConfig
@WebServlet("/deleteBeer")
public class DeleteBeerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//		ログイン中であることを確認
		HttpSession session = request.getSession();
		Login loginUser = (Login) session.getAttribute("loginUser");

		if (loginUser == null) {
			//			ログインしていない場合
			response.sendRedirect("index");
		}

			//		ログインしている場合
			// 		ビールIDを取得
			int beerId = Integer.parseInt(request.getParameter("id"));

			// データベースから該当ビールのデータを取得
			GetBeerDetailLogic bo = new GetBeerDetailLogic();
			Beer beer = bo.execute(beerId);
			
			// 取得したビールを削除
			request.setAttribute("beerEdit", beer);
			
			if (loginUser.getUserName().equals(beer.getUserName())) {		


				// ビールの詳細情報を表示するJSPにフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/beerDelete.jsp");
				dispatcher.forward(request, response);
				
			} else {
				
//				作成したアカウントではないため、エラー文を表示し詳細の画面に戻る
					String errorMsg = "登録したアカウントではないため、削除できません。";
					request.setAttribute("errorMsg", errorMsg);
					RequestDispatcher dispatcher = request.getRequestDispatcher("beerDetail?id=" + beer.getId());
					dispatcher.forward(request, response);

			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		ログイン中であることを確認
		HttpSession session = request.getSession();
		Login loginUser = (Login)session.getAttribute("loginUser");
		
		if(loginUser == null) {
//			ログインしていない場合
			response.sendRedirect("index");
		} else {
//		ログインしている場合

		//	ログインしている場合        
		// リクエストパラメータの文字エンコーディングを設定
		request.setCharacterEncoding("UTF-8");

		// レスポンスの文字エンコーディングも設定
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
//		必要なデータを取得
		int id = Integer.parseInt(request.getParameter("beerId"));
		DeleteBeerLogic bo = new DeleteBeerLogic();
		boolean isDelete = bo.execute(id);

		if(isDelete) {
//			画像削除完了画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/beerDeleteOK.jsp");
			dispatcher.forward(request, response);			
		}
//			リクエストスコープに保存
			String Msg = "削除に失敗しました";
			request.setAttribute("Msg", Msg);
		
//			編集画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/beerEdit.jsp?id=" + id);
			dispatcher.forward(request, response);
		}
	

	}
}


