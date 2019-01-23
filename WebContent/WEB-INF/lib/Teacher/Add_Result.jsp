<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>科目追加結果</title>
</head>
<body>
<%
String add_count = request.getAttribute("add_count").toString();
if(add_count.equals("0")){
%>
	<h1>何も追加されませんでした。</h1>
<%
}else{
%>
	<h1><%=request.getAttribute("add_count")%>件</h1><br>
	<h1><%=request.getAttribute("subjects_name")%>が追加されました。</h1>

<%
}
%>
<p><a href="ShowTopServlet">トップへ</a>
</body>
</html>