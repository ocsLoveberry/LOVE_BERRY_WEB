<!-- @author ace -->
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Allerta+Stencil"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="/LOVE_BERRY_WEB/css/stu_punch_search_result.css">
<title>打刻検索画面</title>
</head>
<body>
	<!-- ヘッダー -->
	<header id="header">
		<%
			String username = request.getRemoteUser();
		%>
		<h4>
			ログインIDは<%=username%>
		</h4>
		<h1 class="LB">
			<a href="ShowTopServlet">Love&Berry</a>
		</h1>
	</header>

	<div id="main">
		<%
			List<String[]> resultStudentPunch = (List<String[]>) request.getAttribute("resultStudentPunch");
		%>
		<p id="num">
			学生番号:<%=resultStudentPunch.get(0)[0]%>
		<p>
		<table id="punch_result_table">
			<thead>
				<tr>
					<th>打刻場所</th>
					<th>打刻日時</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (int i = 0; i < resultStudentPunch.size(); i++) {
				%>
				<tr>
					<td><%=resultStudentPunch.get(i)[2]%></td>
					<td><%=resultStudentPunch.get(i)[1]%></td>
				</tr>
				<%
					}
				%>

			</tbody>
		</table>
	</div>
	<div id="yazi"><form action="ShowStudentPunchSearchServlet"><input type="submit" value=" " id="back"></form></div>
</body>
</html>