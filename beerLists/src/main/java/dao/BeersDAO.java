package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Beer;

public class BeersDAO {
//	データベース接続に使用する情報
private static final String DB_URL = "jdbc:postgresql://localhost:5432/beerlists"; // データベース
private static final String DB_USER = "postgres"; // ユーザーネーム（所有者）
private static final String DB_PASS = "password"; // DBのパスワード

public List<Beer> findall() {
	List<Beer> beerlists = new ArrayList<>();
//	JDBCドライバを読み込む	
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	}
//	データベース接続
	try (Connection conn = 
			DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
		
//		SELECT文の準備
		String sql = "SELECT * FROM BEERS ORDER BY ID DESC";
		PreparedStatement ps = conn.prepareStatement(sql);
		
//		SELECTを実行
		ResultSet rs = ps.executeQuery();
		
//		SELECT文の結果をArraylistに追加
		while(rs.next()) {
			int id = rs.getInt("id"); // ID
			String beerName = rs.getString("beer_name"); // ビール名
			boolean favorite = rs.getBoolean("favorite"); // お気に入り
			String store = rs.getString("store"); // 購入先
			String storeKinds = rs.getString("store_kinds"); // 購入方法
			int price = rs.getInt("price"); // 値段
			String beerKinds = rs.getString("beer_kinds"); // ビールの種類
			String feeling = rs.getString("feeling"); // どんな時に飲みたいか
			String people = rs.getString("people"); // どんなひとと飲みたいか
			String memo = rs.getString("memo"); // めも
            String beerImage = rs.getString("beer_image");  // 画像のファイルパスを取得
			String userName = rs.getString("user_name"); // ユーザーID
			String nickname = rs.getString("nickname"); // ニックネーム

			
			Beer beer = new Beer(id, beerName, favorite, store, storeKinds, price, beerKinds, feeling, people, memo, beerImage, userName, nickname);
			beerlists.add(beer);			
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return null; // listがつくられていないのでnull
	}
	return beerlists;	

	}

public Beer findDetail(int id) {

	Beer beer = null;
//	JDBCドライバを読み込む	
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	}
//	データベース接続
	try (Connection conn = 
			DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
		
//		SELECT文の準備
		String sql = "SELECT * FROM BEERS WHERE ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		
//		SELECTを実行
		ResultSet rs = ps.executeQuery();
		
//		SELECT文の結果を追加
		if(rs.next()) {
			int getId = rs.getInt("id"); // ID
			String beerName = rs.getString("beer_name"); // ビール名
			boolean favorite = rs.getBoolean("favorite"); // お気に入り
			String store = rs.getString("store"); // 購入先
			String storeKinds = rs.getString("store_kinds"); // 購入方法
			int price = rs.getInt("price"); // 値段
			String beerKinds = rs.getString("beer_kinds"); // ビールの種類
			String feeling = rs.getString("feeling"); // どんな時に飲みたいか
			String people = rs.getString("people"); // どんなひとと飲みたいか
			String memo = rs.getString("memo"); // めも
            String beerImage = rs.getString("beer_image");  // 画像のファイルパスを取得
			String userName = rs.getString("user_name"); // ユーザーID
			String nickname = rs.getString("nickname"); // ニックネーム
			
            beer = new Beer(getId, beerName, favorite, store, storeKinds, price, beerKinds, feeling, people, memo, beerImage, userName, nickname);
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return null; // listがつくられていないのでnull
	}
	return beer;	
	}

//	ビールをDBに登録する処理
	public boolean create(Beer beer) {
	
//	JDBCドライバを読み込む	
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	}
//	データベース接続
	try (Connection conn = 
			DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

//	INSERT文の準備
		String sql = 
				"INSERT INTO BEERS (BEER_NAME, FAVORITE, STORE, STORE_KINDS, PRICE, BEER_KINDS, FEELING, PEOPLE, MEMO, BEER_IMAGE, USER_NAME, NICKNAME) VALUES(?, ?, ?, ?::store_types, ?, ?::beer_types, ?::feel_types, ?::pp_types, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
//	INSERT文中の「？」に私用する値を設定してSQL文を完成
		ps.setString(1, beer.getBeerName());
		ps.setBoolean(2, beer.isFavorite());
		ps.setString(3, beer.getStore());
		ps.setString(4, beer.getStoreKinds());
		ps.setInt(5, beer.getPrice());
		ps.setString(6, beer.getBeerKinds());
		ps.setString(7, beer.getFeeling());
		ps.setString(8, beer.getPeople());
		ps.setString(9, beer.getMemo());
		ps.setString(10, beer.getBeerImage());
		ps.setString(11, beer.getUserName());
		ps.setString(12, beer.getNickname());
		
//	INSERT文の実行（resultには追加された行数が代入される）
		int result = ps.executeUpdate();
		if(result != 1) {
			return false;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	return true;
	}


//	DBのビール情報を編集する処理
	public boolean beerEdit(Beer beer) {
	
//	JDBCドライバを読み込む	
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	}
//	データベース接続
	try (Connection conn = 
			DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

//	INSERT文の準備
		String sql =
		"UPDATE BEERS SET BEER_NAME = ?, FAVORITE = ?, STORE = ?, STORE_KINDS = ?::store_types, PRICE = ?, BEER_KINDS = ?::beer_types, FEELING = ?::feel_types, MEMO = ?, BEER_IMAGE = ?, PEOPLE = ?::pp_types WHERE ID = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
//	INSERT文中の「？」に私用する値を設定してSQL文を完成
		ps.setString(1, beer.getBeerName());
		ps.setBoolean(2, beer.isFavorite());
		ps.setString(3, beer.getStore());
		ps.setString(4, beer.getStoreKinds());
		ps.setInt(5, beer.getPrice());
		ps.setString(6, beer.getBeerKinds());
		ps.setString(7, beer.getFeeling());
		ps.setString(8, beer.getMemo());
		ps.setString(9, beer.getBeerImage());
		ps.setString(10, beer.getPeople());
		ps.setInt(11, beer.getId());

		
//	INSERT文の実行（resultには追加された行数が代入される）
		int result = ps.executeUpdate();
		if (result != 1) {
			return false;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	return true;
	}


//ビールをDBから削除する処理
public boolean delete(int id) {

//JDBCドライバを読み込む	
try {
	Class.forName("org.postgresql.Driver");
} catch (ClassNotFoundException e) {
	throw new IllegalStateException("JDBCドライバを読み込めませんでした");
}
//データベース接続
try (Connection conn = 
		DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

//INSERT文の準備
	String sql =
			"DELETE FROM BEERS WHERE ID = ?";
	
	PreparedStatement ps = conn.prepareStatement(sql);
	
//	INSERT文中の「？」に私用する値を設定してSQL文を完成
		ps.setInt(1, id);
		
//		INSERT文の実行（resultには追加された行数が代入される）
			int result = ps.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		}
		
		
//		DBの検索処理

	public List<Beer> searchBeers(String beerName, String store, String favorite, 
        String[] storeKinds, String[] beerKinds, String[] feeling, String[] people) throws Exception {
	
//	新しいアレイリストを作成
	List<Beer> beerList = new ArrayList<>();
	
//	JDBCドライバを読み込む	
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	}
//	データベース接続
	try (Connection conn = 
			DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
	
	
	StringBuilder sql = new StringBuilder("SELECT * FROM beers WHERE 1=1");

	// ビール名が入力されていればLIKE句を追加
    if (beerName != null && !beerName.isEmpty()) {
        sql.append(" AND beer_name LIKE ?");
    }
    
    // ビール会社名が入力されていればLIKE句を追加
    if (store != null && !store.isEmpty()) {
        sql.append(" AND store LIKE ?");
    }
    
    // お気に入りが選択されていれば条件を追加
    if (favorite != null && favorite.equals("true")) {
        sql.append(" AND favorite = true");
    }
    
    // 購入方法が選択されていればIN句を追加
    if (storeKinds != null && storeKinds.length > 0) {
        sql.append(" AND store_kinds IN (");
        for (int i = 0; i < storeKinds.length; i++) {
            sql.append("?::store_types");
            if (i < storeKinds.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");
    }
    
    // ビールの種類が選択されていればIN句を追加
    if (beerKinds != null && beerKinds.length > 0) {
        sql.append(" AND beer_kinds IN (");
        for (int i = 0; i < beerKinds.length; i++) {
            sql.append("?::beer_types");
            if (i < beerKinds.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");
    }
    
    // どんな時に飲みたいかが選択されていればIN句を追加
    if (feeling != null && feeling.length > 0) {
        sql.append(" AND feeling IN (");
        for (int i = 0; i < feeling.length; i++) {
            sql.append("?::feel_types");
            if (i < feeling.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");
    }
    
    // どんな人と飲みたいかが選択されていればIN句を追加
    if (people != null && people.length > 0) {
        sql.append(" AND people IN (");
        for (int i = 0; i < people.length; i++) {
            sql.append("?::pp_types");
            if (i < people.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");
    }
    
    // SQL文を表示
    System.out.println("Generated SQL: " + sql.toString());
    
    PreparedStatement ps = conn.prepareStatement(sql.toString());
    
    // プレースホルダーに選択された値をセット
    int index = 0;
    
    // ビール名
    if (beerName != null && !beerName.isEmpty()) {
        ps.setString(++index, "%" + beerName + "%");
    }
    
    // ビール会社名
    if (store != null && !store.isEmpty()) {
        ps.setString(++index, "%" + store + "%");
    }
    
    // 購入方法
    if (storeKinds != null) {
        for (String kind : storeKinds) {
            ps.setString(++index, kind);
        }
    }
    
    // ビールの種類
    if (beerKinds != null) {
        for (String kind : beerKinds) {
            ps.setString(++index, kind);
        }
    }
    
    // どんな時に飲みたいか
    if (feeling != null) {
        for (String feelings : feeling) {
            ps.setString(++index, feelings);
        }
    }
    
    // どんな人と飲みたいか
    if (people != null) {
        for (String person : people) {
            ps.setString(++index, person);
        }
    }

   // SQL文を表示
   System.out.println("Generated SQL: " + sql);

    ResultSet rs = ps.executeQuery();
    
    while (rs.next()) {
        Beer beer = new Beer();
        beer.setId(rs.getInt("id"));
        beer.setBeerName(rs.getString("beer_name"));
        beer.setStore(rs.getString("store"));
        beer.setPrice(rs.getInt("price"));
        beer.setBeerKinds(rs.getString("beer_kinds"));
        beer.setStoreKinds(rs.getString("store_kinds"));
        beer.setFeeling(rs.getString("feeling"));
        beer.setPeople(rs.getString("people"));
        beer.setBeerImage(rs.getString("beer_image"));
        beer.setUserName(rs.getString("user_name"));
        beer.setNickname(rs.getString("nickname"));
        
        beerList.add(beer);
    }
    
} catch (SQLException e) {
    e.printStackTrace();
    return null; // listがつくられていないのでnull
}
return beerList;
}

//ビールの画像をDBから削除する処理
public boolean deleteImg(String beerImage) {

//JDBCドライバを読み込む	
try {
	Class.forName("org.postgresql.Driver");
} catch (ClassNotFoundException e) {
	throw new IllegalStateException("JDBCドライバを読み込めませんでした");
}
//データベース接続
try (Connection conn = 
		DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

//INSERT文の準備
	String sql =
			"UPDATE BEERS SET BEER_IMAGE = NULL WHERE BEER_IMAGE = ?";
	
	
	
	PreparedStatement ps = conn.prepareStatement(sql);
	
//	INSERT文中の「？」に私用する値を設定してSQL文を完成
		ps.setString(1, beerImage);
		
//		INSERT文の実行（resultには追加された行数が代入される）
			int result = ps.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
}



public List<Beer> GetBeerKindsList(String[] beerKind) {

//	新しいアレイリストを作成
	List<Beer> beerlist = new ArrayList<>();
//	JDBCドライバを読み込む	
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	}
//	データベース接続
	try (Connection conn = 
			DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
		
//		SELECT文の準備
		StringBuilder sql = new StringBuilder("SELECT * FROM beers WHERE store_kinds IN ('缶'::store_types, '瓶'::store_types)");
		
	    // ビールの種類が選択されていればIN句を追加
	    if (beerKind != null && beerKind.length > 0) {
	        sql.append(" AND beer_kinds IN (");
	        for (int i = 0; i < beerKind.length; i++) {
	            sql.append("?::beer_types");
	            if (i < beerKind.length - 1) {
	                sql.append(", ");
	            }
	        }
	        sql.append(")");
	    }

	    // SQL文を表示
	    System.out.println("Generated SQL: " + sql.toString());		
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		
		int index = 0;
	    // ビールの種類
	        for (String kind : beerKind) {
	            ps.setString(++index, kind);
	    }

		
//		SELECTを実行
		ResultSet rs = ps.executeQuery();
		
//		SELECT文の結果をArraylistに追加
		while(rs.next()) {
			int id = rs.getInt("id"); // ID
			String beerName = rs.getString("beer_name"); // ビール名
			boolean favorite = rs.getBoolean("favorite"); // お気に入り
			String store = rs.getString("store"); // 購入先
			String storeKinds = rs.getString("store_kinds"); // 購入方法
			int price = rs.getInt("price"); // 値段
			String beerKinds = rs.getString("beer_kinds"); // ビールの種類
			String feeling = rs.getString("feeling"); // どんな時に飲みたいか
			String people = rs.getString("people"); // どんなひとと飲みたいか
			String memo = rs.getString("memo"); // めも
            String beerImage = rs.getString("beer_image");  // 画像のファイルパスを取得
            String userName = rs.getString("user_name");
            String nickname = rs.getString("nickname");
			
			Beer beer = new Beer(id, beerName, favorite, store, storeKinds, price, beerKinds, feeling, people, memo, beerImage,userName, nickname);
			beerlist.add(beer);			
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return null; // listがつくられていないのでnull
	}
	return beerlist;	

	}

	}
