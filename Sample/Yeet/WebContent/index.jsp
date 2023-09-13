<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css">

<meta charset="UTF-8">
<title>Yeetゲーム</title>
</head>
<body>
<div style="text-align: center">
<h1>みんなでゲームをやろう!!</h1>
<h2>君は何点獲得できるかな？</h2>
<img src="${pageContext.request.contextPath}/pic/humans.jpg" alt="topイラスト" width="600px" >
<form action="/Yeet/ExecuteLogin" method="post">
<div>
<label for="text">ユーザー名</label>
<input type="text" name="userName" placeholder="ユーザー名を入力"  required ><br>
<label for="text">パスワード</label>
<input type="password" name="passWord" placeholder="パスワードを入力" required ><br>
<input type="submit" value="ログイン">
<p>新規登録の方は<a href="/Yeet/accountForm.jsp">こちらへ</a></p>
<br>
</div>
</form>
</div>
</body>
</html>