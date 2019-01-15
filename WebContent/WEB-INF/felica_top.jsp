<%@page import="javax.annotation.processing.SupportedAnnotationTypes"%>
<%@page import="javaBeans.FelicaData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% @SuppressWarnings("unchecked") ArrayList<FelicaData> felicaData = (ArrayList<FelicaData>)request.getAttribute("felicaData"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Felicaトップ</h1>
<table>
	<tr>
		<th>学籍番号</th>
		<th>IDM1</th>
		<th>メッセージ1</th>
		<th>IDM2</th>
		<th>メッセージ2</th>
	</tr>
	<% for(FelicaData felica: felicaData){ %>
	<tr>
		<td><%= felica.getSeki_no() %></td>
		<td><%= felica.getIdm1() %></td>
		<td><%= felica.getComment1() %></td>
		<td><%= felica.getComment2() %></td>
	</tr>
	<%} %>
</table>
</body>
</html>