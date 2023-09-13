<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserInfoDto"  %>
<%
//セッションスコープからユーザー情報を取得
UserInfoDto userInfoOnSession=(UserInfoDto)session.getAttribute("LOGIN_INFO");
%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css">
<meta charset="UTF-8">
<title>Yeetゲーム</title>
</head>
<body>
<div style="text-align: center">
<h1>さあ！ゲームをしよう</h1>
<% if(userInfoOnSession !=null) { %>

<h2 id="sub">ようこそ<%= userInfoOnSession.getUserName() %>さん</h2>

 <img src="${pageContext.request.contextPath}/pic/login_ok.jpg" alt="ログインイラスト" width="500" >

 <p>好きなゲームを<a href="/Yeet/Menu">メニュー</a>から選んでね</p>
 <% } else { %>


 <h2>ログインに失敗しました</h2>
  <img src="${pageContext.request.contextPath}/pic/loginFailure.jpg" alt="ログイン失敗イラスト" width="650" >
  <br>
 <a href="/Yeet/">TOPへ</a>
 <% } %>
 </div>
</body>

</html>