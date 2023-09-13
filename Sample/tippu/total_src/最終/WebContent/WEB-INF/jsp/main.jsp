<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>あにマッチ</title>
<link rel = "stylesheet" href = "css/style.css">

</head>
<body>
	<div class="wrapper">
		<!-- ヘッダー -->
		<header class="header">
			<h1 class="logo">
				<img src="img/logo.png" alt="">
			</h1>
		</header>
		<!-- ヘッダーここまで -->
		<!-- メイン -->
	<!-- <h1>あにマッチメイン</h1> -->
		<main>
			<img src="img/keyvisual.png" alt="" >
			<h2>里親募集</h2>
			<h3>気になる動物のメッセージボタンを押すと、管理者にお問い合わせが可能です。<br>（お問い合わせには会員登録が必要です。）</h3>
			<p>貰い手がなく、保健所に連れて行かれたペットは、たった数日で殺処分となる場合もあります。<br>ペットの購入や飼育を検討されている方は、ぜひ「里親になる」という選択肢もご検討ください。</p>

			<p class="search">
<button onclick="location.href='Search'"><img src="img/search.png" width="80" height="80"></button>
</p>

	<div class="animal-block">

	<c:forEach var="AnimalInfo" items="${animalList}" >
		<div class="animal-item">

			<div class="animal-photo">
				<img src="Imgdsp?ID=${AnimalInfo.animalKey}">
			</div>

			<div class="animal-text">
				<p>募集番号：<c:out value="${AnimalInfo.animalKey}" /></p>
				<p>性別：${ AnimalInfo.sex }</p>
				<p>年齢：${ AnimalInfo.age }</p>
				<p>現在所在地：${ AnimalInfo.place }</p>

				<!-- 変数numberに動物の主キーを代入してdoGetに渡す -->
				<div class="message">
					<button onclick="location.href='/aniMatch/Login?number=${AnimalInfo.animalKey}'">メッセージ</button></div>
			</div>
		</div>
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
</main>
<!-- メインここまで -->
<!-- フッター -->
<footer class="footer">
<p>&copy;Copyright aniMach. All rights reserved.</p>
</footer>
<!-- フッターここまで -->
</div>

</body>
</html>