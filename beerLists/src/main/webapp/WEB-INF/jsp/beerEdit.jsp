<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飲んだビールリスト【編集画面】</title>
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
<h2 class="heading-4">ビール編集</h2>
<br>
<!-- ビール編集画面　前回のデータも表示するようにしておく -->
<p>現在の画像：</p>
<p><img src="img/${beerEdit.beerImage}" alt="画像なし" style="max-width: 300px; max-height: 300px;"></p>
<!-- メッセージがある場合は表示 -->
<c:if test="${not empty Msg}">
<p style="color:red"><c:out value="${errorMsg}" /></p>
</c:if>
<br>
<div class="img-wrapper">
<!-- 画像削除フォーム -->
<form action="imageDelete" method="post" enctype="multipart/form-data">
<input type="hidden" name="beerImage" value="${beerEdit.beerImage}">
<input type="hidden" name="beerId" value="${beerEdit.id}">
<input type="submit" value="削除"></form>
<!-- 編集フォーム -->
<form action="beerEdit" method="post" enctype="multipart/form-data">
<input type="hidden" name="beerId" value="${beerEdit.id}">
<input type="hidden" name="oldBeerImage" value="${beerEdit.beerImage}">
<input type="file" name="beerImage" accept=".jpg,.jpeg,.png,.heic">
</div>
<br>
<div class="cp_iptxt">
  <label class="ef">
  <input type="text" name="beerName" placeholder="ビール名"  value="${beerEdit.beerName}" required="required">
    </label>
</div>
<br>


<div class="cp_iptxt">
  <label class="ef">
<input type="text" name="store" placeholder="会社名（●●ブルワリーなど）" value="${beerEdit.store}" required="required">
  </label>
</div>

<br>

<div class="input-checkbox-wrapper">
<div class="cp_iptxt2">
  <label class="ef">
<input type="text" name="price" placeholder="ビールの値段（数字入力）" value="${beerEdit.price}">
  </label>
</div>
<div class="cp_ipcheck01">
<input type="checkbox" name="favorite" value="true" ${beerEdit.favorite == true ? 'checked' : ''}" id="favorite-checkbox"><label for="favorite-checkbox">お気に入り</label>
</div>
</div>

<div class="cp_ipselect01">
 <select name="storeKinds">
        <option value="" ${beerEdit.storeKinds == "" ? "selected" : ""}>購入方法</option>
        <option value="缶" ${beerEdit.storeKinds == "缶" ? "selected" : ""}>缶</option>
        <option value="瓶" ${beerEdit.storeKinds == "瓶" ? "selected" : ""}>瓶</option>
        <option value="店内飲酒" ${beerEdit.storeKinds == "店内飲酒" ? "selected" : ""}>店内飲酒</option>
        </select>
</div>


<div class="cp_ipselect01">
    <select name="beerKinds">
        <option value="" ${beerEdit.beerKinds == "" ? "selected" : ""}>ビールの種類</option>
        <option value="ピルスナー" ${beerEdit.beerKinds == "ピルスナー" ? "selected" : ""}>ピルスナー</option>
        <option value="シュヴァルツ" ${beerEdit.beerKinds == "シュヴァルツ" ? "selected" : ""}>シュヴァルツ</option>
        <option value="ヴァイツェン" ${beerEdit.beerKinds == "ヴァイツェン" ? "selected" : ""}>ヴァイツェン</option>
        <option value="ベルシャン・ホワイト" ${beerEdit.beerKinds == "ベルシャン・ホワイト" ? "selected" : ""}>ベルシャン・ホワイト</option>
        <option value="アンバーエール" ${beerEdit.beerKinds == "アンバーエール" ? "selected" : ""}>アンバーエール</option>
        <option value="ブラウンエール" ${beerEdit.beerKinds == "ブラウンエール" ? "selected" : ""}>ブラウンエール</option>
        <option value="セゾン" ${beerEdit.beerKinds == "セゾン" ? "selected" : ""}>セゾン</option>
        <option value="ペールエール" ${beerEdit.beerKinds == "ペールエール" ? "selected" : ""}>ペールエール</option>
        <option value="IPA" ${beerEdit.beerKinds == "IPA" ? "selected" : ""}>IPA</option>
        <option value="ポーター・スタウト" ${beerEdit.beerKinds == "ポーター・スタウト" ? "selected" : ""}>ポーター・スタウト</option>
        <option value="ランビック" ${beerEdit.beerKinds == "ランビック" ? "selected" : ""}>ランビック</option>
        <option value="その他" ${beerEdit.beerKinds == "その他" ? "selected" : ""}>その他</option>
    </select>
</div>

<div class="cp_ipselect01">
    <select name="feeling">
        <option value="" ${beerEdit.feeling == "" ? "selected" : ""}>どんな時に飲みたいか</option>
        <option value="仕事終わり" ${beerEdit.feeling == "仕事終わり" ? "selected" : ""}>仕事終わり</option>
        <option value="ストレス解消したいとき" ${beerEdit.feeling == "ストレス解消したいとき" ? "selected" : ""}>ストレス解消したいとき</option>
        <option value="リラックスしたいとき" ${beerEdit.feeling == "リラックスしたいとき" ? "selected" : ""}>リラックスしたいとき</option>
        <option value="スポーツ観戦のときに" ${beerEdit.feeling == "スポーツ観戦のときに" ? "selected" : ""}>スポーツ観戦のときに</option>
        <option value="暑い日に" ${beerEdit.feeling == "暑い日に" ? "selected" : ""}>暑い日に</option>
        <option value="食事を楽しみたいとき" ${beerEdit.feeling == "食事を楽しみたいとき" ? "selected" : ""}>食事を楽しみたいとき</option>
        <option value="特別な日やご褒美" ${beerEdit.feeling == "特別な日やご褒美" ? "selected" : ""}>特別な日やご褒美</option>
        <option value="その他" ${beerEdit.feeling == "その他" ? "selected" : ""}>その他</option>
    </select>
</div>

<div class="cp_ipselect01">
    <select name="people">
        <option value="" ${beerEdit.people == "" ? "selected" : ""}>どんな人と飲みたいか</option>
        <option value="家族" ${beerEdit.people == "家族" ? "selected" : ""}>家族</option>
        <option value="恋人・夫婦" ${beerEdit.people == "恋人・夫婦" ? "selected" : ""}>恋人・夫婦</option>
        <option value="友達" ${beerEdit.people == "友達" ? "selected" : ""}>友達</option>
        <option value="ひとり" ${beerEdit.people == "ひとり" ? "selected" : ""}>ひとり</option>
        <option value="知らない人" ${beerEdit.people == "知らない人" ? "selected" : ""}>知らない人</option>
        <option value="特になし" ${beerEdit.people == "特になし" ? "selected" : ""}>特になし</option>
    </select>
</div>
     
<textarea name="memo" class="textbox-1" rows="4" placeholder="メモ（200文字以内）">${beerEdit.memo}</textarea>
<br><br>
<div class="input-checkbox-wrapper">
<input type="submit" value="編集完了" class="button-1">
</form>
<a href="beerDetail?id=${beerEdit.id}" class="button-1">詳細へ戻る</a>
</div></div>
</div>
</body>
</html>