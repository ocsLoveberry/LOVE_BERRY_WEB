<%@page import="javaBeans.teacherDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	teacherDetailBean teacherDetail = null;
	try {
		ArrayList<teacherDetailBean> teacherDetailList = (ArrayList<teacherDetailBean>) request
				.getAttribute("teacherDetail");
		teacherDetail = teacherDetailList.get(0);
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>teacher_detail</title>
</head>
<body>
	<form action="ShowDetailUpdateResultServret"
		target="resultTeachers">
		<h1>教員詳細情報</h1>
		<table>
			<tr>
				<th>学籍番号</th>
				<td><%=teacherDetail.getSeki_no()%></td>
			</tr>
			<tr>
				<th>氏名</th>
				<td><%=teacherDetail.getName()%></td>
			</tr>
			<tr>
				<th>呼び出しメッセージ</th>
				<td><%=teacherDetail.getMessage()%></td>
			</tr>
		</table>
		<h2>登録済みFelica情報</h2>
		<table>
			<tr>
				<th>FelicaID</th>
			</tr>
			<tr>
				<td>
					<%
						session.setAttribute("seki_no", teacherDetail.getSeki_no());
 	try {
 		if (teacherDetail.getTeacherFelicaID1().isEmpty()) {
 			out.println("登録済みFelica1情報はありません");
 		} else {
 			out.println(teacherDetail.getTeacherFelicaID1());
 %> <input type="checkbox" name="update_idm_btn" value="idm1"> <%
 	}
 	} catch (NullPointerException e) {
 		out.println("登録済みFelica1情報はありません");
 	}
 %>
				</td>
			</tr>
			<tr>
				<td>
					<%
						try {
							if (teacherDetail.getTeacherFelicaID2().isEmpty()) {
								out.println("登録済みFelica2情報はありません");
							} else {
								out.println(teacherDetail.getTeacherFelicaID2());
					%> <input type="checkbox" name="update_idm_btn" value="idm2">
					<%
						}
						} catch (NullPointerException e) {
							out.println("登録済みFelica2情報はありません");
						}
					%>
				</td>
			<tr>
				<td><input type="submit" name="Confirm" value="削除" id="">
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="Back" value="戻る" id="">
				</td>
			</tr>
		</table>
	</form>
</html>
</body>
</html>