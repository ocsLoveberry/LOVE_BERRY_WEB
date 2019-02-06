<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/LOVE_BERRY_WEB/css/stu_top.css">
<title>LOVE_BERRY</title>
</head>
<body>
<header id="header">
<% String username = request.getRemoteUser();%>
	<h4>ログインIDは<%= username %></h4>
<h1 id="LB">LOVE_BERRY  学生ページだぞ</h1>
</header>
	<table id="menu">
	<tr>
	<td><input type="button" value="打刻検索" id="punch"></td>
	<td><input type="button" value="時間割" id="time"></td>
	</tr>
	<tr><td><input type="submit" value="" id="out"></td></tr>

	</table>

	<script>
	document.getElementById("punch").onclick= function(){
	location.href= "/LOVE_BERRY_WEB/ShowStudentPunchSearchServlet";
	}

	document.getElementById("time").onclick= function(){
	location.href= "/LOVE_BERRY_WEB/CalendarDetailServlet";
	}

	document.getElementById("out").onclick= function(){
	location.href= "/LOVE_BERRY_WEB/ShowLogoutServlet";
	}
	</script>
</body>
</html>