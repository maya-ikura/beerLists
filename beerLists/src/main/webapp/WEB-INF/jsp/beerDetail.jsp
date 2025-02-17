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
    <div class="content-box">

<br>   
<h2 class="heading-4">${BeerDetail.beerName}の詳細情報</h2>
<br>

<!-- エラーメッセージがある場合は表示 -->
<c:if test="${not empty errorMsg}">
<p style="color:red"><c:out value="${errorMsg}" /></p>
</c:if>
<p><img src="img/${BeerDetail.beerImage}" alt="画像なし" style="max-width: 300px; max-height: 300px;"></p>
<table>
  <tr>
    <th>ビール名</th>
    <td>${BeerDetail.beerName}<c:if test="${BeerDetail.favorite}"><font color="red">★</font></c:if></td>
  </tr>
  <tr>
    <th>ビール会社名</th>
    <td>${BeerDetail.store}</td>
  </tr>
  <tr>
    <th>値段</th>
    <td>${BeerDetail.price} 円</td>
  </tr>
  <tr>
    <th>購入方法</th>
    <td>${BeerDetail.storeKinds}</td>
  </tr>
  <tr>
    <th>ビールの種類</th>
    <td>${BeerDetail.beerKinds}</td>
  </tr>
  <tr>
    <th>どんな時に飲みたい</th>
    <td>${BeerDetail.feeling}</td>
  </tr>
  <tr>
    <th>どんな人と飲みたい</th>
    <td>${BeerDetail.people}</td>
  </tr>
<tr>
    <th>メモ</th>
    <td>${BeerDetail.memo}</td>
  </tr>
<tr>
    <th>登録者</th>
    <td>${BeerDetail.nickname}</td>
  </tr>
</table>
<br>
<div class="input-checkbox-wrapper">
<a href="beerEdit?id=${BeerDetail.id}" class="button-1">編集</a><a href="deleteBeer?id=${BeerDetail.id}" class="button-1">削除</a><a href="top" class="button-1">一覧へ</a></div>
 
</div>
</div>
</body>
</html>