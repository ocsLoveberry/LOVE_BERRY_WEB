<%@page import="javaBeans.JugyoTable"%>
<%@page import="javaBeans.JikanwariTable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="main.dao.CheckPunchDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<JugyoTable> jugyo = (ArrayList<JugyoTable>) request.getAttribute("jugyo");
	ArrayList<String> seki_no_List = (ArrayList<String>)request.getAttribute("seki_no_List");
	ArrayList<String> name_List = (ArrayList<String>)request.getAttribute("name_List");
	String subjects_name = (String)request.getAttribute("subjects_name");
	int jugyo_count = (int)request.getAttribute("jugyo_count");
	CheckPunchDAO checkPunchDAO = new CheckPunchDAO();
	String[] status = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=subjects_name%></h1>

<table class="attendance_table">
  <tr>
  	<th>学籍番号</th><th>学生氏名</th>
  		<%
  			for(int i=1;i<=jugyo_count;i++){
  				//授業回数分列追加
  				%>
  				<th><%=i %></th>
  				<%
  			}
  		%>
  </tr>
  	<%
  		if(seki_no_List == null){
  			%>
  			 <tr><th>受講学生はいません</th><th>受講学生はいません</th></tr>
  			<%
  		}else{
  			for(int j=0;j<seki_no_List.size();j++){
  				%>
  				<tr>
  					<th><%=seki_no_List.get(j) %></th><th><%=name_List.get(j) %></th>
  					<%
  						for(int i=0;i<jugyo_count;i++){
  							%>
  								<%
  								status = checkPunchDAO.check_punch(seki_no_List.get(j),jugyo.get(i).getSubjects_cd(),jugyo.get(i).getStart_date(),jugyo.get(i).getStart_time_cd());
  								if(status[0] == "nothing"){
  									%>
  									<th>無</th>
  									<%
  								}else if(status[0] == "confirm"){
  									%>
  									<th><%=status[1] %></th>
  									<%
  								}else{
  									%>
  									<th>未確定。ここ背景色変更したい<%=status[1] %></th>
  									<%
  								}
  								%>
  							<%
  						}
  					%>
  				</tr>
  				<%
  			}

  		}
  	%>
</table>
</body>
</html>