<!-- ユーザー登録画面を出力するビュー -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- (EL式＆JSTL版) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>あにマッチ</title>
<link rel = "stylesheet" href = "css/style.css">

</head>
<body>
<h1>ユーザー登録</h1>

<form action="/aniMatch/AccountRegist" method="post">

名前:<input type="text" name="userName"><br>
ユーザーID:<input type="text" name="userId"><br>
パスワード:<input type="password" name="pass">※半角英数4文字<br>
<br>



<input type="submit" name="regist" value="登録" >
</form>
<br><br>
<c:if test="${not empty errorMsg}">
	<p>${errorMsg}</p>
</c:if>
<c:if test="${not empty errorMsgPass}">
	<p>${errorMsgPass}</p>
</c:if>

</body>
</html>
