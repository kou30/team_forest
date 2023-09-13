<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<table border="1" style="border-collapse: collapse">
<tr>
    <td>ID</td>
    <td>名前</td>
    <td>画像</td>
</tr>
    <c:forEach items="${ requestScope.imgtableList }" var="item">
<tr>
    <td><c:out value="${ images.id }" /></td>
    <td><c:out value="${ imgtable.faleName }" /></td>
    <td><img style="width: 100px; height: 100px" src="ItemDao?id=${ imgtable.id }"></td>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>