<%@page import="javaBeans.JugyoTable"%>
<%@page import="javaBeans.JikanwariTable"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true"%>
<%
	ArrayList<JugyoTable> jugyo = (ArrayList<JugyoTable>) request.getAttribute("jugyo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/LOVE_BERRY_WEB/css/table_Result.css">
<title>科目詳細画面</title>
</head>
<h1>科目詳細</h1>
<body>
	<table class="tbl">
		<tr class="sub">
			<td>回数</td>
			<td>授業名（デバッグ）</td>
			<td>日付</td>
			<td>時限</td>
			<td>教室1</td>
			<td>教室2</td>
			<td>教室3</td>
			<td>コメント</td>
		</tr>

		<%
			int i = 1;
			for (JugyoTable viewJugyo : jugyo) {
		%>

		<tr>
			<td id="con"><%=i%></td>
			<td id="jgy"><input type="hidden" name="subject_cd"> <%=viewJugyo.getSubjects_cd()%>
			</td>
			<td id="day"><input type="hidden" name="start_date"> <%=viewJugyo.getStart_date()%>
			</td>
			<td id="time"><input type="hidden" name="start_time_cd"><%=viewJugyo.getStart_time_cd()%>時限
			</td>
			<td class="room"><input type="hidden" name="room_cd1()">
				<%
					if (viewJugyo.getRoom_cd1() != null) {
				%> <%=viewJugyo.getRoom_cd1()%> <%
 	} else {
 			System.out.println("");
 		}
 %></td>
			<td class="room"><input type="hidden" name="room_cd2()">
				<%
					if (viewJugyo.getRoom_cd2() != null) {
				%> <%=viewJugyo.getRoom_cd2()%> <!-- nullじゃなければ --> <%
 	} else {
 			System.out.println("");
 			//nullなら空白
 		}
 %></td>
			<td class="room"><input type="hidden" name="room_cd3()">
				<%
					if (viewJugyo.getRoom_cd3() != null) {
				%> <%=viewJugyo.getRoom_cd3()%> <!-- nullじゃなければ --> <%
 	} else {
 			System.out.println("");
 			//nullなら空白
 		}
 %></td>
			<td id="coment"><input type="hidden" name="comment()"> <%
 	if (viewJugyo.getComment() != null) {
 %> <%=viewJugyo.getComment()%> <!-- nullじゃなければ --> <%
 	} else {
 			System.out.println("");
 			//nullなら空白
 		}
 %></td>
		</tr>
		<%
			i++;
			}
			request.setAttribute("Jugyo_cnt", i);
		%>
	</table>
	<form action="ShowSubjectsAttendanceServlet" target="subjectDetail">
		<input type="submit" name="ShowSubjectsAttendanceServletbtn"
			value="出席情報一覧へ">
		<%
			session.setAttribute("Subjects_cd", jugyo.get(0).getSubjects_cd());
		%>
	</form>
</body>
</html>