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
<h2 class="heading-4">Q2：現在の気分はどうですか？</h2>
<form action="beerFortune" method="post">
<input type="hidden" name="questionNumber" value="2">
<fieldset class="checker-2">
  <label><input type="radio" name="qa2" value="仕事終わり" checked>疲れた、休みたい</label><br>
  <label><input type="radio" name="qa2" value="暑い日に">暑い、喉乾いた</label><br>
  <label><input type="radio" name="qa2" value="スポーツ観戦のときに">元気いっぱい！</label><br>
  <label><input type="radio" name="qa2" value="ストレス解消したいとき">イライラしている</label><br>
  <label><input type="radio" name="qa2" value="">普通</label>
</fieldset>
<button type="submit" class="button-1">次へ</button>
</form>
</div>
</div>

</body>
</html>