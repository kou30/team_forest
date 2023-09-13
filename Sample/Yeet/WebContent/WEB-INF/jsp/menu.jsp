<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="model.UserInfoDto"  %>
<%
// セッションスコープからユーザー情報を取得
UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yeetメニュー</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css">
</head>
<body>
<div style="text-align: center">
<h1>ゲームメニュー</h1>
<h2 id="sub">ようこそ<%= userInfoOnSession.getUserName() %>さん</h2>

<img src="${pageContext.request.contextPath}/pic/mainquiz.jpg" alt="クイズイラスト" width="500" >
<p>
<c:out value="${LOGIN_INFO.userName}" />さんログイン中。ログアウトするなら<a href="/Yeet/Logout">こちら</a>
</p>
<p>
好きなゲームを選んでね<br><a href="/Yeet/MainQuiz">クイズ</a>または
<a href="/Yeet/HighAndLow">HighAndLow</a>
</p>
</div>
</body>
</html>