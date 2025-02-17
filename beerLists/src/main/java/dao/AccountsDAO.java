package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountsDAO {
//	データベース接続に使用する情報
private static final String DB_URL = "jdbc:postgresql://localhost:5432/beerlists"; // データベース
private static final String DB_USER = "postgres"; // ユーザーネーム（所有者）
private static final String DB_PASS = "password"; // DBのパスワード

public Account findByLogin(Login login) {
	Account account = null;
	
//	JDBCドライバを読み込む	
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	}
//	データベース接続
	try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

//	SELECT文を準備
		String sql = "SELECT * FROM ACCOUNTS WHERE USER_NAME = ? AND PASSWORD = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, login.getUserName());
		ps.setString(2, login.getPassword());
		
//		SELECT文を実行し、結果表を取得
		ResultSet rs = ps.executeQuery();
		
//		データ1行分orNullだけほしいからifを用いる
		if (rs.next()) {
//			ユーザーが存在したらデータを取得
//			そのユーザーを表すAccountインスタンスを生成
			String userName = rs.getString("USER_NAME");
			String password = rs.getString("PASSWORD");
			String nickname = rs.getString("NICKNAME");
			int birthday = rs.getInt("AGE");
			account = new Account(userName, password, nickname, birthday);
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	return account; }

	public boolean create(Account account) {
	
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
				"INSERT INTO ACCOUNTS(USER_NAME, PASSWORD, NICKNAME, AGE) VALUES(?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
//	INSERT文中の「？」に私用する値を設定してSQL文を完成
		ps.setString(1, account.getUserName());
		ps.setString(2, account.getPassword());
		ps.setString(3, account.getNickname());
		ps.setInt(4, account.getAge());
	
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
}
