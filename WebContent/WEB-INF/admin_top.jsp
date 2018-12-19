<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOVE_BERRY</title>
</head>
<body>
<h1>LOVE_BERRY  管理者ページ</h1>
	<table>
	<tr><td><a href="">学生検索（工事中）</a></td></tr>
	<tr><td><a href="">教員検索画面（工事中）</a></td></tr>
	<tr><td><a href="">インポート画面（工事中）</a></td></tr>
	<tr><td><a href="">Felica画面（工事中）</a></td></tr>
	<tr><td><a href="">LOBE情報画面（工事中）</a></td></tr>
	<tr><td><a href="ShowSessionListServlet">テストページ表示</a></td></tr>
	<tr><td>下記は問題なし、上はテスト項目</td></tr>

	<%
	String username = request.getRemoteUser();
	HttpSession session = request.getSession(false);
	session.setAttribute("seki_no",username);
	%>
	<tr><td>ログインIDは<%= username %></td></tr>
	<tr><td><a href="ShowLogoutServlet">ログアウト</a></td></tr>
	</table>
</body>
</html>