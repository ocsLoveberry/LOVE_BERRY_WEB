<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/LOVE_BERRY_WEB/css/Teacher_stu_sea.css">
<link rel="stylesheet" type="text/css"
	href="/LOVE_BERRY_WEB/css/table_Result.css">
<title>学生検索</title>
</head>
<body>
	<header id="title">
		<%
			String username = request.getRemoteUser();
			HttpSession session = request.getSession(false);
			session.setAttribute("seki_no", username);
		%>
		<h4>
			ログインID:<%=username%></h4>
		<h1 id="LB">学生検索</h1>
	</header>
	<div id="form">
		<br>
		<form action="ShowTeacherStudentResultServlet" target="resultStudent">
			<input type="radio" name="radio_Name_or_SekiNo" value="select_Name"
				checked> 氏名 <input type="text" name="text_Student_name"
				maxlength="6"> <input type="radio"
				name="radio_Name_or_SekiNo" value="select_sekiNo"> 学籍番号 <input
				type="text" name="text_Student_SekiNo" maxlength="6"> <input
				type="submit" value="検索">
		</form>
		<!-- 検索結果表示枠 -->
		<iframe name="resultStudent" width="900px" height="700px" id="frame"
			id="frame"> </iframe>
		<div id="yazi">
			<form action="ShowTopServlet">
				<input type="submit" value=" " id="back">
			</form>
		</div>
	</div>
</body>
</html>