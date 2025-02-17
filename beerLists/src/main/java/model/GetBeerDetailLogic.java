package model;

import dao.BeersDAO;

public class GetBeerDetailLogic {
	public Beer execute(int id){
		BeersDAO dao = new BeersDAO();
		Beer beer = dao.findDetail(id);
		return beer;
	}
}
