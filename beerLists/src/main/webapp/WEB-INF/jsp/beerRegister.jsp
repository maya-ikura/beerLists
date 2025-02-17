<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飲んだビールリスト【ビール登録画面】</title>
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
<h2 class="heading-4">ビール登録</h2>


<!-- エラーメッセージがある場合は表示 -->
<c:if test="${not empty errorMsg}">
<p style="color:red"><c:out value="${errorMsg}" /></p>
</c:if>

<br>
<!-- ビール登録フォーム -->
<form action="beerRegister" method="post" enctype="multipart/form-data">

<div class="cp_iptxt">
  <label class="ef">
  <input type="text" name="beerName" placeholder="ビール名" required="required">
    </label>
</div>

<br>


<div class="cp_iptxt">
  <label class="ef">
<input type="text" name="store" placeholder="会社名（●●ブルワリーなど）">
  </label>
</div>

<br>

<div class="input-checkbox-wrapper">
<div class="cp_iptxt2">
  <label class="ef">
<input type="text" name="price" placeholder="ビールの値段（数字入力）">
  </label>
</div>
<div class="cp_ipcheck01">
<input type="checkbox" name="favorite" value="true" id="favorite-checkbox"><label for="favorite-checkbox">お気に入り</label>
</div>
</div>

<div class="input-checkbox-wrapper">
<p font-size: 15px; /* フォントサイズの指定 */>ビール画像：<input type="file" name="beerImage" id="beerImage" accept=".jpg,.jpeg,.png,.heic"></p>
</div>

<div class="cp_ipselect01">
 <select name="storeKinds">
        <option value="">購入方法	</option>
        <option value="缶">缶</option>
        <option value="瓶">瓶</option>
        <option value="店内飲酒">店内飲酒</option>
        </select>
</div>


<div class="cp_ipselect01">
 <select name="beerKinds">
        <option value="">ビールの種類</option>
        <option value="ピルスナー">ピルスナー</option>
        <option value="シュヴァルツ">シュヴァルツ</option>
        <option value="ヴァイツェン">ヴァイツェン</option>
        <option value="ベルシャン・ホワイト">ベルシャン・ホワイト</option>
        <option value="アンバーエール">アンバーエール</option>
        <option value="ブラウンエール">ブラウンエール</option>
        <option value="セゾン">セゾン</option>
        <option value="ペールエール">ペールエール</option>
        <option value="IPA">IPA</option>
        <option value="ポーター・スタウト">ポーター・スタウト</option>
        <option value="ランビック">ランビック</option>
        <option value="その他">その他</option>
    </select>
    </div>
 
<div class="cp_ipselect01">
    <select name="feeling">
        <option value="">どんな時に飲む？</option>
        <option value="仕事終わり">仕事終わり</option>
        <option value="ストレス解消したいとき">ストレス解消したいとき</option>
        <option value="リラックスしたいとき">リラックスしたいとき</option>
        <option value="スポーツ観戦のときに">スポーツ観戦のときに</option>
        <option value="暑い日に">暑い日に</option>
        <option value="食事を楽しみたいとき">食事を楽しみたいとき</option>
        <option value="特別な日やご褒美">特別な日やご褒美</option>
        <option value="その他">その他</option>
    </select>
    </div>
    
    
<div class="cp_ipselect01">
    <select name="people">
        <option value="">どんな人と飲みたい？</option>
        <option value="家族">家族</option>
        <option value="恋人・夫婦">恋人・夫婦</option>
        <option value="友達">友達</option>
        <option value="ひとり">ひとり</option>
        <option value="知らない人">知らない人</option>
        <option value="特になし">特になし</option>
      </select>
    </div>
        
<textarea name="memo" class="textbox-1" rows="4" placeholder="メモ（200文字以内）"></textarea>

<p><input type="submit"  class="button-1" value="新規登録"></p>
</form>


</div>
</div>


</body>
</html>