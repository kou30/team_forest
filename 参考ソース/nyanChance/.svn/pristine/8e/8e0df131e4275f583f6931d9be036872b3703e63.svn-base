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
	<title>ログイン-にゃんチャンス</title>
	<link rel="stylesheet" href="CSS/style.css">

</head>
<body>
	<div class="wrapper">
		<!-- ヘッダー -->

  		<div align="center" class="example-r">
 		<div class="keyvisual">
<!-- 		<a href="/nyanChance/Home?action=done"> -->
<!--              <img src="images/cat1.jpg" alt="TAG index" width="120px" border="0px" > -->
<!--         </a> -->

		</div>
		<header class="header">
		</header>
		<!-- ヘッダー ここまで -->
		<!-- メイン -->
		<main>
		<div class="frame">

		<form action="/nyanChance/Login" method="post">
		<p class="form-title">ログイン</p>
		<p class="align">ユーザー名
		<input type="text" maxlength="20"pattern="^[a-zA-Z0-9ぁ-んァ-ヶｱ-ﾝﾞﾟ一-龠]*$" name="name"><br>
		</p>
		<p class="align">パスワード
		<input type="password"  maxlength="10"pattern="^[a-zA-Z0-9]*$" name="pass">
		</p><br>
		<p class=submit>
		<button class="submit1" type="submit">ログイン</button>
		</p><br>
		<a href="/nyanChance/Home?action=done">
             <img src="images/cat1.jpg" alt="TAG index" width="170px" border="0px" >
        </a>
        </form>



		<p class="form-title"></p><br>
		<!-- 直前のページに戻る -->
		<p class=submit>
		<button  onclick="location.href='/nyanChance/'">　戻る　</button>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
		<button  onclick="location.href='/nyanChance/Signup'">新規登録</button>
		</p>
		 </div>


		</main>
		<!-- メイン ここまで -->
		<!-- フッタ -->
		<footer class="footer">
			<p>&copy;Copyright Nyan Chance. All rights reserved.</p>
		</footer>
		<!-- フッタ ここまで -->
		</div>
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
</body>
</html>








