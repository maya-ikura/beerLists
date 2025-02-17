package test;

import dao.AccountsDAO;
import model.Account;
import model.Login;

public class AccountsDAOTest {
	public static void main(String[] args) {
		testFindByLoginOK(); // ユーザーが見つかる場合のテスト
		testFindByLoginNG(); // ユーザーが見つからない場合のテスト
	}	
		public static void testFindByLoginOK() {
			Login login =new Login("test0001", "test1234");
			AccountsDAO dao =new AccountsDAO();
			Account result = dao.findByLogin(login);
			
			if (result != null &&
					result.getUserName().equals("test0001") &&
					result.getPassword().equals("test1234") &&
					result.getNickname().equals("森谷　真弥") &&
					result.getAge() == 32) {
				System.out.println("testFindByLoginOK：成功しました");
			} else {
				System.out.println("testFindByLoginOK：失敗しました");
			}
		}
		
		public static void testFindByLoginNG() {
			Login login = new Login("minato", "12345");
			AccountsDAO dao = new AccountsDAO();
			Account result = dao.findByLogin(login);
			
		if (result == null) {
			System.out.println("testFindByLoginNG：成功しました");
		} else {
			System.out.println("testFindByLoginNG：失敗しました");
		}
	}
}
