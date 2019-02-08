<!--
管理者が学生検索ページに遷移して学生の検索結果を押した後に
遷移してくるページ
このページからの遷移先はShowStundetDetailServlet 学生詳細画面
ShowStudentSearchServlet から遷移してくる
  -->
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="javaBeans.OcsJohoData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/LOVE_BERRY_WEB/css/table_Result.css">

<title>Insert title here</title>
</head>
<body>
	<br>
<% ArrayList<OcsJohoData> studentData = (ArrayList<OcsJohoData>)request.getAttribute("studentData");
	if(!studentData.isEmpty()) {
	%>
	<form action="ShowStudentDetailServlet" method="post">
		<table>
			<tr class="sub">
				<th></th>
				<th>学籍番号</th>
				<th>氏名</th>
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