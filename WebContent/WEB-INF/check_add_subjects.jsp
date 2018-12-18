<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認ページ</title>
</head>
<body>
<form method="post" action="AddJugyoServlet">
<h1>これで問題ないですか？</h1>
<%
	HttpSession session = request.getSession(false);
	session = request.getSession(false);
%>
<h1>授業日：<%=session.getAttribute("Nitiji")%></h1>
<h1>時限：<%=session.getAttribute("Jigen")%></h1>
<h1>クラス：<%=session.getAttribute("Class")%></h1>
<h1>授業名：<%=session.getAttribute("subjects_name") %></h1>
<h1>教室
<%
if(session.getAttribute("room_cd1")!=null){
%>
	:<%=session.getAttribute("room_cd1")%>
<%
}
%>
<%
if(session.getAttribute("room_cd2")!=null){
%>
	:<%=session.getAttribute("room_cd2")%>
<%
}
%>
<%
if(session.getAttribute("room_cd3")!=null){
%>
	:<%=session.getAttribute("room_cd3")%>
<%
}
%>
</h1>
<button type="submit" name="result" value="revise">修正</button>
<button type="submit" name="result" value="regist">登録</button>
</form>
</body>
</html>