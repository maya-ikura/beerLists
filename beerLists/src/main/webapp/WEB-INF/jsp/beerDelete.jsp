<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飲んだビールリスト【ビール削除画面】</title>
<link rel="stylesheet" href="header.css">
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="beer.css">
<link rel="stylesheet" href="table.css">

</head>

<!-- ヘッダーメニューをインクルード -->
<jsp:include page="header.jsp" />
<body>
<div class="background">
    <div class="content-box">

<h2 class="heading-4">削除してもよろしいですか？</h2>

<br>
<p><img src="img/${beerEdit.beerImage}" alt="画像なし" style="max-width: 300px; max-height: 300px;"></p>
<table>
  <tr>
    <th>ビール名</th>
    <td>${beerEdit.beerName}<c:if test="${beerEdit.favorite}"><font color="red">★</font></c:if></td>
  </tr>
  <tr>
    <th>ビール会社名</th>
    <td>${beerEdit.store}</td>
  </tr>
  <tr>
    <th>値段</th>
    <td>${beerEdit.price} 円</td>
  </tr>
  <tr>
    <th>購入方法</th>
    <td>${beerEdit.storeKinds}</td>
  </tr>
  <tr>
    <th>ビールの種類</th>
    <td>${beerEdit.beerKinds}</td>
  </tr>
  <tr>
    <th>どんな時に飲みたい</th>
    <td>${beerEdit.feeling}</td>
  </tr>
  <tr>
    <th>どんな人と飲みたい</th>
    <td>${beerEdit.people}</td>
  </tr>
<tr>
    <th>メモ</th>
    <td>${beerEdit.memo}</td>
  </tr>
</table><br>
<form action="deleteBeer" method="post" enctype="multipart/form-data">
<input type="hidden" name="beerId" value="${beerEdit.id}">

<div class="input-checkbox-wrapper">
<input type="submit" value="削除" class="button-1"></form>　<a href="beerDetail?id=${beerEdit.id}" class="button-1">詳細へ戻る</a>
</div>
</div>
</div>

</body>
</html>