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
import model.DeleteImageLogic;
import model.GetBeerDetailLogic;
import model.Login;

@MultipartConfig
@WebServlet("/imageDelete")

public class ImageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		String Image = request.getParameter("beerImage");
		
//		
		DeleteImageLogic bo = new DeleteImageLogic();
		boolean isDelete = bo.deleteImage(Image);

//		リクエストスコープに保存
		GetBeerDetailLogic bo2 = new GetBeerDetailLogic();
		Beer beer =bo2.execute(id);
		request.setAttribute("beerEdit", beer);

		if(isDelete) {
		    // 削除成功時
		    String Msg = "削除が完了しました";
		    request.setAttribute("Msg", Msg);
		} else {
		    // 削除失敗時
		    String Msg = "削除に失敗しました";
		    request.setAttribute("Msg", Msg);
		}

		// 編集画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/beerEdit.jsp?id=" + id);
		dispatcher.forward(request, response);
		}
	}
}


