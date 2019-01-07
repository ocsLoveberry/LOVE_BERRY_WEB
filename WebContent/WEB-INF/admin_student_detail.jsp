<%@page import="javaBeans.studentDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  ArrayList<studentDetailBean> studentDetailList = (ArrayList<studentDetailBean>)request.getAttribute("studentDetail");
	studentDetailBean studentDetail = studentDetailList.get(0);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student_detail</title>
</head>
<body>
	<h1>学生詳細情報</h1>
	<table>

		<tr>
			<th>学生番号</th>
			<td>
				<%= studentDetail.getSeki_no() %>
			</td>
		</tr>
		<tr>
			<th>氏名</th>
			<td><%= studentDetail.getName() %></td>
		</tr>
		<tr>
			<th>学科</th>
			<td><%= studentDetail.getDepartment() %></td>
		</tr>
		<tr>
			<th>専攻</th>
			<td><%= studentDetail.getMajor() %></td>
		</tr>
		<tr>
			<th>クラス</th>
			<td><%= studentDetail.getStudentClass() %></td>
		</tr>
		<tr>
			<th>入学年度</th>
			<td><%= studentDetail.getAdmissionYear() %></td>
		</tr>
		<tr>
			<th>呼び出しメッセージ</th>
			<td><%= studentDetail.getMessage() %></td>
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
			<th>テスト科目1</th>
			<%
				for (int i = 1; i < 15; i++) {
			%>
			<th>
				<%
					String maru = "○";
				%> <%= maru %>
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

	<h2>登録済みFelica情報</h2>
	<table>
		<tr>
			<th>FelicaID</th>
			<!-- <th>登録日時</th> -->
		</tr>

		<tr>
			<td><%= studentDetail.getStudentFelicaID1()%></td>
			<!--<td> //studentDetail.getStudentFelicaEntryDate() %></td>-->
		</tr>
		<% if(studentDetail.getStudentFelicaID2() != null){%>
		<tr>
			<td><%= studentDetail.getStudentFelicaID2() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>