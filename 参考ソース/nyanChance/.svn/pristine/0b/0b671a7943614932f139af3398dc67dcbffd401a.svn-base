<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="model.Cat" %>
<%@ page import="java.util.List,java.text.SimpleDateFormat" %>



<%
//リクエストスコープから猫情報を取得
List<Cat> catList=
	(List<Cat>) request.getAttribute("catList");

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
<body class=achievement>
	<div class="wrapper">
		<!-- ヘッダー -->
		<div align="right" class="example-r">
<% if(loginUser == null) { %>
    			<br><button onclick="location.href='/nyanChance/Login'">ログイン</button><br>
<% } else { %><br><div <% if (loginUser.getSuperUser() == true){%>class='superUser'<%}else{%>class='user'<% } %>>
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
		<main>
			<h2>実績</h2>
			<!-- #####################
			### ここにコードを書く ###
			#######################-->
			<!--  仮：テスト -->
			<br><br>

<% for(Cat cat:catList){ %>
			<div class="menu-block2">
               <div class="menu-item">
                    <div class="menu-photo">
                    	<img src="images/cat_img_<%= cat.getId() %>.jpg" alt="TAG index" width="400px" border="1px" >
                    </div>
                    <div class="menu-text">
                    	<h3>Cat&nbsp;NO. <%= cat.getId() %></h3>
                        <p>猫の名前:&nbsp;<%=cat.getName() %></p>
                        <% String date = new SimpleDateFormat("yyyy年MM月dd日").format(cat.getBirthday()); %>
                        <p>誕生日:&nbsp;<%=date  %></p>
                        <% int year = Integer.parseInt(cat.getAge()) / 12;%>
                        <% int month = Integer.parseInt(cat.getAge()) % 12;%>
                        <p>生後:&nbsp;<%if(year != 0){%><%=year %>年<%}%><%=month %>ヵ月</p>
						<p>sex:&nbsp;<%= cat.getSex() %></p>
						<p>猫種:&nbsp;<%= cat.getCatKind() %></p>
						<p>コメント</p>
						<p><%= cat.getComment() %></p>
<% if(loginUser != null) { %>
<% if(loginUser.getSuperUser() != false){%>
					<div>
						<form class="buttonB" action="/nyanChance/CatList" method="post">
							<input type="hidden" name="id" value=<%= cat.getId() %>>
							<input type="hidden" name="action1" value="1" >
							<button type="submit">里親Cancel</button>
						</form>
					</div>
<%}%><%}%>
                    </div>
               </div>
<%} %>
           </div>
			<!-- ----------- -->
		</main>
		<!-- メイン ここまで -->
		<!-- フッタ -->
		<footer class="footer">
			<p>&copy;Copyright Nyan Chance. All rights reserved.</p>
		</footer>
		<!-- フッタ ここまで -->
	</div>
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