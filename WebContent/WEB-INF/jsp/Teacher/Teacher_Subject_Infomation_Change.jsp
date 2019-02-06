<%@page import="javaBeans.JugyoTable"%>
<%@page import="javaBeans.ClassSubjects"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>科目変更画面</title>
</head>
<body>
	<h1>科目変更画面</h1>
	（デバッグ）セッションID:<%=session.getId()%><br>
	<%
		ArrayList<JugyoTable> jugyoDetailList = (ArrayList<JugyoTable>) request.getAttribute("jugyoDetailList");
	%>
	<%=jugyoDetailList.get(0).getSubjects_cd()%>
</body>
</html>