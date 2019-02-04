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
<title>Insert title here</title>
</head>
<h1>科目詳細画面</h1>
<body>
	（デバッグ）セッションID:<%=session.getId()%><br>
	<h1><%=jugyo.get(0).getSubjects_cd()%></h1>
	<br>
	<form method="post" action="ShowTeacherSubjectDetailServlet" name="form1">
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
				<td><a href="ShowTeacherSubjectDetailServlet?subjects_cd=<%=viewJugyo.getSubjects_cd()%>&start_date=<%=viewJugyo.getStart_date()%>&start_time=<%=viewJugyo.getStart_time_cd()%>">
						<%=i%>
				</a></td>
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
				<td></td>
			</tr>
			<%
				i++;
				}
			%>
		</table>
	</form>
</body>
</html>