<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="model.Cat" %>
<%@ page import="model.Reserve,java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar,java.util.Date" %>

<%
Date now = new Date();
Calendar calendar = Calendar.getInstance();

%>

<%
// セッションスコープからユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
List<Reserve> reserveList = (List<Reserve>) request.getAttribute("reserveList");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>にゃんチャンス</title>
	<link rel="stylesheet" href="CSS/status.css">
</head>
<body class="reservationStatus">
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
			<h2>予約状況</h2>
			<!-- #####################
			### ここにコードを書く ###
			#######################-->
			<%for(Reserve reserve:reserveList){ %>
				<div class="menu-block">
					<div class="menu-item">
						<div class="menu-photo">
							<a><img src="images/cat_img_<%=reserve.getCatId() %>.jpg" alt="TAG index" width="400px" border="1px">
							</a>
						</div>

						<div class="menu-text">


			<%String date = new SimpleDateFormat("yyyy年MM月dd日").format(reserve.getDate());%>
			<%String birthday = new SimpleDateFormat("yyyy年MM月dd日").format(reserve.getBirthday());%>

			<h3>Cat&nbsp;NO. <%=reserve.getCatId() %></h3>
			<p class="text">猫の名前:&nbsp;<%=reserve.getCatName() %></p>
			<%
			calendar.setTime(reserve.getBirthday());
			int catYear = calendar.get(Calendar.YEAR);
			int catMonth = calendar.get(Calendar.MONTH);
			int catDay = calendar.get(Calendar.DAY_OF_MONTH);
			calendar.setTime(now);
			int nowYear = calendar.get(Calendar.YEAR);
			int nowMonth = calendar.get(Calendar.MONTH);
			int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
			int year = nowYear - catYear;
			int month = 0;
			int day = 0;
			if(nowMonth < catMonth){
				month = 12 + nowMonth - catMonth;
				year--;
				}else{
					month = nowMonth - catMonth;
				}
			if(nowDay < catDay){
				day = 12 + nowDay - catDay;
				month--;
				}else{
					day = nowDay - catDay;
				}
			%>
			<p class="text">誕生日:&nbsp;<%=birthday %></p>

			<p class="text">生後:&nbsp;<%if(year > 0){%><%=year %>年<%}%><%=month %>ヵ月</p>

			<p class="text">sex:&nbsp;<%=reserve.getSex() %></p>
			<p class="text">猫種:&nbsp;<%=reserve.getCatKind() %></p>
			<p class="text">対面予約日:&nbsp;<%=date %></p>
			<p class="text">予約時コメント</p>
			<p><%=reserve.getComment() %></p>

	        <form
	            action="/nyanChance/ReservationStatus?action=done"
	            method="POST"
	        >
	        	<input type="hidden" name="reserveId" value="<%=reserve.getId() %>">
	            <input type="submit" value="　削　除　">
	        </form>

						</div>
					</div>
				</div>
			<%} %>
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