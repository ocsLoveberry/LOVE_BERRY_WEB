<%@page import="javaBeans.lobeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<lobeBean> lobeList = (ArrayList<lobeBean>)request.getAttribute("lobeList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>一覧表示</h1>
<table>
<tr>
<th>リーダID</th>
<th>教室</th>
</tr>
<% for(lobeBean lobe: lobeList) {%>
<tr>
<td><%= lobe.getLOBE_ID() %></td>
<td><%= lobe.getROOM_CD() %></td>
</tr>
<%} %>
</table>
<a href="ShowTopServlet">戻る</a>
</body>
</html>