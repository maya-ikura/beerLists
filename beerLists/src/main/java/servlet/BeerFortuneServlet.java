package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Beer;
import model.GetRandomBeerLogic;
import model.Login;
import model.SearchLogic;

@WebServlet("/beerFortune")
public class BeerFortuneServlet extends HttpServlet {
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
	        // トップ画面へ遷移
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/beerFortune.jsp");
	        dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		// 現在の質問番号を取得
        String questionNumber = request.getParameter("questionNumber");

        // 質問1の処理
        if ("1".equals(questionNumber)) {
            String BeerKinds = request.getParameter("qa1");
            session.setAttribute("qa1", BeerKinds);
            // 次の質問（質問2）へ遷移
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/beerFortune2.jsp");
	        dispatcher.forward(request, response);
//	        response.sendRedirect("WEB-INF/jsp/beerFortune2.jsp");
        }

        // 質問2の処理
        if ("2".equals(questionNumber)) {
            String feeling1 = request.getParameter("qa2");
            session.setAttribute("qa2", feeling1);
            // 次の質問（質問3）へ遷移
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/beerFortune3.jsp");
	        dispatcher.forward(request, response);

//            response.sendRedirect("WEB-INF/jsp/beerFortune3.jsp");
        }
        
        // 質問3の処理
        if ("3".equals(questionNumber)) {
            String feeling2 = request.getParameter("qa3");
            session.setAttribute("qa3", feeling2);
            // 次の質問（質問4）へ遷移
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/beerFortune4.jsp");
	        dispatcher.forward(request, response);

//            response.sendRedirect("WEB-INF/jsp/beerFortune4.jsp");
        }

        // 質問4の処理
        if ("4".equals(questionNumber)) {
            String people = request.getParameter("qa4");
            session.setAttribute("qa4", people);
            // 次の質問（質問5）へ遷移
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/beerFortune5.jsp");
	        dispatcher.forward(request, response);

//            response.sendRedirect("WEB-INF/jsp/beerFortune5.jsp");
        }

        // 質問5の処理
        if ("5".equals(questionNumber)) {
            String favorite = request.getParameter("qa5");
            session.setAttribute("qa5", favorite);

		
			// リクエストパラメータの文字エンコーディングを設定
			request.setCharacterEncoding("UTF-8");

			// レスポンスの文字エンコーディングも設定
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");

			//	その他のデータを入力
			String beerName = null;
			
			String store = null;
			
			String[] storeKinds = {"缶", "瓶"};
			
//			ビールの種類
			// ラジオボタンで選択された値を取得
			String selectedValue = (String) session.getAttribute("qa1");

			// コンマで分割して、個々の値を取得
			String[] beerKinds = selectedValue.split(",");

			// 配列の中身を確認
			for (String beer : beerKinds) {
			    System.out.println(beer);  // ビールの種類データ確認用
			}
			

			String[] feeling = {(String) session.getAttribute("qa2"), (String) session.getAttribute("qa3")}; // どんな時に飲みたいか

			String[] people = {(String) session.getAttribute("qa4")}; // どんな人と飲みたいか
			
			System.out.println("storeKinds: " + Arrays.toString(storeKinds));
			System.out.println("beerKinds: " + Arrays.toString(beerKinds));
			System.out.println("feeling: " + Arrays.toString(feeling));
			System.out.println("people: " + Arrays.toString(people));			

			
			SearchLogic bo = new SearchLogic();
			List<Beer> searchBeerlist = 
					bo.execute(beerName, store, favorite, storeKinds, beerKinds, feeling, people);

			// ビールの情報をリクエスト属性にセット
			if (!searchBeerlist.isEmpty()) {
			    Random random = new Random();
			    int randomIndex = random.nextInt(searchBeerlist.size()); // リストのサイズ以内のランダムなインデックスを生成
			    Beer randomBeer = searchBeerlist.get(randomIndex); // ランダムなビールを取得
				request.setAttribute("RandomBeer", randomBeer);

//        findbeer()が0だった場合
			} else  {
//        	ビールリストを取得してリクエストスコープに保存
        	GetRandomBeerLogic bo2 = new GetRandomBeerLogic(); 
        	Beer randomBeer2 = bo2.getRandomBeer(beerKinds);
			
			request.setAttribute("RandomBeer", randomBeer2);
        } 
		
		

			
	        // 結果画面へ遷移
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/beerFortuneResult.jsp");
	        dispatcher.forward(request, response);
		}

		
	}
}

