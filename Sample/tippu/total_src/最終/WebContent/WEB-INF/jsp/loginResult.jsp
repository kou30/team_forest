<!-- ログイン結果画面を出力するビュー -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- (EL式＆JSTL版) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="model.AccountInfo" %>

<%
// セッションスコープからユーザー情報を取得
AccountInfo accountInfoOnSession = (AccountInfo) session.getAttribute("ACCOUNT_INFO");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>あにマッチ</title>
<link rel = "stylesheet" href = "css/style.css">

</head>
<body>
<div class="wrapper">
	<!-- ヘッダー -->
	<header class="header">
		<h1 class="logo">
			<img src="img/logo.png" alt="">
		</h1>
	</header>
	<!-- ヘッダーここまで -->
	<!-- メイン -->
	<main>
<!-- <h1>あにマッチログイン結果</h1> -->
<% if(accountInfoOnSession != null) { %>
	<p>ログインに成功しました</p>

	<p>ようこそ
	<%= accountInfoOnSession.getUserName() %>さん</p>

	<a href="/aniMatch/Message">メッセージ入力</a>
<% } else { %>
	<p>ログインに失敗しました</p>
	<a href="/aniMatch/Login">戻る</a>
<% } %>
	</main>
	<!-- メインここまで -->
	<!-- フッター -->
	<footer class="footer">
		<p>&copy;Copyright aniMach. All rights reserved.</p>
	</footer>
	<!-- フッターここまで -->
</div>
</body>
</html>