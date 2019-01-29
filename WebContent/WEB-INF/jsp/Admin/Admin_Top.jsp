<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/LOVE_BERRY_WEB/css/admin_top.css">
<title>LOVE_BERRY</title>
</head>
<body>
<h1 id="LB">LOVE_BERRY  管理者ページ</h1>
	<table>
	<tr>
	<td><input type="button" value="学生検索" id="stu"></td>
	<td><input type="button" value="教員検索" id="tea"></td>
	</tr>
	<tr>
	<td><input type="button" value="Felica" id="Fel"></td>
	<td><input type="button" value="LOBE情報" id="lobe"></td>
	</tr>

	<tr><td>下記は問題なし、上はテスト項目</td></tr>

	<%
	String username = request.getRemoteUser();
	HttpSession session = request.getSession(false);
	session.setAttribute("seki_no",username);
	%>
	<tr><td>ログインIDは<%= username %></td></tr>
	<tr><td><a href="ShowLogoutServlet">ログアウト</a></td></tr>
	</table>

<script>
document.getElementById("stu").onclick= function(){
	location.href= "/LOVE_BERRY_WEB/ShowStudentSearchServlet";
	}

document.getElementById("Fel").onclick= function(){
	location.href= "/LOVE_BERRY_WEB/ShowFelicaTopServlet";
	}

document.getElementById("lobe").onclick= function(){
	location.href= "/LOVE_BERRY_WEB/ShowLobeTopServlet";
	}

document.getElementById("#").onclick= function(){
	location.href= "/LOVE_BERRY_WEB/";
	}


</script>
</body>
</html>