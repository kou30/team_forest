<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
 	<head>
 		<title>検索画面</title>
 		<link rel = "stylesheet" href = "css/style.css">

 	</head>
 	<body>
 	<form action="\aniMatch\Search" method="post">

 	性別：
<!--  	指定なし<input type="radio" name="sex" value="0"> -->
 	指定なし<input type="radio" name="sex" value=null checked="checked">

 	オス<input type="radio" name="sex" value="オス">
 	メス<input type="radio" name="sex" value="メス"><br>

 	年齢：
<!--  	指定なし<input type="radio" name="age" value="0"> -->
 	指定なし<input type="radio" name="age" value=null checked="checked">

 	幼年期<input type="radio" name="age" value="幼年期">
 	青年期<input type="radio" name="age" value="青年期">
 	老年期<input type="radio" name="age" value="老年期"><br>

 	エリア：
 	<select name="place">
	<option value="null">選択して下さい</option>
 	<option value="滋賀">滋賀</option>
	<option value="京都">京都</option>
	<option value="兵庫">兵庫</option>
	<option value="大阪">大阪</option>
	<option value="奈良">奈良</option>
	<option value="和歌山">和歌山</option>
	<option value="三重">三重</option>
 	</select><br>

	<input type="hidden" name="test" value="1" >
 	<input type="submit" value="検索">
 	</form>

 	</body>
 </html>