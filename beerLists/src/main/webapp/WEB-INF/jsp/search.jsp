<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飲んだビールリスト【検索画面】</title>
 <!-- CSSファイルのリンク -->
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
<h2 class="heading-4">ビール検索</h2>
<!-- エラーメッセージがある場合は表示 -->
<c:if test="${not empty errorMsg}">
<p style="color:red"><c:out value="${errorMsg}" /></p>
</c:if>
<br>
<form action="beerSearch" method="post" accept-charset="UTF-8">
<div class="cp_iptxt">
  <label class="ef">
  <input type="text" name="beerName" placeholder="ビール名">
    </label>
</div>

<br>

<div class="input-checkbox-wrapper">
<div class="cp_iptxt2">
  <label class="ef">
<input type="text" name="store" placeholder="会社名（●●ブルワリーなど）">
  </label>
</div>
<div class="cp_ipcheck01">
<input type="checkbox" name="favorite" value="true" id="favorite-checkbox"><label for="favorite-checkbox">お気に入り</label>
</div>
</div>

<br>
<fieldset class="checker-2">
<b><font color="#446E72">購入方法</font></b></fieldset>
<fieldset class="checker-2">
<label><input type="checkbox" name="storeKinds" value="缶">缶</label>
<label><input type="checkbox" name="storeKinds" value="瓶">瓶</label>
<label><input type="checkbox" name="storeKinds" value="店内飲酒">店内飲酒</label></fieldset>

<br>
<fieldset class="checker-2">
<b><font color="#446E72">ビールの種類</font></b></fieldset>
<fieldset class="checker-2">
<label><input type="checkbox" name="beerKinds" value="ピルスナー">ピルスナー</label>
<label><input type="checkbox" name="beerKinds" value="シュヴァルツ">シュヴァルツ</label>
<label><input type="checkbox" name="beerKinds" value="ヴァイツェン">ヴァイツェン</label>
<label><input type="checkbox" name="beerKinds" value="ベルシャン・ホワイト">ベルシャン・ホワイト</label>
<label><input type="checkbox" name="beerKinds" value="アンバーエール">アンバーエール</label>
<label><input type="checkbox" name="beerKinds" value="ブラウンエール">ブラウンエール</label>
<label><input type="checkbox" name="beerKinds" value="セゾン">セゾン</label>
<label><input type="checkbox" name="beerKinds" value="ペールエール">ペールエール</label>
<label><input type="checkbox" name="beerKinds" value="IPA">IPA</label>
<label><input type="checkbox" name="beerKinds" value="ポーター・スタウト">ポーター・スタウト</label>
<label><input type="checkbox" name="beerKinds" value="その他">その他</label></fieldset>

<br>
<fieldset class="checker-2">
<b><font color="#446E72" >どんな時に飲みたいか</font></b></fieldset>
<fieldset class="checker-2">
<label><input type="checkbox" name="feeling" value="仕事終わり">仕事終わり</label>
<label><input type="checkbox" name="feeling" value="ストレス解消したいとき">ストレス解消したいとき</label>
<label><input type="checkbox" name="feeling" value="リラックスしたいとき">リラックスしたいとき</label>
<label><input type="checkbox" name="feeling" value="スポーツ観戦のときに">スポーツ観戦のときに</label>
<label><input type="checkbox" name="feeling" value="食事を楽しみたいとき" >食事を楽しみたいとき</label>
<label><input type="checkbox" name="feeling" value="暑い日に">暑い日に</label>
<label><input type="checkbox" name="feeling" value="特別な日やご褒美">特別な日やご褒美</label>
<label><input type="checkbox" name="feeling" value="その他">その他</label>
</fieldset>

<br>
<fieldset class="checker-2">
<b><font color="#446E72">どんな人と飲みたいか</font></b></fieldset>
<fieldset class="checker-2">
<label><input type="checkbox" name="people" value="家族">家族と</label>
<label><input type="checkbox" name="people" value="恋人・夫婦">恋人や夫婦で</label>
<label><input type="checkbox" name="people" value="友達">友達と</label>
<label><input type="checkbox" name="people" value="ひとり">ひとりで</label>
<label><input type="checkbox" name="people" value="知らない人">知らない人と</label>
</fieldset>
<br>
<br>
<input type="submit" value="検索" class="button-1">
</form>
</div>
</div>
</body>
</html>