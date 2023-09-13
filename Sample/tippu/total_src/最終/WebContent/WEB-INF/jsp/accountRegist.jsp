<!-- ユーザー登録画面を出力するビュー -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- (EL式＆JSTL版) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<h2>会員登録</h2>
	<h3>以下の項目にご記入の上、「確認」ボタンを押してください。</h3>
<!-- <h1>ユーザー登録</h1> -->

<form action="/aniMatch/AccountRegist" method="post">

<div>
		<!-- classで「required」を付けた文字の後ろに必須マークが出る -->
		<label class="required" for="textBox">名前</label><br>
<input type="text" name="userName"placeholder="名前" id="textBox"><br>

<!-- ユーザーID:<input type="text" name="userId"><br> -->
<!-- パスワード:<input type="password" name="pass">※半角英数4文字<br> -->
	</div>
	<div>
		<label class="required" for="textBox">ユーザーID</label><br>
		<input type="text" name="userId" placeholder="ユーザーID" id="textBox"><br>
	</div>
	<div>
		<label class="required" for="passwordBox">パスワード</label><br>
		<input type="password" name="pass"placeholder="パスワード(半角英数4文字)" id="passwordBox"><br>
<br>
	</div>
	<div>
		<input type="submit" name="regist" value="登録" >
	</div>
</form>
<br><br>
<c:if test="${not empty errorMsg}">
	<p>${errorMsg}</p>
</c:if>
<c:if test="${not empty errorMsgPass}">
	<p>${errorMsgPass}</p>
</c:if>

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
