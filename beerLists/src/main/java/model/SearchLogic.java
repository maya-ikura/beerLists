package model;

import java.util.ArrayList;
import java.util.List;

import dao.BeersDAO;

public class SearchLogic {
//	public List<Beer> execute(Beer beer){
//		BeersDAO dao = new BeersDAO();
//		List<Beer> findBeerLists = dao.findBeer(beer);
//		return findBeerLists;

	public List<Beer> execute(String beerName, String store, String favorite, 
    String[] storeKinds, String[] beerKinds, String[] feelings, String[] people){
		BeersDAO dao = new BeersDAO();
		List<Beer> findBeerList = new ArrayList<>();
		try {
			findBeerList = dao.searchBeers(beerName, store, favorite, 
					storeKinds, beerKinds, feelings, people);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findBeerList;
}

	

}
