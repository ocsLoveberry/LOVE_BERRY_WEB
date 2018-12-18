<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOVE_BERRY</title>
</head>
<body>
<h1>LOVE_BERRY  学生ページだぞ</h1>
	<table>
	<tr><td><a href="StudentInfoServlet">学生一覧表示</a></td></tr>
	<tr><td><a href="studentinput.html">学生登録</a></td></tr>
	<tr><td><a href="ShowStudentPunchSearchServlet">打刻検索</a></td></tr>
	<tr><td><a href="ShowTestServlet">テストページ表示</a></td></tr>
	<tr><td>下記は問題なし、上はテスト項目</td></tr>
	<% String username = request.getRemoteUser();%>
	<tr><td>ログインIDは<%= username %></td></tr>
	<tr><td><a href="ShowLogoutServlet">ログアウト</a></td></tr>
	</table>
</body>
</html>