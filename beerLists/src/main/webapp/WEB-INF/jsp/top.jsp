<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飲んだビールリスト</title>
<link rel="stylesheet" href="cards.css"> <!-- 新しく追加するCSSファイル -->
<script src="show-more.js" defer></script> <!-- 新しく追加するJSファイル -->
<link rel="stylesheet" href="header.css">
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="beer.css">


</head>

<!-- ヘッダーメニューをインクルード -->
<jsp:include page="header.jsp" />

<body>
<div class="background">
    <div class="content-box">
    <br>   
<h2 class="heading-4">ビール一覧</h2><br>
    
        <!-- ビールリスト一覧 -->
        <div class="beer-gallery">
            <!-- ビールリストのアイテムをカード形式で表示 -->
            <c:forEach var="beer" items="${beerLists}">
            	<a href="beerDetail?id=${beer.id}" class="beer-card">
                    <img src="img/${beer.beerImage}" alt="画像なし" class="beer-image">
                    <div class="beer-info">
                        <p class="beer-name">${beer.beerName}</p>
                        <p class="store">${beer.store}</p>
                    </div>
                        <!-- 条件付きでリボンを表示 -->
    <c:if test="${beer.favorite}">
        <div class="ribbon">★</div>
    </c:if>
                </a>
            </c:forEach>
        </div>
        <button id="show-more-button">もっと見る</button> <!-- 「もっと見る」ボタン -->
    </div>
</div>
</body>
</html>
