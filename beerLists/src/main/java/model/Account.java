package model;

public class Account {
		private String userName; // ユーザーID
		private String password; // パスワード
		private String nickname; // ニックネーム
		private int age; // 年齢
		
		public Account
		(String userName, String password, String nickname, int age) {
			this.userName = userName;
			this.password = password;
			this.nickname = nickname;
			this.age = age;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}

		