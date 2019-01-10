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
	<br>
	<% if(!studentData.isEmpty()){ %>
	<form action="showStudentDetailServlet" method="post">
		<table>
			<tr>
				<th>学籍番号</th>
				<th>名前</th>
				<th>コメント</th>
				<th>選択</th>
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
			<td>
			<input type="radio" name="seki_no" value="<%= student.getSeki_no() %>">
			</td>
			</tr>
			<%} %>
		</table>
		<input type="submit" value="詳細表示">
	</form>
		<%
		 }else{
			out.println("検索に一致する生徒が見つかりませんでした");
		}%>
</body>
</html>