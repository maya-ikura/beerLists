
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String currentPage = request.getRequestURI();
%>
<div class="top-image-area">
    <img src="img/titleLogo.png">
</div>

    <!-- このエリアはブラウザの高さの20% -->
<header class="cloud-header">
    <div class="header-inner">
        <ul>
            <li><a href="top" class="<%= currentPage.contains("top") ? "active" : "" %>">ビール一覧</a></li>
            <li><a href="beerRegister" class="<%= currentPage.contains("beerRegister") ? "active" : "" %>">ビール登録</a></li>
            <li><a href="beerSearch" class="<%= currentPage.contains("beerSearch") ? "active" : "" %>">ビール検索</a></li>
            <li><a href="beerFortune" class="<%= currentPage.contains("beerFortune") ? "active" : "" %>">今日のビール</a></li>
            <li><a href="logout" class="<%= currentPage.contains("logout") ? "active" : "" %>">ログアウト</a></li>
        </ul>
    </div>
</header>



	
