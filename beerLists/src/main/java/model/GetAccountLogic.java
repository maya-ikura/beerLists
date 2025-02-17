package model;

import dao.AccountsDAO;

public class GetAccountLogic {
//	login情報をAccountsDAOに入れてログイン情報があるか確認
	public Account execute(Login login) {
		AccountsDAO dao = new AccountsDAO();
		Account account = dao.findByLogin(login);
		return account;
	}


}
