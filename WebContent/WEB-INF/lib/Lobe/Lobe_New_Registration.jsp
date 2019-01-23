<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LOBE新規登録</h1>
<form action="CreateNewLobeServlet">
新規LOBE名:<input type="text" name="newLobeName" maxlength="3">
設置教室名：<input type="text" name="installation_location" maxlength="3">
<input type="submit" value="送信">
</form>
<form action="ShowTopServlet">
<input type="submit" value="トップへ戻る">
</form>
</body>
</html>