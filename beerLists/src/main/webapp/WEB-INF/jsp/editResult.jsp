<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飲んだビールリスト【編集完了画面】</title>
<link rel="stylesheet" href="header.css">
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="beer.css">
<link rel="stylesheet" href="table.css">
</head>

<!-- ヘッダーメニューをインクルード -->
<jsp:include page="header.jsp" />

<body>
<div class="background">
    <div class="content-box"><br>
<h2 class="heading-4">編集完了</h2>
<p>編集が完了しました！</p>
<table>
  <tr>
    <th>ビール名</th>
    <td>${editBeer.beerName}<c:if test="${editBeer.favorite}"><font color="red">★</font></c:if></td>
  </tr>
  <tr>
    <th>ビール会社名</th>
    <td>${editBeer.store}</td>
  </tr>
  <tr>
    <th>値段</th>
    <td>${editBeer.price} 円</td>
  </tr>
  <tr>
    <th>購入方法</th>
    <td>${editBeer.storeKinds}</td>
  </tr>
  <tr>
    <th>ビールの種類</th>
    <td>${editBeer.beerKinds}</td>
  </tr>
  <tr>
    <th>どんな時に飲みたい</th>
    <td>${editBeer.feeling}</td>
  </tr>
  <tr>
    <th>どんな人と飲みたい</th>
    <td>${editBeer.people}</td>
  </tr>
<tr>
    <th>メモ</th>
    <td>${editBeer.memo}</td>
  </tr>
<tr>
    <th>登録者</th>
    <td>${editBeer.nickname}</td>
  </tr>
</table>
<br>
<p><a href="beerDetail?id=${editBeer.id}" class="button-1">詳細画面へ戻る</a></p>
</div>
</div>
</body>
</html>