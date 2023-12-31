<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body class="index">
	<div class="wrapper">
		<!-- ヘッダー -->
		<div align="right" class="example-r">
<% if(loginUser == null) { %>
    			<br><button onclick="location.href='/nyanChance/Login'">ログイン</button><br>
<% } else { %><br><div  <% if (loginUser.getSuperUser() == true){%>class='superUser'<%}else{%>class='user'<% } %>>
     			<p><%= loginUser.getName() %></p><br>
     			<div class="mask">
                <div class="caption"><br><button onclick="logout()">ログアウト</button></div>
                </div>
     		</div>
<% } %>
		</div>
		<br>
		<header class="header">
			<nav class="nav">
				<ul>
					<li><a href="/nyanChance/Home?action=done">ホーム</a></li>
					<li><a href="/nyanChance/CatList?action=done">ネコ一覧</a></li>
<% if(loginUser != null) { %>
					<li><a href="/nyanChance/ReservationStatus?action=done">予約状況</a></li>
					<li><a href="/nyanChance/Achievement?action=done">実績</a></li>
<% } %>
				</ul>
			</nav>
		</header>
		<!-- ヘッダー ここまで -->
		<!-- メイン -->
		<div class="keyvisual">
			<img src="images/cat1.jpg" alt="">
		</div>
		<main>
			<h2 id="news">News</h2>
				<p class="news-item">保護ネコプロジェクトの一環として開設しているページです。暖かく迎えていただく里親を探しています。</p>
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
		<%} else if(request.getAttribute("msg")!=null) {
		String msg = (String)request.getAttribute("msg");
		%>
		<script type="text/javascript">
		var msg = "<%=msg %>";
		alert(msg);
		</script>
		<%}%>
<% if(loginUser != null) { %>
	<script>
        function logout(){
            var message = "ログアウトしますがよろしいですか？"
            result = confirm(message);
            if(result == true){
                location.href='/nyanChance/Logout'
            }
        }
    </script>
<% } %>
</body>
</html>