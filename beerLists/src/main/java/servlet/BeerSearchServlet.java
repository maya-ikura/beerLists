package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Beer;
import model.Login;
import model.SearchLogic;

@WebServlet("/beerSearch")
public class BeerSearchServlet extends HttpServlet {
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
//		ログインしている場合
//		検索画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/search.jsp");
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
//		リクエストパラメータの文字エンコーディングを設定
			request.setCharacterEncoding("UTF-8");

//			レスポンスの文字エンコーディングも設定
//	        response.setContentType("text/html; charset=UTF-8");
//	        response.setCharacterEncoding("UTF-8");
			
// 		検索したいビール情報を取得
			// リクエストパラメータを取得
			String beerName = request.getParameter("beerName");
			String favorite = request.getParameter("favorite");
			String store = request.getParameter("store");
			String[] storeKinds = request.getParameterValues("storeKinds");
			String[] beerKinds = request.getParameterValues("beerKinds");
			String[] feeling = request.getParameterValues("feeling");
			String[] people = request.getParameterValues("people");
			System.out.println("beerName: " + beerName);
			System.out.println("store: " + store);
			System.out.println("favorite: " + favorite);
			System.out.println("storeKinds: " + Arrays.toString(storeKinds));
			System.out.println("beerKinds: " + Arrays.toString(beerKinds));
			System.out.println("feeling: " + Arrays.toString(feeling));
			System.out.println("people: " + Arrays.toString(people));			
			
			
			SearchLogic bo = new SearchLogic();
			List<Beer> searchBeerlist = 
					bo.execute(beerName, store, favorite, storeKinds, beerKinds, feeling, people);
			
			
			// ビールの情報をリクエスト属性にセット
			request.setAttribute("SearchBeerlists", searchBeerlist);
        
//        findbeer()が0だった場合
        if(searchBeerlist == null) {        
    		String errorMsg = "検索内容と一致するものがありませんでした";
    		request.setAttribute("errorMsg3", errorMsg);
        }    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/searchResult.jsp");
    		dispatcher.forward(request, response);		
	}

	}
}


