<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testページ</title>
</head>
<body>
	<h1>テストページ</h1>
	<p>あいうえおかきくけこ
	<p>セッションIDは「" + session.getId() + "」です。</p>
	<h1>Nitiji:<%=request.getParameter("hoge") %></h1>
</body>
</html>