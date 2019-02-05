<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/LOVE_BERRY_WEB/css/admin_lobe.css">
<link rel="stylesheet" type="text/css" href="/LOVE_BERRY_WEB/css/admin_Lobe_New.css">
<title>LOBE新規登録画面</title>
</head>
<body>
<div id="main">
<h1 id="title">LOBE新規登録</h1>
<div id="new">
<form action="CreateNewLobeServlet">
新規LOBE名:<input type="text" name="newLobeName" maxlength="3">
設置教室名：<input type="text" name="installation_location" maxlength="3">
<input type="submit" value="送信" id="button">
</form>
</div>
<form action="ShowLobeTopServlet">
<input type="submit" value="" id="back_lobe">
</form>
</div>
</body>
</html>