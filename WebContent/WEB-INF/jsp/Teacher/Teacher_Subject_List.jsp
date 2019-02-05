<%@page import="javaBeans.ClassSubjects"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<ClassSubjects> classSubject = (ArrayList<ClassSubjects>) request.getAttribute("classSubject");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>科目一覧画面</title>
</head>
<body>

	<table>
		<tr>
			<th>科目名</th>
		</tr>
		<%
			for (ClassSubjects csView : classSubject) {
		%>
		<tr>
			<!-- servlet名?パラメータ名=パラメータでgetメソッドで値をhrefで送信できる -->
			<!-- formタグを使えばPOSTメソッドも使える -->
			<td><a
				href="ShowTeacherSubjectDetailServlet?Subjects_cd=<%=csView.getSubjects_cd()%>"
				target="subjectDetail"><%=csView.getSubjects_cd()%></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<iframe name="subjectDetail" width="900px" height="700px" id="frame"></iframe>
	<br>
	<a href="ShowTopServlet">トップへ戻る</a>

</body>
</html>