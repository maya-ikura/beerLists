<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飲んだビールリスト</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
    <div class="container">
        <div class="box18">
            <h1>ログイン</h1>
            <!-- エラーメッセージがある場合は表示 -->
            <c:if test="${not empty errorMsg}">
                <p style="color:red"><c:out value="${errorMsg}" /></p>
            </c:if>

            <form action="top" method="post" class="login-form">
                <p>ユーザーID：<input type="text" name="userName"></p>
                <p>パスワード：<input type="password" name="password"></p>
                <input type="submit" value="ログイン">
            </form>
            <br>
            <p>アカウントをお持ちでない場合<br><a href="register">新規登録はこちら</a></p>
        </div>
    </div>

</body>
</html>