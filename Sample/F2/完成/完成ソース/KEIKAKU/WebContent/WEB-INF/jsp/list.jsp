<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="servlet.LoginServlet"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Dela+Gothic+One&family=Shippori+Mincho+B1&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Zen+Kaku+Gothic+New:wght@300&display=swap" rel="stylesheet">
<title>タスク管理</title>
</head>
<body>
<h1>おたすく</h1>
<div><span class="kakomi-box2">STEP2</span> 共有したいタスクを１つずつ入力して追加ボタンを押してね</div>
<p>例えば....買い物 を入力する→タスクを追加<br>
  犬の散歩 を入力する→タスクを追加<br></p>
<form action="/KEIKAKU/RoomServlet" method="post">

<div>
        <input type="text" placeholder="タスク入力" name = "task">
</div>
    <input type="submit" value="タスクを追加" class="btn_orange  ">
</form>
<span class="under">↓追加したタスク一覧</span>
<c:forEach var="Task" items="${TaskList}">
　 <div><c:out value="${Task.task}" /></div>
</c:forEach>
<p>タスクの追加が終わったら次のSTEP3に進んでね</p>
<form action="/KEIKAKU/TaskDeleteServlet"method="get">
<div>
<input type="submit" value="入力タスクをリセットする"class="btn_orange ">
</div>
</form>
<div><span class="kakomi-box2">STEP3</span> タスクが決まったら完成を押してね！</div>
<p>(注)完成を押すと追加できません
<form action="/KEIKAKU/RoomServlet" method="get">
<div>
<input type="submit" value="完成"class="btn_orange ">
</div>
</form>

</body>
</html>