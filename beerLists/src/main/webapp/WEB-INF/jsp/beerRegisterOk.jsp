<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飲んだビールリスト</title>
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
<h2 class="heading-4">ビール登録完了</h2>
<p>登録が完了しました！</p>
<table>
  <tr>
    <th>ビール名</th>
    <td>${registerBeer.beerName}<c:if test="${registerBeer.favorite}"><font color="red">★</font></c:if></td>
  </tr>
  <tr>
    <th>ビール会社名</th>
    <td>${registerBeer.store}</td>
  </tr>
  <tr>
    <th>値段</th>
    <td>${registerBeer.price} 円</td>
  </tr>
  <tr>
    <th>購入方法</th>
    <td>${registerBeer.storeKinds}</td>
  </tr>
  <tr>
    <th>ビールの種類</th>
    <td>${registerBeer.beerKinds}</td>
  </tr>
  <tr>
    <th>どんな時に飲みたい</th>
    <td>${registerBeer.feeling}</td>
  </tr>
  <tr>
    <th>どんな人と飲みたい</th>
    <td>${registerBeer.people}</td>
  </tr>
<tr>
    <th>メモ</th>
    <td>${registerBeer.memo}</td>
  </tr>
<tr>
    <th>登録者</th>
    <td>${registerBeer.nickname}</td>
  </tr>
</table>

<p><a href="top" class="button-1">ビール一覧へ戻る</a></p>
</div>
</div>
</body>
</html>