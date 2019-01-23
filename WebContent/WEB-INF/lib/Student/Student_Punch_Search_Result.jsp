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
<link rel="stylesheet" href="/GraduationResearchPJ/WebApps/Student/stu_punch_search_result.css">
<title>打刻検索画面</title>
</head>
<body>
	<!-- ヘッダー -->
	<header>
		<div class="id">
			<div id="header">
				<h1 class="LB">
					<a href="">Love&Berry</a>
				</h1>
				<!-- リンク -->
				<div class="link">
					<a href="ShowTopServlet">トップへ戻る</a>
					<a href="ShowLogoutServlet">ログアウト</a>
				</div>
				<p></p>
			</div>
		</div>
	</header>

	<div id="main">
<% List<String[]> resultStudentPunch = (List<String[]>)request.getAttribute("resultStudentPunch");
%>
<p><%=resultStudentPunch.get(0)[0] %><p>
		<div class="punch_table">
			<table class="punch_result_table">
				<thead>
					<tr>
						<th>打刻場所</th>
						<th>打刻日時</th>
					</tr>
				</thead>
				<tbody>
					<% for(int i = 0; i < resultStudentPunch.size(); i++){ %>
					<tr>
						<td><%=resultStudentPunch.get(i)[2] %></td>
						<td><%=resultStudentPunch.get(i)[1] %></td>
					</tr>
					<% } %>

				</tbody>
			</table>
		</div>
	</div>
</body>
</html>