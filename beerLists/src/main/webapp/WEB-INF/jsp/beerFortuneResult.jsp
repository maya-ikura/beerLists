<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飲んだビールリスト【診断結果】</title>
<link rel="stylesheet" href="header.css">
<link rel="stylesheet" href="styles3.css">
<link rel="stylesheet" href="beer.css">
<link rel="stylesheet" href="table.css">
</head>

<!-- ヘッダーメニューをインクルード -->
<jsp:include page="header.jsp" />
<body>
<div class="background">
    <div class="content-box">

<br>
<h1 class="heading-12">
    <span>診断結果</span>
</h1>

<br>

<h2 class="heading-4">あなたにぴったりなビールは<a href="beerDetail?id=${RandomBeer.id}"><strong>${RandomBeer.beerName}</strong></a>です！</h2>
<p><img src="img/${RandomBeer.beerImage}" alt="画像なし" style="max-width: 300px; max-height: 300px;"></p>
<br>
<table>
  <tr>
    <th>ビール会社名</th>
    <td>${RandomBeer.store}</td>
  </tr>
  <tr>
    <th>値段</th>
    <td>${RandomBeer.price} 円</td>
  </tr>
  <tr>
    <th>購入方法</th>
    <td>${RandomBeer.storeKinds}</td>
  </tr>
  <tr>
    <th>ビールの種類</th>
    <td>${RandomBeer.beerKinds}</td>
  </tr>
</table>

<br>
<!--吹き出しはじまり-->
<div class="balloon5">
    <img src="img/beer_chan.png">
  <div class="chatting">
    <div class="says">
      <p>帰りに買ってこよう！！！</p>
    </div>
  </div>
</div>
<!--吹き出し終わり-->
<br><a href="top" class="button-1">ビール一覧へ戻る</a>
<br></div>
</div>
</body>
</html>