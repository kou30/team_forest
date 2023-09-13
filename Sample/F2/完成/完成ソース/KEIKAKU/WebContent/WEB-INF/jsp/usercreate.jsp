<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User"%>
<%
//セッションスコープからユーザー情報を取得
User user=(User) session.getAttribute("loginUser");
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
<div><span class="kakomi-box2">STEP3</span> ユーザー情報を登録しよう！</div>
 <form action="/KEIKAKU/UserList" method="post">
 <br> 名前:<input type="text" name="name" >
 <br>
       色:<select name="color"id="colorselect">
       <option value="">タスクが完了した時に塗りたい色は？</option>
  <option value="red">赤</option>
  <option value="blue">青</option>
  <option value="yellow">黄</option>
  <option value="green">緑</option>
</select>
 <c:out value="${user.roomid}"/>
 <input type="hidden" name="roomid" value=<%=user.getRoomid()%> >
<br> <input type="submit" value="完成！タスクを確認しよう！"class="btn_orange">
    </form>
<c:forEach var="user" items="${userList}">
<p><c:out value="${user.name }"/>
<c:out value="${user.color}"/></p>
</c:forEach>

</body>
</html>