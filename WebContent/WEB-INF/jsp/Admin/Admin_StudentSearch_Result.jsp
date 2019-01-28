<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="javaBeans.OcsJohoData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% ArrayList<OcsJohoData> studentData = (ArrayList<OcsJohoData>)request.getAttribute("studentData"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
	<br>
	<% if(!studentData.isEmpty()){ %>
	<form action="showStudentDetailServlet" method="post">
		<table>
			<tr>
				<th></th>
				<th>学籍番号</th>
				<th>名前</th>
				<th>コメント</th>
			</tr>
			<%
				boolean isFirst = true;
			 %>
			<% for(OcsJohoData student: studentData){ %>
				<tr>
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
					<td>
					 	<%= student.getSeki_no() %>
					</td>
					<td>
						<%= student.getName() %>
					</td>
					<td>
						<%= student.getComment() %>
					</td>
				</tr>
			<%} %>
		</table>
		<input type="submit" value="詳細表示">
	</form>
		<%
		 }else{
			out.println("検索に一致する生徒が見つかりませんでした");
		}%>

</body>
</html>