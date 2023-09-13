<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Dela+Gothic+One&family=Shippori+Mincho+B1&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Zen+Kaku+Gothic+New:wght@300&display=swap" rel="stylesheet">
<title>おたすく</title>
</head>
<body>
<header>
<h1>おたすく</h1>
</header>
<p>おたすくで友達や家族とタスクを共有しよう！</p>
<img class="image-top" src="${pageContext.request.contextPath}/pic//people.png">
<br>
<div><span class="kakomi-box2">STEP1</span> 部屋を作成しよう！</div>
<form action="/KEIKAKU/LoginServlet" method="post">
<div>
<input type="text" name="pass" placeholder="半角英字・数字"pattern="^[a-zA-Z0-9]+$"><br>
<input type="submit" value="タスクを入れよう！"class="btn_orange">
</div>
</form>

</body>
</html>