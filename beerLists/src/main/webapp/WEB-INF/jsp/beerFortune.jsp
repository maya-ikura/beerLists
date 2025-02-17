<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ビール診断</title>
<link rel="stylesheet" href="header.css">
<link rel="stylesheet" href="styles2.css">
<link rel="stylesheet" href="beer.css">
</head>

<!-- ヘッダーメニューをインクルード -->
<jsp:include page="header.jsp" />
<body>
<div class="background">
    <div class="content-box">

<br>
<h1 class="heading-12">
    <span>今日のビール診断</span>
</h1>
<br>
<h2 class="heading-4">Q1：好みの味は何ですか？</h2>

<form action="beerFortune" method="POST">
<input type="hidden" name="questionNumber" value="1">
<fieldset class="checker-2">
<label><input type="radio" name="qa1" value="IPA,ペールエール" checked>苦味が強いビール</label><br>
<label><input type="radio" name="qa1" value="スタウト・ポーター,ブラウンエール,ヴァイツェン">甘みのあるビール</label><br>
<label><input type="radio" name="qa1" value="ベルシャン・ホワイト,セゾン,ランビック">酸味のあるビール</label><br>
<label><input type="radio" name="qa1" value="アンバーエール,ピルスナー,シュヴァルツ,その他">特になし</label>
</fieldset>
<br>
<button type="submit" class="button-1">次へ</button>
</form>
</div>
</div>
</body>
</html>