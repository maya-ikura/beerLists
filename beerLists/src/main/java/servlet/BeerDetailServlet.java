package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Beer;
import model.GetBeerDetailLogic;
import model.Login;

@WebServlet("/beerDetail")
public class BeerDetailServlet extends HttpServlet {
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
// 		ビールIDを取得
        int beerId = Integer.parseInt(request.getParameter("id"));        

        // データベースから該当ビールのデータを取得
        GetBeerDetailLogic bo = new GetBeerDetailLogic();
        Beer beer = bo.execute(beerId);
        
//        System.out.println(beer.getBeerName() + "画像名：" + beer.getBeerImage());

        
        
        // ビールの情報をリクエスト属性にセット
        request.setAttribute("BeerDetail", beer);

        // ビールの詳細情報を表示するJSPにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/beerDetail.jsp");
		dispatcher.forward(request, response);		
		}
        
    }
    
    
	}
