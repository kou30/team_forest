<!-- メッセージ入力画面を出力するビュー -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- (EL式＆JSTL版) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="model.AccountInfo" %>
<%@ page import="model.MessageInfo" %>


<%
// セッションスコープからユーザー情報を取得
AccountInfo accountInfoOnSession = (AccountInfo) session.getAttribute("ACCOUNT_INFO");

// セッションスコープから動物の主キー情報を取得
MessageInfo messageInfoOnSession = (MessageInfo) session.getAttribute("ANIMAL_KEY_INFO");

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
<!-- <h1>あにマッチメッセージ入力</h1> -->
	<h2>お問い合わせ</h2>
	<h3>メッセージを送信していただけます。<br>
	ご質問やご不明点等お気軽にお問合せください。</h3>

	<div class="right">
<!-- 日時を表示する -->
<span id="view_clock" ></span>

<script type="text/javascript">
timeID = setInterval('clock()',500); // 0.5秒毎にclock()を実行

function clock() {
	document.getElementById("view_clock").innerHTML = getNow();
}

function getNow() {
	var now = new Date();
	var year = now.getFullYear();
	var mon = now.getMonth()+1; // 1を足すこと
	var day = now.getDate();
	var hour = now.getHours();
	var min = now.getMinutes();
	var sec = now.getSeconds();

	// 出力用
	var s = year + "年" + mon + "月" + day + "日" + hour + "時" + min + "分" + sec + "秒";
	return s;
}
</script>


<p>
<c:out value="${ACCOUNT_INFO.userName}" />さん、ログイン中
</p>

<!-- ログアウト用のリンク -->
<a href="/aniMatch/Logout">ログアウト</a>
</div>
<p>
<c:out value="${ANIMAL_KEY_INFO.animal_key}" />番の動物についてのお問い合わせ
</p>
<!-- メッセージの投稿と閲覧に関する部分 -->
<p><a href="/aniMatch/Message">更新</a></p>

<form action="/aniMatch/Message" method="post">

<div>
<input type="text" name="text">
</div>
<div>
<input type="submit" name="submit" value="送信">
</div>

</form>

<c:if test="${not empty errorMsg}">
	<p>${errorMsg}</p>
</c:if>


<c:forEach var="messageInfo" items="${messageInfoList}">
	<p><c:out value="${messageInfo.name}"/>:
		<c:out value="${messageInfo.text}" /><br>
		<c:out value="${messageInfo.message_time}" /></p>
</c:forEach>
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