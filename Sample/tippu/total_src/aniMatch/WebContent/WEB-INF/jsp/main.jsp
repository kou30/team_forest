<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%//@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="model.AnimalInfo,java.util.List" %>

<%
//セッションスコープに保存されたユーザー情報を取得
List<AnimalInfo>animalList = (List<AnimalInfo>)request.getAttribute("animalList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>あにマッチ</title>
<link rel = "stylesheet" href = "css/style.css">

</head>
<body>
<h1>あにマッチメイン</h1>
<form action="/aniMatch/Search" method="get">
<input type="submit" name="defolt" value="検索">
</form>
<h2>どうぶつの紹介</h2>

	<div class = "animal-block" >

<% for(AnimalInfo list : animalList){ %>
	<div class = "animal-item">


	<div class = " animal-photo">
	<img style="width: 150px; height: 150px" src="Imgdsp?ID=<%= list.getAnimalKey() %>" >
	</div>

	<div class = "animal-text" style="text-align: center">
	<h3><%= list.getAnimalKey() %>番</h3>
	<p>性別：<%= list.getSex() %></p>
	<p>年齢：<%= list.getAge() %></p>
	<p>現在地：<%= list.getPlace() %></p>

<!-- 変数numberに動物の主キーを代入してdoGetに渡す -->
<button onclick="location.href='/aniMatch/Login?number=<%= list.getAnimalKey() %>'">メッセージ</button>
	</div>

	</div>
<% } %>
	</div>
</body>
</html>