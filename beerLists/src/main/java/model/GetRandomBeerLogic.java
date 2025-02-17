package model;

import java.util.List;
import java.util.Random;

import dao.BeersDAO;

public class GetRandomBeerLogic {
	 public Beer getRandomBeer(String[] beerKinds) {
		 	BeersDAO dao = new BeersDAO();
		 	List<Beer> beerList =dao.GetBeerKindsList(beerKinds); // GetBeerKindsListメソッドを呼び出す
	        if (beerList == null || beerList.isEmpty()) {
	            return null; // リストが空の場合はnullを返す
	        }

	        Random random = new Random();
	        int randomIndex = random.nextInt(beerList.size()); // ランダムなインデックスを生成
	        return beerList.get(randomIndex); // ランダムに選ばれたビールを返す
	    }
}
