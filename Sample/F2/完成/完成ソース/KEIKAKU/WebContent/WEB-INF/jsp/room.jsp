<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="servlet.RoomServlet"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Dela+Gothic+One&family=Shippori+Mincho+B1&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Zen+Kaku+Gothic+New:wght@300&display=swap" rel="stylesheet">
<title>おたすく 部屋作成画面</title>
</head>
<body>
<h1>おたすく</h1>
<p>URLでみんなとタスクを共有しよう！</p>
<div>URL:</div><c:out value="${URL}" />
<form action="${URL}" method="get">
<div>
<button type="button" onclick="location.href='${URL}'"class="btn_orange">次へ</button>
</div>
</form>
</body>
</html>
