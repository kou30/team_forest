<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- (EL式＆JSTL版) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="model.AccountInfo" %>

<%
// セッションスコープからユーザー情報を取得
AccountInfo accountInfoOnSession = (AccountInfo) session.getAttribute("ACCOUNT_INFO");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>あにマッチ</title>
<link rel = "stylesheet" href = "css/style.css">

</head>
<body>
<div style="text-align:center;">
<P>
<c:out value="${ACCOUNT_INFO.userName}" />さん、
</P>
<p>
ログアウトしますか？
</p>
<form action="/aniMatch/Logout"method="get">
<input type="submit" name="yesno" value="Yes">&nbsp;
<input type="submit" name="yesno" value="No">
</form>
</div>
</body>
</html>