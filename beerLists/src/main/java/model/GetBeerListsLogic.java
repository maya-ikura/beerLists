package model;

import java.util.List;

import dao.BeersDAO;

public class GetBeerListsLogic {
public List<Beer> execute(){
	BeersDAO dao = new BeersDAO();
	List<Beer> beerLists = dao.findall();
	return beerLists;
}

}
