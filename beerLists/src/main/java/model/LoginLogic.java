package model;

import dao.AccountsDAO;

//　ログイン処理のモデル
public class LoginLogic {
//	login情報をAccountsDAOに入れてログイン情報があるか確認
	public boolean execute(Login login) {
		AccountsDAO dao = new AccountsDAO();

		try {
		Account account = dao.findByLogin(login);
		return account != null; // アカウントがあればTrue
	} catch(Exception e) {
//		エラーの場合はfalseを返す
		e.printStackTrace(); // ログにエラーを出力
		return false;
	}
}
}
