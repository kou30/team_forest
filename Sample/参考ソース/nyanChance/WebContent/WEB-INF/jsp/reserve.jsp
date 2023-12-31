<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User,model.Reserve" %>
<%@ page import="java.util.List,java.sql.Date"%>
<%
// セッションスコープからユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
//リクエストスコープから予約情報を取得
List<Reserve> reserveList=(List<Reserve>) request.getAttribute("reserveList");
//リクエストスコープから猫idを取得
int catId=(int)request.getAttribute("catId");
%>
<!DOCTYPE html>
<html>
	<!-- カレンダーインポート -->
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js">
    </script>
    <!-- インポート終わり -->
    <script>
    	//カレンダー関数
		$(function() {
	      	var dateFormater="yy-mm-dd";
	      	var reservedDayList=[];
			<%for(Reserve reserve:reserveList){%>
				reservedDayList.push("<%=reserve.getDate().toString()%>"); //""を外すとハイフンのせいで引き算が始まるので注意
	    	<%}%>
	    	//minDate:0で過去の日付を入力できなくする
	    	//beforeShowDayでカレンダーの日付を押す前にしてほしいことを書いている
	    	//今回ならすでに予約されている日付は押せないようにしている
	    	$( "#datepicker" ).datepicker({minDate:0,
	     		beforeShowDay : function(date) {
	            	var current = $.datepicker.formatDate(dateFormater, date);
	                return [( reservedDayList.indexOf(current) == -1 ), "", ""];
	     		}
     		});
     	});
	 	//サブミット（予約ボタン）を押すとcheck関数が動く
     	function check() {
		    if (document.reserve.date.value == "") {
		     	alert("日付を入力してください");
		        return false;
		    }
		    if(document.reserve.comment.value.length>200){
		    	alert("文字が多すぎます");
		        return false;
		    }
		    //はいを押すとtrueが返り、submitする
			return window.confirm(document.reserve.date.value+'でよろしいですか？');
		    }
	</script>
<head>
	<meta charset="UTF-8">
	<title>にゃんチャンス</title>
	<link rel="stylesheet" href="CSS/style.css"/>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"/>
</head>
<body class="reserve">
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

			<div class="menu-block1">
			<h2>予約</h2>
				<h3>Cat no<%= catId %></h3>
				<img src="images/cat_img_<%= catId %>.jpg" alt="Cat no<%= catId %>>" width="400px" border="1px" >
		        <!-- onSubmitは予約ボタンを押したときに行う関数 -->
		        <!-- accept-charsetでコメントの文字コード変換 -->
		        <form
		        	name="reserve"
		            action="/nyanChance/Reserve"
		            method="post"
		           	onSubmit="return check()"
		            accept-charset="UTF-8"
		        >
		            日付<br />
		            <input type="text" id="datepicker" name="date" readonly="readonly"/><br />
		            <br />
		            コメント<br>
		            <textarea id="comment" name="comment" rows="5" cols="33"></textarea>
					<br>
					<input type="hidden" name="catId" value="<%= catId %>">
		            <input type="submit" value="　予　約　" />
		        </form>
			</div>

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