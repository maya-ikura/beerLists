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
<h2 class="heading-4">Q3：どんな時に飲む予定ですか？</h2>
<form action="beerFortune" method="post">
<input type="hidden" name="questionNumber" value="3">
<fieldset class="checker-2">
  <label><input type="radio" name="qa3" value="スポーツ観戦のときに" checked>スポーツ観戦やライブの時に</label><br>
  <label><input type="radio" name="qa3" value="ストレス解消したいとき">遊ぶときに</label><br>
  <label><input type="radio" name="qa3" value="食事を楽しみたいとき">食事のときに</label><br>
  <label><input type="radio" name="qa3" value="特別な日やご褒美">特別な日に（誕生日など）</label><br>
  <label><input type="radio" name="qa3" value="リラックスしたいとき">晩酌などまったりと</label>
</fieldset>
<button type="submit" class="button-1">次へ</button>
</form>
</div>
</div>

</body>