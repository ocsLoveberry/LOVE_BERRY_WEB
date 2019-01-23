<%@ page import="javaBeans.teacherDetailBean"%>
<!--Beansを作ってからインポートすること現在コメントアウト中  -->
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
teacherDetailBean teacherDetail = null;
try{
	ArrayList<teacherDetailBean> teacherDetailList = (ArrayList<teacherDetailBean>)request.getAttribute("teacherDetail");
	teacherDetail = teacherDetailList.get(0);
	}catch(Exception e){
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
	<h1>学生詳細情報</h1>
	<table>
		<tr>
			<th>学籍番号</th>
			<td>
				<%= teacherDetail.getSeki_no() %>
			</td>
		</tr>
		<tr>
			<th>氏名</th>
			<td><%= teacherDetail.getName() %></td>
		</tr>
		<tr>
			<th>メールアドレス</th>
			<td><%= teacherDetail.getDepartment() %></td>
		</tr>
		<tr>
			<th>メッセージ</th>
			<td><%= teacherDetail.getMajor() %></td>
		</tr>
		<tr>
			<th>No</th>
			<td></td>
		</tr>
		<tr>
			<th>IDm</th>
			<td></td>
		</tr>
		<tr>
			<th>IDm コメント</th>
			<td></td>
		<tr>
			<th>削除</th>
			<td></td>
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
			try{
				if(teacherDetail.getteacherFelicaID1().isEmpty()){
					String message = "登録済みFelica情報なし";
					out.println(message);
				}else{
					out.println(teacherDetail.getteacherFelicaID1());
				}
			}catch(NullPointerException e){
				String message = "登録済みFelica情報なし";
				out.println(message);
			}
			%>
			</td>
			<td> teacherDetail.getteacherFelicaEntryDate() %></td>
		</tr>
		<% if(teacherDetail.getteacherFelicaID2() != null){ %>
		<tr><% }%>
		<%-- 	<td><%= teacherDetail.getteacherFelicaID2(); %></td> --%>
		</tr>
	</table>
</body>
</html>