<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="servlet.Score, servlet.MainQuiz, dao.QuizScoreDAO" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css">
<meta charset="UTF-8">
<title>Yeetクイズスコア</title>
</head>
<body>
<div style="text-align: center">
<h1>スコア ランキング</h1>
<h2><c:out value="${ LOGIN_INFO.userName }" />さんの得点は</h2>
<p id="ten"><span><c:out value="${MainQuiz.sum}" />点！！</span></p>
 <div class="abox">
 <table>
    <thead>
 	<tr>
 	<th>順位</th><th>ユーザーネーム</th><th>得点</th>
    </tr>
    </thead>

	<c:forEach var="quizscore" items="${quizscoreList}">

       <tr>
         <td><c:out value="${quizscore.rankResult}"/>位</td>

	     <td><c:out value="${quizscore.userName}"/></td>

	     <td><c:out value="${quizscore.score}"/>点</td>
       </tr>

    </c:forEach>

  </table>
  </div>
<p><a href="/Yeet/Menu">メニュー画面へ</a></p>

</div>
</body>
</html>