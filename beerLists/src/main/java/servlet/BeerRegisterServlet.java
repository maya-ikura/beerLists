package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Account;
import model.Beer;
import model.BeerRegisterLogic;
import model.GetAccountLogic;
import model.Login;

@MultipartConfig
@WebServlet("/beerRegister")
public class BeerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static final String UPLOAD_DIRECTORY = "img";

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
//		ビール登録画面へ遷移
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("WEB-INF/jsp/beerRegister.jsp");
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
		//		リクエストパラメータの取得		
        // リクエストパラメータの文字エンコーディングを設定
        request.setCharacterEncoding("UTF-8");
		
        //		画像の取得
		// アップロードされたファイルを処理
         Part part = request.getPart("beerImage");
//      ファイルがある場合はファイル名を取得
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        // 拡張子を取得する（例: .jpg, .png など）
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
//      String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";

//       新しいファイル名に変換
        String newFileName = "uploadedFile_" + System.currentTimeMillis() + fileExtension;
       
        String uploadPath = "C:\\pleiades\\2023-12\\workspace\\beerLists\\src\\main\\webapp\\img";
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()) {
        	uploadDir.mkdir();
        }
        
        try(InputStream fileContent = part.getInputStream()){
        	Files.copy(fileContent, new File(uploadPath + File.separator + newFileName).toPath());
            System.out.println("成功" + newFileName);
            System.out.println(uploadPath + File.separator + newFileName);

        
        }
       
		String beerName = request.getParameter("beerName"); //ビール名
		
		String checkFavorite = request.getParameter("favorite"); // お気に入り
		boolean favorite = checkFavorite != null && checkFavorite.equals("true");
		
		String store = request.getParameter("store");  // ビール会社名
		
		String storeKinds = request.getParameter("storeKinds"); // 購入方法
		
		int price = Integer.parseInt(request.getParameter("price"));
		
		String beerKinds = request.getParameter("beerKinds"); // ビールの種類
		
		String feeling = request.getParameter("feeling"); // どんな時に飲みたいか

		String people = request.getParameter("people"); // どんな人と飲みたいか
		
		String memo = request.getParameter("memo"); // メモ
		
//		ユーザーIDとニックネームの取得
		GetAccountLogic gal = new GetAccountLogic();
		Account account = gal.execute(loginUser);
		
		String userName = account.getUserName();
		String nickname = account.getNickname();
		

		
//		Beerインスタンスの生成
		Beer beer = new Beer(beerName, favorite, store, storeKinds, price, 
				beerKinds, feeling, people, memo, newFileName, userName, nickname);
		
//		登録できたかどうかをisRegisterに登録
		BeerRegisterLogic bo = new BeerRegisterLogic();
		boolean isRegister = bo.execute(beer);
		
//		登録成功時の処理（失敗の場合はnullのまま）
		if(isRegister) {
			
//		リクエストスコープに保存
			 request.setAttribute("registerBeer", beer);
			
//		登録結果画面にフォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/beerRegisterOk.jsp");
		dispatcher.forward(request, response);
		
	} else { // 登録失敗時
//		エラーメッセージを保存してフォワード
		String errorMsg = "登録に失敗しました。内容を確認してください。";
		request.setAttribute("errorMsg", errorMsg);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/beerRegister.jsp");
		dispatcher.forward(request, response);
		}
	}

		}
		}
		


