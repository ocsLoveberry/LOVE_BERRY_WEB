<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
<%@page import="javaBeans.TeacherSearchBeans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% ArrayList<TeacherSearchBeans> teacherDate = (ArrayList<TeacherSearchBeans>)request.getAttribute("teacherDate");
 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タイトルを入力</title>
</head>
<body>
	<h2>検索結果の表示</h2>
 	<% if(!teacherDate.isEmpty()){ %>
 	<form action = "ShowTeacherDetailServlet" method="post">
	<table>
	<tr>
		<th></th>
		<th>学籍番号</th>
		<th>氏名</th>
		<th>メールアドレス</th>
		<th>メッセージ</th>
	</tr>
	<%//} %>
	<tr>
 <% for(TeacherSearchBeans teacherList: teacherDate) {%>
 	<tr>
 	<td>
		<% boolean isFirst = true;
			if(isFirst){ %>
			<input type="radio" name="seki_no"
					value="<%= teacherList.getSeki_no() %> " checked>
		<%
			isFirst = false;
			}else{
		%>
			<input type="radio" name="seki_no"
					 value="<%= teacherList.getSeki_no() %> " >
		<%
		}
	 	%>
	</td>
 		<td><%= teacherList.getSeki_no() %>
 		<td><%= teacherList.getName() %>
 		<td><%= teacherList.getMail_address() %>
 		<td><%=  teacherList.getMassage() %>
	</tr>
	<%} %>
 </table>
 	<% session.setAttribute("teacherDate",teacherDate); %>
 	<input type="submit" value="詳細表示">
 	</form>
 	<%
 	}else{
 		out.print("検索に一致する教員が見つかりませんでした");
 		}%>
 </body>
</html>