<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>
<%
// セッションスコープからユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>にゃんチャンス</title>
	<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
	<div class="wrapper">
		<!-- ヘッダー -->
		<div align="left" class="example-r">
		<h1>新規登録</h1>
		</div>
		<header class="header">
			<nav class="nav">
				<ul>
				</ul>
			</nav>
		</header>
		<!-- ヘッダー ここまで -->
		<!-- メイン -->

		<form action="/nyanChance/Signup" method="post">

			<p>ユーザー名:<input type="text" maxlength="20"pattern="^[a-zA-Z0-9ぁ-んァ-ヶｱ-ﾝﾞﾟ一-龠]*$" name="name"></p>
			<p>名前を２０文字以内(記号は含まない)で入力してください。</p>

			<p>パスワード:<input type="password" maxlength="10"pattern="^[a-zA-Z0-9]*$" name="pass"></p>
			<p>パスワードを１０文字以内(半角英数字)で入力してください。</p>
			<p>tel&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input type="tel" maxlength="12" pattern="^[0-9]*$" name="tell"></p>
			<p>電話番号をハイフンなし１２文字以内(半角数字)で入力してください。</p>
			<button type="submit">登録</button>

		</form>
		<button onclick="location.href='/nyanChance/Login'">戻る</button>
		<div class="keyvisual">
			<img src="images/cat1.jpg" alt="TAG index" width="400px" border="1px" >
		</div>
		<main>
		</main>
		<!-- メイン ここまで -->
		<!-- フッタ -->
		<footer class="footer">
			<p>&copy;Copyright Nyan Chance. All rights reserved.</p>
		</footer>
		<!-- フッタ ここまで -->
	</div>
<%
if(request.getAttribute("errorMsg")!=null) {
	String error_msg = (String)request.getAttribute("errorMsg");
%>
<script type="text/javascript">
var msg = "<%=error_msg %>";
alert(msg);
</script>
<%}%>
</body>
</html>