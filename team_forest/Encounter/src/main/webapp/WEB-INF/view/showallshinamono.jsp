<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="model.ShinamonoDTO"%>

<%!String replaceEscapeChar(String inputText) {
		inputText = inputText.replace("&", "&amp");
		inputText = inputText.replace("<", "&lt");
		inputText = inputText.replace(">", "&gt");
		inputText = inputText.replace("'", "&#039");
		inputText = inputText.replace("\"", "&quot");
		return inputText;
	}%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="styles.css">
<title>贈ったモノ・頂いたモノ全件一覧</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="#">TOP</a></li>
				<li><a href="#">名簿一覧へ移動</a></li>
			</ul>
		</nav>
	</header>
	<h1>贈ったモノ・頂いたモノ全件一覧</h1>

	<h2>贈ったモノ頂いたもの</h2>
	<table>
		<tr>
			<th>相手の名前</th>
			<th>品物送受日</th>
			<th>項目</th>
			<th>詳細項目</th>
			<th>品目名</th>
			<th>金額(項目：お金のみ)</th>
			<th>備考</th>
			<th>編集</th>
			<th>削除</th>
		</tr>
		<% List<ShinamonoDTO> list= (List<ShinamonoDTO>)request.getAttribute("list"); %>

		<% for(int i = 0;i < list.size(); i++) {
            ShinamonoDTO dto = list.get(i); %>
		<tr>
			<td><%=dto.getAite_name() %></td>
			<td><%=dto.getRe_time() %></td>
			<%
		String a = "0";
		switch (dto.getBunrui()) {
		case 0:
			a = "未選択";
			break;
		case 1:
			a = "贈り物";
			break;
		case 2:
			a = "頂き物";
			break;
		}
		%>
			<td><%=a%></td>
			<%
		switch (dto.getCategory()) {
		case 0:
			a = "未選択";
			break;
		case 1:
			a = "品物";
			break;
		case 2:
			a = "お金";
			break;
		case 3:
			a = "手紙など";
			break;
		}
		%>
			<td><%=a%></td>
			<%
		if(dto.getCategory()==0){
			a="未選択";}
		if(dto.getCategory()==1){
			switch (dto.getItem()) {
		case 0:
			a = "未選択";
			break;
		case 1:
			a = "お中元";
			break;
		case 2:
			a = "お供え物";
			break;
		case 3:
			a = "お祝いもの";
			break;
		case 4:
			a = "お見舞い品";
			break;
		case 5:
			a = "贈答品";
			break;
		case 6:
			a = "お土産";
			break;
		case 7:
			a = "記念品";
			break;
		case 8:
			a = "誕生日プレゼント";
			break;
		case 9:
			a = "結婚祝い品";
			break;
		case 10:
			a = "出産祝い品";
			break;
		case 11:
			a = "引っ越し祝い品";
			break;
		case 12:
			a = "その他";
			break;}}
		if(dto.getCategory()==2){
				switch (dto.getItem()) {
			case 0:
				a = "未選択";
				break;
			case 1:
				a = "寄付金";
				break;
			case 2:
				a = "贈与金";
				break;
			case 3:
				a = "祝儀金";
				break;
			case 4:
				a = "贈答金";
				break;
			case 5:
				a = "報酬金";
				break;
			case 6:
				a = "賞金";
				break;
			case 7:
				a = "贈賄金";
				break;
			case 8:
				a = "支援金";
				break;
			case 9:
				a = "貢献金";
				break;
			case 10:
				a = "ギフト券";
				break;
			case 11:
				a = "仏教関連金";
				break;
			case 12:
				a = "お祝い金";
				break;
			case 13:
				a = "その他";
				break;
			}
		}
		if(dto.getCategory()==3){
			switch (dto.getItem()) {
		case 0:
			a = "未選択";
			break;
		case 1:
			a = "年賀状";
			break;
		case 2:
			a = "招待状";
			break;
		case 3:
			a = "お詫び状";
			break;
		case 4:
			a = "通知状";
			break;
		case 5:
			a = "その他";
			break;}}
		%>
			<td><%=a%></td>
			<td><%=dto.getShinamono_kingaku() %></td>
			<td><%=dto.getMemo() %></td>
			<td><a
				href="<%=request.getContextPath()%>/ExecuteDelete?ID=<%=dto.getShinamono_id()%>">削除</a></td>
			<td><a
				href="<%=request.getContextPath()%>/ExecuteEdit?ID=<%=dto.getShinamono_id()%>">編集</a></td>
		</tr>
		<% } %>
	</table>

	<br>
	<a href="">ログアウト</a>
	<script src="js/script.js"></script>
	<footer>
		<p>&copy; team フォレスト</p>
	</footer>

</body>
</html>