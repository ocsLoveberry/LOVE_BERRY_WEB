<%@page import="javaBeans.JugyoTable"%>
<%@page import="javaBeans.JikanwariTable"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<JugyoTable> jugyo = (ArrayList<JugyoTable>) request.getAttribute("jugyo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=jugyo.get(0).getSubjects_cd()%></h1>
	<table>
		<tr>
			<td>回数</td>
			<td>授業名（デバッグ）</td>
			<td>日付</td>
			<td>時限</td>
			<td>教室1</td>
			<td>教室2</td>
			<td>教室3</td>
			<td>コメント</td>
		</tr>

		<%
			int i = 1;
			for (JugyoTable viewJugyo : jugyo) {
		%>
		<tr>
			<td><%= i %></td>
			<td><%= viewJugyo.getSubjects_cd() %></td>
			<td><%=viewJugyo.getStart_date()%></td>
			<td><%=viewJugyo.getStart_time_cd()%></td>
			<td><%=viewJugyo.getRoom_cd1()%></td>
			<td><%=viewJugyo.getRoom_cd2()%></td>
			<td><%=viewJugyo.getRoom_cd3()%></td>
			<td><%=viewJugyo.getComment()%></td>
			<td></td>
		</tr>
		<%
				i++;
			}
		%>
	</table>

</body>
</html>