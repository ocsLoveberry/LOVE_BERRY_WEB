<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/LOVE_BERRY_WEB/css/Admin_Teacher_Search.css">
<link rel="stylesheet" type="text/css" href="/LOVE_BERRY_WEB/css/table_Result.css">
<title>教職員検索画面</title>
</head>
<body>
<div id="form">
<h1 id="title">教職員検索画面</h1>
<form action="ShowTeacherSearchResultServlet" target="resultTeachers">
<!-- 教職員画面作る -->
		<input type="radio" name="select_textbox_btn" value="select_name" checked >氏名：
		<input type="text" name="teacher_name_tb" value="">
		<input type="radio" name="select_textbox_btn" value="select_num" >籍番号：
		<input type="text" name="scl_num_tb" >
		<input type="submit" value="検索">
	<br>
</form>
	<iframe name="resultTeachers" width="900px" height="600px" id="frame">
	</iframe>
	<br>
<form action="ShowTopServlet"><input type="submit" value=" " id="back"></form>
</div>
	</body>
</html>