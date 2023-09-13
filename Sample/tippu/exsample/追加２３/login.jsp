<!-- ログイン画面を出力するビュー -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>あにマッチ</title>
</head>
<body>
<h1>ログイン画面</h1>

<form action="/aniMatch/Login" method="post">
<!-- ユーザー名:<input type="text" name="name"><br> -->
ユーザーID:<input type="text" name="userId"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="ログイン">

</form>
<a href="/TT/accountRegist.jsp"><button>新規登録</button></a>
</body>
</html>