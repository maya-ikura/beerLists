package model;

import dao.BeersDAO;

public class DeleteBeerLogic {
	public boolean execute(int id) {
	BeersDAO dao = new BeersDAO();
	try {
			dao.delete(id);	
			return dao != null; //成功
		} catch(Exception e) {
			e.printStackTrace(); // 削除失敗時
			return false;

		}
	}

}
