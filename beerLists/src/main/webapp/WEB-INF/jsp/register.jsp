

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飲んだビールリスト【新規登録】</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
    <div class="container">
        <div class="box18">
<h1>新規登録</h1>
<!-- エラーメッセージがある場合は表示 -->
<c:if test="${not empty errorMsg2}">
<p style="color:red"><c:out value="${errorMsg2}" /></p>
</c:if>

<form action="register" method="post" class="login-form">
<p>ユーザーID：<input type="text" name="userName" minlength="8" placeholder="8文字以上" required="required"></p>
<p>パスワード：<input type="password" name="password" minlength="8" placeholder="8文字以上の英数字" required="required"></p>
<p>ニックネーム：<input type="text" name="nickname" placeholder="登録者名で使用します" required="required"></p>
<p>年齢：<input type="text" name="age" placeholder="20歳未満は登録できません" required="required"></p>
<br><input type="submit" value="新規登録">
</form><br>
<a href="index">ログイン画面へ戻る</a>
</div>
</div>
</body>
</html>