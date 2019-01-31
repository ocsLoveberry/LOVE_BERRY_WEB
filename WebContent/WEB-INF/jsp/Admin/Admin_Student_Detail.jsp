<%@page import="javaBeans.studentDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	studentDetailBean studentDetail = null;
	try {
		ArrayList<studentDetailBean> studentDetailList = (ArrayList<studentDetailBean>) request
				.getAttribute("studentDetail");
		studentDetail = studentDetailList.get(0);
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student_detail</title>
</head>
<body>
	<form action="ShowDetailUpdateResultServret" target="resultStudent">
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
				<th>テスト科目1</th>
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

		<h2>登録済みFelica情報</h2>
		<table>
			<tr>
				<th>FelicaID</th>
				<!-- <th>登録日時</th> -->
			</tr>

			<tr>
				<td>
					<%
					session.setAttribute("seki_no", studentDetail.getSeki_no());

						try {
							if (studentDetail.getStudentFelicaID1().isEmpty()) {
								String message = "登録済みFelica情報なし";
								out.println(message);
							} else {
								out.println(studentDetail.getStudentFelicaID1());
					%><input type="checkbox" name="update_idm_btn" value="idm1">
					<%
						}
						} catch (NullPointerException e) {
							String message = "登録済みFelica情報なし";
							out.println(message);
						}
					%>
				</td>
			</tr>
			<%
				if (studentDetail.getStudentFelicaID2() != null) {
			%>
			<tr>
				<td><%=studentDetail.getStudentFelicaID2()%> <!-- <input type="checkbox" name="update_idm_btn" value="idm1"></td> -->
			</tr>
			<%
				}
			%><tr>
				<td><input type="submit" name="Confirm" value="確定" id="">
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="Back" value="戻る" id="">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>