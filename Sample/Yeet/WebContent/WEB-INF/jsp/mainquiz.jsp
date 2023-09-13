<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.UserInfoDto, model.Quiz, java.util.List" %>
<%
//セッションスコープに保存されたユーザー情報を取得
UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");
//アプリケーションスコープに保存されたつぶやきリストを取得
List<Quiz> quizList =
    (List<Quiz>) application.getAttribute("quizList");
%>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css">

<meta charset="UTF-8">
<title>Yeetクイズ</title>
</head>
<body>
<div style="text-align: center">
<h1>和歌山難読地名クイズ</h1>

<!-- JSTL -->
<h2><c:out value="${ LOGIN_INFO.userName }" />さん、ようこそ！</h2>
<h3>下記の和歌山の地名を読んでみよう！</h3>

<!-- JSTL -->
<% int i = 0; %>
<form action="/Yeet/MainQuiz" method="post">
    <c:forEach var="quiz" begin="0" end="5" items="${quizList}">
 <div class="box">
        <% i++; %>
  <table>
 	<tr>
       <input type="hidden" name="ans<%= i %>" value="${quiz.answer}"/>
       <input type="hidden" name="aitem<%= i %>" value="${quiz.aitem}"/>
		    <th><c:out value="${quiz.problem} ···"/></th>
			<td> <input type="radio" name="check<%= i %>" value="A" />
				   <c:out value="${quiz.ans_a}"/></td>
		    <td><input type="radio" name="check<%= i %>" value="B" />
		  			<c:out value="${quiz.ans_b}"/></td>
		    <td><input type="radio" name="check<%= i %>" value="C" />
		   			<c:out value="${quiz.ans_c}"/></td>
	</tr>
  </table>
  </div>
    </c:forEach>
    <br>
    <input type="submit" value="回答する">
</form>


</div>
</body>
</html>