package model;

//　ユーザーと名前はあとで余裕があれば

public class Beer {
	private int id; // id
	private String beerName; // ビール名
	private boolean favorite; // お気に入り
	private String store; // ビール会社名
	private String storeKinds; // 購入方法
	private int price; // ビールの金額
	private String beerKinds; // ビールの種類
	private String feeling; // どんな時に飲みたいか
	private String people; // どんな人と飲みたいか
	private String memo; // めも
	private String beerImage; // 写真のフォルダパス
	private String userName; // ユーザーID
	private String nickname; // ニックネーム
	

	
	public Beer(int id, String beerName, boolean favorite, String store, 
			String storeKinds, int price, String beerKinds, 
			String feeling, String people, String memo, String beerImage, String userName, String nickname) {
		this.id = id;
		this.beerName = beerName;
		this.favorite = favorite;
		this.store = store;
		this.storeKinds = storeKinds;
		this.price = price;
		this.beerKinds = beerKinds;
		this.feeling = feeling;
		this.people = people;
		this.memo = memo;
		this.beerImage = beerImage;
		this.userName = userName; // ユーザーID
		this.nickname = nickname; // ニックネーム
	}
		
	
	public Beer(int id, String beerName, boolean favorite, String store, 
			String storeKinds, int price, String beerKinds, 
			String feeling, String people, String memo, String beerImage) {
		this.id = id;
		this.beerName = beerName;
		this.favorite = favorite;
		this.store = store;
		this.storeKinds = storeKinds;
		this.price = price;
		this.beerKinds = beerKinds;
		this.feeling = feeling;
		this.people = people;
		this.memo = memo;
		this.beerImage = beerImage;
	}
	
	public Beer(String beerName, boolean favorite, String store, 
			String storeKinds, int price, String beerKinds, 
			String feeling, String people, String memo, String beerImage, 
			String userName, String nickname) {
		this.beerName = beerName;
		this.favorite = favorite;
		this.store = store;
		this.storeKinds = storeKinds;
		this.price = price;
		this.beerKinds = beerKinds;
		this.feeling = feeling;
		this.people = people;
		this.memo = memo;
		this.beerImage = beerImage;
		this.userName = userName; // ユーザーID
		this.nickname = nickname; // ニックネーム

	}
	
	public Beer(String beerName, boolean favorite, String store, 
			String storeKinds, String beerKinds, 
			String feeling, String people,String memo, String beerImage) {
		this.beerName = beerName;
		this.favorite = favorite;
		this.store = store;
		this.storeKinds = storeKinds;
		this.beerKinds = beerKinds;
		this.feeling = feeling;
		this.people = people;
		this.memo = memo;
		this.beerImage = beerImage;
	}

	public Beer(String beerName, boolean favorite, String store, 
			String storeKinds, String beerKinds, 
			String feeling, String people) {
		this.beerName = beerName;
		this.favorite = favorite;
		this.store = store;
		this.storeKinds = storeKinds;
		this.beerKinds = beerKinds;
		this.feeling = feeling;
		this.people = people;

	}
	
	
	public Beer(){}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBeerName() {
		return beerName;
	}

	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getStoreKinds() {
		return storeKinds;
	}

	public void setStoreKinds(String storeKinds) {
		this.storeKinds = storeKinds;
	}

	public String getBeerKinds() {
		return beerKinds;
	}

	public void setBeerKinds(String beerKinds) {
		this.beerKinds = beerKinds;
	}

	public String getFeeling() {
		return feeling;
	}

	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getBeerImage() {
		return beerImage;
	}

	public void setBeerImage(String beerImage) {
		this.beerImage = beerImage;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}
	
	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getUserName() {
		return userName;
	}


	public String getNickname() {
		return nickname;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	
	
	
}
