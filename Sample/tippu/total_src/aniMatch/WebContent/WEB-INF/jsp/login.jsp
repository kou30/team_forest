<!-- ログイン画面を出力するビュー -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>あにマッチ</title>
<link rel = "stylesheet" href = "css/style.css">

</head>
<body>

<h1>ログイン画面</h1>

<form action="/aniMatch/Login" method="post">
<div>
ユーザーID:<input type="text" name="userId"><br>
パスワード:<input type="password" name="pass"><br>
</div>
<div>
<input type="submit" value="ログイン">
</div>


</form>
<div>
<a href="/aniMatch/AccountRegist"><button>新規登録</button></a>
</div>
</body>
</html>