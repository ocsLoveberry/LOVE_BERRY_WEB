<%@page import="java.util.ArrayList"%>
<%@page import="javaBeans.JugyoTable"%>
<%@page import="javaBeans.OcsJohoData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
ArrayList<JugyoTable> jugyo = (ArrayList<JugyoTable>) request.getAttribute("jugyo");
ArrayList<String> seki_no_List = (ArrayList<String>) request.getAttribute("seki_no_List");
ArrayList<String> name_List = (ArrayList<String>) request.getAttribute("name_List");
ArrayList<String> comment_List = (ArrayList<String>) request.getAttribute("comment_List");
String subjects_name = (String)request.getAttribute("subjects_name");
int jugyo_count = (int)request.getAttribute("jugyo_count");
int jugyo_no = (int)request.getAttribute("jugyo_no");
String temp_status[] = (String[])request.getAttribute("temp_status");
String status[] = (String[])request.getAttribute("status");
String subjects_cd = jugyo.get(0).getSubjects_cd();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ConfirmStatusJugyoServlet">
	<table class=attendance>
		<tr>
			<th>教員名</th><th>要教員名取得</th><th>全授業回数</th><th><%=jugyo_count %>回</th>
		</tr>
		<tr>
			<th>学籍番号</th><th>氏名</th><th>出欠判定</th><th>打刻出欠</th><th>コメント</th>
		</tr>
		<%
			for(int i=0;i<seki_no_List.size();i++){
				%>
				<tr>
				<th><%=seki_no_List.get(i) %></th><th><%=name_List.get(i) %></th>
				<th>
					<select class="status" name="status<%=i %>">
					<%if(status[i].equals("◯")){
						%><option value="◯" selected>◯</option><%
					}else{
						%><option value="◯">◯</option><%
					}
					%>
					<%if(status[i].equals("☓")){
						%><option value="☓" selected>☓</option><%
					}else{
						%><option value="☓">☓</option><%
					}
					%>
					<%if(status[i].equals("△")){
						%><option value="△" selected>△</option><%
					}else{
						%><option value="△">△</option><%
					}
					%>
					</select>
	        	</th>
	        	<th><%=temp_status[i] %></th>
				</tr>
				<%
			}
		%>
	</table>
	<%
		for(int j=0;j<seki_no_List.size();j++){
			%>
			<input type='hidden' name="seki_no[<%=j %>]" value=<%=seki_no_List.get(j) %>>
			<%
		}
	%>
	<input type='hidden' name="count" value=<%=seki_no_List.size() %>>
	<input type='hidden' name="subjects_cd" value=<%=subjects_cd %>>
	<input type='hidden' name="jugyo_no" value=<%=jugyo_no %>>
	<input type='submit' name="ConfirmStatusServletbtn" value='確定'>
</form>
<h2>◯：出席、☓：欠席、△：遅刻</h2>
</body>
</html>