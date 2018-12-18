<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOVE_BERRY</title>
</head>
<body>
<h1>LOVE_BERRY  教員ページだぞ</h1>
	<table>
	<tr><td><a href="CreateJikanwariServlet">時間割ページ表示</a></td></tr>
	<tr><td><a href="ShowCreateJugyoServlet">授業作成ページ（test）</a></td></tr>
	<tr><td><a href="ShowSessionListServlet">テストページ表示</a></td></tr>
	<tr><td><a href="ShowJugyoDetail">授業テストページ表示</a></td></tr>
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