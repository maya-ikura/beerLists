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
<h2 class="heading-4">Q5：お気に入りのビールを飲みたい気分ですか？</h2>
<form action="beerFortune" method="post">
<input type="hidden" name="questionNumber" value="5">
<fieldset class="checker-2">
  <label><input type="checkbox" name="qa5" value="True">飲みたい場合はチェック！</label>
</fieldset>
<button type="submit" class="button-1">診断する！</button>
</form>
</div>
</div>

</body>