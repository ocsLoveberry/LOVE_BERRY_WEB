<%@page import="java.util.ArrayList"%>
<%@page import="javaBeans.JugyoTable"%>
<%@page import="javaBeans.OcsJohoData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
ArrayList<JugyoTable> jugyo = (ArrayList<JugyoTable>) request.getAttribute("jugyo");
ArrayList<OcsJohoData> ocsJohoData = (ArrayList<OcsJohoData>) request.getAttribute("ocsJohoData");
String subjects_name = (String)request.getAttribute("subjects_name");
int jugyo_count = (int)request.getAttribute("jugyo_count");
String temp_status[] = (String[])request.getAttribute("temp_status");
String status[] = (String[])request.getAttribute("status");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>特定授業、特定生徒（テスト行）</h1>
<table class="student">
	<tr>
		<th>学籍番号</th><th>学生氏名</th><th>呼び出しメッセージ</th>
	</tr>
	<tr>
		<th><%=ocsJohoData.get(0).getSeki_no() %></th><th><%=ocsJohoData.get(0).getName() %></th><th><%=ocsJohoData.get(0).getMessage() %></th>
	</tr>
</table>

</body>
</html>