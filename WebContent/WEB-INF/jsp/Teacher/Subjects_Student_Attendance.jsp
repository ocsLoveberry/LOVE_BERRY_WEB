<%@page import="java.util.ArrayList"%>
<%@page import="javaBeans.JugyoTable"%>
<%@page import="javaBeans.OcsJohoData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
ArrayList<JugyoTable> jugyo = (ArrayList<JugyoTable>) request.getAttribute("jugyo");
ArrayList<OcsJohoData> ocsJohoData = (ArrayList<OcsJohoData>) request.getAttribute("ocsJohoData");
String subjects_name = (String)request.getAttribute("subjects_name");
int jugyo_count = (int)request.getAttribute("jugyo_count");
String temp_status[] = (String[])request.getAttribute("temp_status");
String status[] = (String[])request.getAttribute("status");
String seki_no = ocsJohoData.get(0).getSeki_no();
String subjects_cd = jugyo.get(0).getSubjects_cd();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>特定授業、特定生徒（テスト行）</h1>
<table class="student">
	<tr>
		<th>学籍番号</th><th>学生氏名</th><th>呼び出しメッセージ</th>
	</tr>
	<tr>
		<th><%=ocsJohoData.get(0).getSeki_no() %></th><th><%=ocsJohoData.get(0).getName() %></th><th><%=ocsJohoData.get(0).getMessage() %></th>
	</tr>
</table>
<form action="ConfirmStatusServlet">
	<table class=attendance>
		<tr>
			<th>回数</th><th>日付</th><th>時限</th><th>出欠判定</th><th>打刻出欠</th>
		</tr>
		<%
			for(int i=0;i<jugyo_count;i++){
				%>
				<tr>
				<!-- 回数、日付、時限、出欠判定、打刻出欠の順 -->
				<th><%=i+1 %></th>
				<th><%=jugyo.get(i).getStart_date() %></th>
				<th><%=jugyo.get(i).getStart_time_cd() %>限</th>
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
	<h2>◯：出席、☓：欠席、△：遅刻</h2>
	<input type='hidden' name="seki_no" value=<%=seki_no %>>
	<input type='hidden' name="subjects_cd" value=<%=subjects_cd %>>
	<input type='hidden' name="jugyo_count" value=<%=jugyo_count %>>
	<input type='submit' name="ConfirmStatusServletbtn" value='確定'>
</form>
</body>
</html>