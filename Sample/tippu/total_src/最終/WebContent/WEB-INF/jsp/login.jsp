<!-- ログイン画面を出力するビュー -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	<h2>ログイン</h2>
<!-- <h1>ログイン画面</h1> -->
	<form action="/aniMatch/Login" method="post">
<!-- ユーザーID:<input type="text" name="userId"><br> -->
<!-- パスワード:<input type="password" name="pass"><br> -->

	<div>
		<!-- classで「required」を付けた文字の後ろに必須マークが出る -->
		<label for="textBox">ユーザーID</label><br>
		<input type="text" name="userId"  id="textBox">
	</div>
	<div>
		<label for="passwordBox">パスワード</label><br>
		<input type="password" name="pass" id="passwordBox"><br>
	</div>
	</div>
	<div>
		<input type="submit" name="submit" value="ログイン">
	</div>
	</form>
	<div>
		<a href="/aniMatch/AccountRegist"><button>>>新規登録はこちら</button></a>
	</div>
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