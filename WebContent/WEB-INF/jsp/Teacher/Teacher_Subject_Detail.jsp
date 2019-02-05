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
<title>科目詳細画面</title>
</head>
<h1>科目詳細画面(Teacher_Subject_List.jsp)</h1>
<body>
	（デバッグ）セッションID:<%=session.getId()%><br>
	<h1><%=jugyo.get(0).getSubjects_cd()%></h1>
	<br>
	<table>
		<tr>
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
			<td><%=i%></td>
			<td><input type="hidden" name="subject_cd"> <%=viewJugyo.getSubjects_cd()%>
			</td>
			<td><input type="hidden" name="start_date"> <%=viewJugyo.getStart_date()%>
			</td>
			<td><input type="hidden" name="start_time_cd"><%=viewJugyo.getStart_time_cd()%>
			</td>
			<td><input type="hidden" name="room_cd1()"><%=viewJugyo.getRoom_cd1()%>
			</td>
			<td><input type="hidden" name="room_cd2()"><%=viewJugyo.getRoom_cd2()%>
			</td>
			<td><input type="hidden" name="room_cd2()"><%=viewJugyo.getRoom_cd3()%>
			</td>
			<td><input type="hidden" name="comment()"><%=viewJugyo.getComment()%>
			</td>
			<td><a
				href="ShowTeacherSubjectInformationChangeServlet?subject_cd=<%=viewJugyo.getSubjects_cd()%>
				&start_date= <%=viewJugyo.getStart_date()%>&start_time_cd=<%=viewJugyo.getStart_time_cd()%>
				&tokutei_cd=<%=viewJugyo.getTokutei_cd() %>">編集する</a></td>
		</tr>
		<%
			i++;
			}
		request.setAttribute("Jugyo_cnt", i);%>
	</table>
</body>
</html>