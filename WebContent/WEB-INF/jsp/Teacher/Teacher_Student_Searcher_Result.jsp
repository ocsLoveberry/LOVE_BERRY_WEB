<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="javaBeans.OcsJohoData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE htnl>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/LOVE_BERRY_WEB/css/table_Result.css">

<title>学生検索Page(Teacher_Student_Search.jsp)</title>
</head>
<body>
	<br>
<% ArrayList<OcsJohoData> studentData = (ArrayList<OcsJohoData>)request.getAttribute("studentData");
	if(studentData != null || studentData.size() != 0 ) {
	%>
	<form action="ShowStudentDetailServlet" method="post">
		<table>
			<tr class="sub">
				<th></th>
				<th>学籍番号</th>
				<th>名前</th>
				<th>コメント</th>
			</tr>
			<%
				boolean isFirst = true;
			 %>
			<% for(OcsJohoData student: studentData){ %>
				<tr id="res">
					<td>
						<%if(isFirst){ %>
							<input type="radio" name="seki_no" value="<%= student.getSeki_no() %> " checked>
						<%
							isFirst = false;
						}else{
						%>
							<input type="radio" name="seki_no" value="<%= student.getSeki_no() %> " >
						<%
						}
					 	%>
					</td>
					<td id="num">
					 	<%= student.getSeki_no() %>
					</td>
					<td class="sub">
						<%= student.getName() %>
					</td>
					<td id="come">
						<%= student.getMessage() %>
					</td>
				</tr>
			<%}session.setAttribute("studentlist", studentData);%>
		</table>
<%-- 	<%session.setAttribute("studentDate", studentData); %> --%>
		<input type="submit" value="詳細表示">
	</form>
		<%
		 }else{
			out.println("検索に一致する生徒が見つかりませんでした");
		}%>
</body>
</html>