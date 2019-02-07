<%@page import="javaBeans.studentDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	studentDetailBean studentDetail = null;
	ArrayList<studentDetailBean> studentDetailList = null;
	try {
		studentDetailList = (ArrayList<studentDetailBean>) request
				.getAttribute("studentDetail");
		studentDetail = studentDetailList.get(0);
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
<%
	session.setAttribute("studentDate", studentDetailList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生詳細画面(Teacher_student_detailファイル検索用)</title>
</head>
<body>
	<!-- <form action="ShowDetailUpdateResultServret" target="resultStudent"> -->
	<h1>学生詳細情報</h1>
	<table>

		<tr>
			<th>学籍番号</th>
			<td><%=studentDetail.getSeki_no()%></td>
		</tr>
		<tr>
			<th>氏名</th>
			<td><%=studentDetail.getName()%></td>
		</tr>
		<tr>
			<th>学科</th>
			<td><%=studentDetail.getDepartment()%></td>
		</tr>
		<tr>
			<th>専攻</th>
			<td><%=studentDetail.getMajor()%></td>
		</tr>
		<tr>
			<th>クラス</th>
			<td><%=studentDetail.getStudentClass()%></td>
		</tr>
		<tr>
			<th>入学年度</th>
			<td><%=studentDetail.getAdmissionYear()%></td>
		</tr>
		<tr>
			<th>呼び出しメッセージ</th>
			<td><%=studentDetail.getMessage()%></td>
	</table>

	<h2>出欠状況</h2>
	<table>
		<tr>
			<th>科目名</th>
			<%
				for (int i = 1; i < 15; i++) {
			%>
			<th><%=i%></th>
			<%
				}
			%>
		</tr>
		<tr>
			<th><%=studentDetail.getSubject1() %></th>
			<%
				for (int i = 1; i < 15; i++) {
			%>
			<th>
				<%
					String maru = "○";
				%> <%=maru%>
			</th>
			<%
				}
			%>
		</tr>
		<tr>
			<th>テスト科目2</th>
		</tr>
		<tr>
			<th>テスト科目3</th>
		</tr>
	</table>
</body>
</html>