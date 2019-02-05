<%@page import="javaBeans.JugyoTable"%>
<%@page import="javaBeans.JikanwariTable"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<JugyoTable> jugyo = (ArrayList<JugyoTable>) request.getAttribute("jugyo");
	String subjects_name = (String)request.getAttribute("subjects_name");
	int jugyo_count = (int)request.getAttribute("jugyo_count");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=subjects_name%></h1>

<table class="attendance_table">
  <tr><th></th><th>列-A</th><th>列-B</th></tr>
  <tr><td>行-1</td><td>A-1</td><td>B-1</td></tr>
  <tr><td>行-2</td><td>A-2</td><td>B-2</td></tr>
  <tr><td>行-3</td><td>A-3</td><td>B-3</td></tr>
</table>
</body>
</html>