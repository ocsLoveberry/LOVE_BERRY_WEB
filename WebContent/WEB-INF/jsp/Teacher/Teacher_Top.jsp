<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOVE_BERRY</title>
<link rel="stylesheet" type="text/css"
	href="/LOVE_BERRY_WEB/css/Tea_top.css">
</head>
<body>
	<header id="title">
		<%
			String username = request.getRemoteUser();
			HttpSession session = request.getSession(false);
			session.setAttribute("seki_no", username);
		%>
		<h4>
			ログインID:<%=username%>
		</h4>
		<h1 class="LB">LOVE_BERRY 教員ページだゾ</h1>
	</header>
	<table class="menu">
		<tr>
			<td><input type="button" value="時間割" id="time"></td>
			<td><input type="button" value="科目一覧" id="SL"></td>
		</tr>
		<tr>

			<td><input type="button" value="学生検索" id="stu_search"></td>
		</tr>

		<tr>
			<td><input type="submit" value="" id="logout"></td>
		</tr>
	</table>
	<script>
		document.getElementById("time").onclick = function() {
			location.href = "/LOVE_BERRY_WEB/CreateJikanwariServlet";
		}

		document.getElementById("SL").onclick = function() {
			location.href = "/LOVE_BERRY_WEB/ShowTeacherSubjectListServlet";
		}

		document.getElementById("stu_search").onclick = function() {
			location.href = "/LOVE_BERRY_WEB/ShowTeacherStudentSearch";
		}

		document.getElementById("logout").onclick = function() {
			location.href = "/LOVE_BERRY_WEB/ShowLogoutServlet";
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