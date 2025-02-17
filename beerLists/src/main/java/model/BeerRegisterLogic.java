package model;

import dao.BeersDAO;

public class BeerRegisterLogic {
	public boolean execute(Beer beer) {
		BeersDAO dao = new BeersDAO();
		try {
		dao.create(beer);	
		return dao != null; //アカウント登録失敗の場合
	} catch(Exception e) {
//		エラーの場合はfalseを返す
		e.printStackTrace(); // ログにエラーを出力
		return false;

	}
	}
}
