<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="javaBeans.OcsJohoData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% ArrayList<OcsJohoData> studentData = (ArrayList<OcsJohoData>)request.getAttribute("studentData"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
	DBの値を一覧表示！
	<br>

	<table>
		<tr>
			<th>学籍番号</th>
			<th>名前</th>
			<th>コメント</th>
		</tr>
		<% for(OcsJohoData student: studentData){ %>
		<tr>
		<td>
		<%= student.getSeki_no() %>
		</td>
		<td>
		<%= student.getName() %>
		</td>
		<td>
		<%= student.getComment() %>
		</td>
		</tr>
		<%} %>

	</table>

</body>
</html>