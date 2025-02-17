package model;

import dao.AccountsDAO;

public class RegisterLogic {
	public boolean execute(Account account) {
		AccountsDAO dao = new AccountsDAO();
		try {
		dao.create(account);	
		return dao != null; //アカウント登録失敗の場合
	} catch(Exception e) {
//		エラーの場合はfalseを返す
		e.printStackTrace(); // ログにエラーを出力
		return false;

	}
	}
}

