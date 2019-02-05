<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOVE_BERRY</title>
<link rel="stylesheet" type="text/css" href="/LOVE_BERRY_WEB/css/Tea_top.css">
</head>
<body>
<header id="title">
	<%
	String username = request.getRemoteUser();
	HttpSession session = request.getSession(false);
	session.setAttribute("seki_no",username);
	%>
	<h4>ログインID:<%= username %></h4>
<h1 class="LB">LOVE_BERRY  教員ページだゾ</h1>
</header>
<!--
		<ul class="link">
			<li><input type="button" value="科目一覧"  id="kamoku"></li>
			<li><input type="button" value="時間割" class="time"></li>
		</ul>

		<ul class="link2">
			<li><input type="button" value="学生検索" class="student"></li>
			<li><input type="button" value="イベント情報" class="events"></li>
		</ul>
		<ul class="link3">
			<li><input type="button" value="ログアウト" class="logout"></li>
		</ul>
-->
	<table class="menu">
	<tr>
			<td><input type="button" value="時間割" id="kamoku"></td>
			<td><input type="button" value="学生検索" id="stu_sea"></td>
	</tr>
	<tr>
			<td><input type="button" value="科目一覧" id="guraburu"></td>
			<td><input type="button" value="ケモフレ民" id="tathuki"></td>
	</tr>

	<tr><td><input type="submit" value="ログアウト" id="logout"></td></tr>
	</table>

	<a href="ShowTeacherSubjectListServlet">科目一覧画面</a>

<script>
	document.getElementById("kamoku").onclick= function(){
	location.href= "/LOVE_BERRY_WEB/CreateJikanwariServlet";
	}

	document.getElementById("kamoku").onclick= function(){
	location.href= "/LOVE_BERRY_WEB/ShowCreateJugyoServlet";
	}

	document.getElementById("stu_sea").onclick= function(){
	location.href= "/LOVE_BERRY_WEB/ShowSessionListServlet";
	}

	document.getElementById("kamoku").onclick= function(){
	location.href= "/LOVE_BERRY_WEB/ShowJugyoDetail";
	}

	document.getElementById("logout").onclick= function(){
	location.href= "/LOVE_BERRY_WEB/ShowLogoutServlet";
	}


</script>

</body>
</html>
<!--
!!科目一覧画面について
トップ画面
↓
科目一覧画面（Teacher_Subject_List.jsp）
↓
科目詳細画面（Teacher_Subject_Detail.jsp）
↓
科目情報変更画面（Teacher_Subject_Infomation_Change.jsp）

 -->