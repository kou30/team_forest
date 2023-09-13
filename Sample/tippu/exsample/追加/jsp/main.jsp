<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%//@ page import="model.User,model.Mutter,java.util.List" %>

<%//@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.AnimalInfo,java.util.List" %>
<%
//セッションスコープに保存されたユーザー情報を取得
//User loginUser = (User)session.getAttribute("loginUser");
List<AnimalInfo>animalList = (List<AnimalInfo>)request.getAttribute("animalList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>あにマッチ</title>
</head>
<body>
<div style="text-align: center">
<h1>あにマッチメイン</h1>
<% for(AnimalInfo list : animalList){ %>
	<p>番号：<%= list.getAnimalKey() %>
	性別：<%= list.getSex() %>
	年齢：<%= list.getAge() %>
	現在地：<%= list.getPlace() %>
	<img style="width: 100px; height: 100px" src="Imgdsp?ID=<%= list.getAnimalKey() %>">
	<br>
<button onclick="location.href='/aniMatch/Login'">メッセージ</button>
<% } %>

</div>
</body>
</html>