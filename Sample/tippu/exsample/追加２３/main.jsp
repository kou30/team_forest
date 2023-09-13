<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%//@ page import="model.User,model.Mutter,java.util.List" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="servlet.Search,model.AnimalInfo,java.util.List,java.util.ArrayList" %>
<%
//セッションスコープに保存されたユーザー情報を取得
//AnimalInfo searchList = (AnimalInfo)session.getAttribute("searchList");
// ifkey = session.getAttribute()
List<AnimalInfo>animalList = (List<AnimalInfo>)request.getAttribute("animalList");
// ArrayList<AnimalInfo>animalList1 = (ArrayList<AnimalInfo>)request.getAttribute("searchList");

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

<button onclick="location.href='Search'">検索</button>
<p> 0 </p>
<c:forEach var="AnimalInfo" items="${animalList}" >
<p> 1 </p>
	<p>番号：<c:out value="${AnimalInfo.animalKey}" />
	<p>性別：${ AnimalInfo.sex }
	<p>年齢：${ AnimalInfo.age }
	<p>現在地：${ AnimalInfo.place }
 </c:forEach>
<%-- 	<% for(AnimalInfo list : animalList){ %> --%>
<%-- 	<p>番号：<%= list.getAnimalKey() %> --%>
<%-- 	性別：<%= list.getSex() %> --%>
<%--  	年齢：<%= list.getAge() %> --%>
<%-- 	現在地：<%= list.getPlace() %> --%>
<!-- 	<br> -->

 <!-- 変数numberに動物の主キーを代入してdoGetに渡す -->

<%--  	<% } %> --%>
</div>
</body>
</html>