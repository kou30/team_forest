<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="model.User,model.Task,java.util.List" %>

    <%
//セッションスコープに保存されたタスク情報を取得

@SuppressWarnings("unchecked")
List<Task> taskList=(List<Task>)session.getAttribute("taskList");
    %>
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
<h1>おたすく</h1>
<p>
<span class="under"><c:out value="${loginUser.name}"/>さんのタスク一覧</span>
<div>完了タスクをクリックしよう！</div>
<br>
 <form action="/KEIKAKU/TaskList" method="post">
 <%for(Task task: taskList){ %>
 <%if( task.getStatus().equals("0")){ %>
<input type="submit" value="<%= task.getTaskname() %>"name="taskname" class="status0">
<%}else{ %>
<input type="submit" value="<%= task.getTaskname() %>" name="taskname" class="box<%=task.getColor() %>">
<% } %>
<% } %>
</form>
</body>
</html>

