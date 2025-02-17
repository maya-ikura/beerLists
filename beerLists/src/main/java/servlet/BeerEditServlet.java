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

import model.Beer;
import model.EditBeerLogic;
import model.GetBeerDetailLogic;
import model.Login;

@MultipartConfig
@WebServlet("/beerEdit")
public class BeerEditServlet extends HttpServlet {
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

			// ビールの情報をリクエスト属性にセット
			request.setAttribute("beerEdit", beer);
			
			System.out.println(loginUser.getUserName());
			System.out.println(beer.getUserName());
		if (loginUser.getUserName().equals(beer.getUserName())) {		

			// ビールの詳細情報を表示するJSPにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/beerEdit.jsp");
			dispatcher.forward(request, response);
			
		} else {
			
//			作成したアカウントではないため、エラー文を表示し詳細の画面に戻る
				String errorMsg = "登録したアカウントではないため、編集できません。";
				request.setAttribute("errorMsg", errorMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("beerDetail?id=" + beer.getId());
				dispatcher.forward(request, response);
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		ログイン中であることを確認
		HttpSession session = request.getSession();
		Login loginUser = (Login) session.getAttribute("loginUser");

		if (loginUser == null) {
			//			ログインしていない場合
			response.sendRedirect("index");
		} else {
		//	ログインしている場合        
		// リクエストパラメータの文字エンコーディングを設定
		request.setCharacterEncoding("UTF-8");

		// レスポンスの文字エンコーディングも設定
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		// アップロードされたファイルを処理
		Part part = request.getPart("beerImage");

		String newFileName;
		if (part != null && part.getSize() > 0) {
			// ファイル名を取得
			String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

			// 拡張子を取得する（例: .jpg, .png など）
			String fileExtension = fileName.substring(fileName.lastIndexOf("."));

			//       新しいファイル名に変換
			newFileName = "uploadedFile_" + System.currentTimeMillis() + fileExtension;

			String uploadPath = "C:\\pleiades\\2023-12\\workspace\\beerLists\\src\\main\\webapp\\img";
			File uploadDir = new File(uploadPath);

			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			try (InputStream fileContent = part.getInputStream()) {
				Files.copy(fileContent, new File(uploadPath + File.separator + newFileName).toPath());
				System.out.println("成功" + newFileName);
				System.out.println(uploadPath + File.separator + newFileName);
			}
		} else {
			newFileName = request.getParameter("oldBeerImage"); ;
		}

		//		リクエストパラメータの取得
		int Id = Integer.parseInt(request.getParameter("beerId"));

		String beerName = request.getParameter("beerName"); //ビール名

		String checkFavorite = request.getParameter("favorite"); // お気に入り
		boolean favorite = checkFavorite != null && checkFavorite.equals("true");

		String store = request.getParameter("store"); // ビール会社名

		String storeKinds = request.getParameter("storeKinds"); // 購入方法
		
		int price = Integer.parseInt(request.getParameter("price"));

		String beerKinds = request.getParameter("beerKinds"); // ビールの種類

		String feeling = request.getParameter("feeling"); // どんな時に飲みたいか

		String people = request.getParameter("people"); // どんな人と飲みたいか

		String memo = request.getParameter("memo"); // メモ
		

		//	Beerインスタンスの生成
		Beer beer = new Beer(Id, beerName, favorite, store, storeKinds, price, beerKinds, feeling, people, memo, newFileName);

		//		登録できたかどうかをisRegisterに登録
		EditBeerLogic bo = new EditBeerLogic();
		boolean isRegister = bo.execute(beer);

		//		登録成功時の処理（失敗の場合はnullのまま）
		if (isRegister) {
			//			リクエストスコープに保存
			request.setAttribute("editBeer", beer);

			//		登録結果画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/editResult.jsp");
			dispatcher.forward(request, response);

		} else { // 登録失敗時
			//		エラーメッセージを保存してフォワード
			String errorMsg = "登録に失敗しました。内容を確認してください。";
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/beerEdit.jsp");
			dispatcher.forward(request, response);
		}
	}

}
}
