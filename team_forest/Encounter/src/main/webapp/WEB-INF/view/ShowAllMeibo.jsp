<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserInfoDto" %>
<%@ page import="java.util.List" %>
<%@ page import="model.MeiboDTO" %> <!-- MeiboDTOのパッケージを正しいものに置き換えてください -->
<%@ page import="model.ShowAllMeiboBL" %>
<%@ page import="java.io.FileOutputStream" %>

<%! String replaceEscapeChar(String inputText) {
    inputText = inputText.replace("&", "&amp;");
    inputText = inputText.replace("<", "&lt;");
    inputText = inputText.replace(">", "&gt;");
    inputText = inputText.replace("\"", "&quot;");
    inputText = inputText.replace("'", "&#039;");
    
    return inputText;
} %>

<%
    // セッションからユーザーデータを取得
    UserInfoDto userInfoOnSession = (UserInfoDto) session.getAttribute("LOGIN_INFO");
    String userId = userInfoOnSession.getUserId(); 
    List<MeiboDTO> MeiboDTOlist = (List<MeiboDTO>) request.getAttribute("MEIBO");
    
%>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>名簿一覧</title>
</head>
<body>
    <h1>名簿一覧</h1>
    <table>
        <tr>
            <th>名前</th>
            <th>よみがな</th>
            <th>生年月日</th>
            <th>性別</th>
            <th>分類</th>
            <th>続柄</th>
            <th>備考</th>
            <th>品物登録</th>
            <th>コマンド</th>
        </tr>
        <% for (int i = 0; i < MeiboDTOlist.size(); i++) {
            MeiboDTO dto = MeiboDTOlist.get(i);
        %>
        <%
        String[] relationships = {
        	    "選択なし", "父", "母", "兄", "姉", "弟", "妹", "義父", "義母", "義兄",
        	    "義姉", "義弟", "義妹", "義祖父", "義祖母", "義曽祖父", "義曾祖母", "義おじ", "義おば",
        	    "義いとこ", "義甥", "義姪", "夫", "妻", "息子", "娘"
        	};
        %>
        <%
        String[] gender = {
       	 	"選択なし","男","女" //「選択なし」を選択することはできないが、追加する可能性を加味しこうしている。
       	    };
        %>
        <tr>
            <td><%= replaceEscapeChar(dto.getName()) %></td> 
            <td><%= replaceEscapeChar(dto.getYomi()) %></td> 
            <td><%= dto.getBirthday() %></td>
            <td><%= gender[dto.getSex()]%></td>
            <td><%= dto.getBunrui() %></td>
            <td><%= relationships[dto.getRelationship()-1] %></a></td>
            <td><%= replaceEscapeChar(dto.getMemo()) %></td>
            <td><a href="ShinamonoEntry">品物登録</a></td>
            <td><a href="">個人ページ</a></td>

        </tr>
        <% } %>
    </table>
    <a href="Mainsub">サンプルHP</a>
</body>
</html>
