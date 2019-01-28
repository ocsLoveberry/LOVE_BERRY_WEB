<%@ page import ="java.sql.*"
	import="main.dao.SearchClassSubjcetsDAO"
	import="main.dao.Subjects_cd_TO_nameDAO"
	import="main.dao.RoomListDAO"
	import="java.util.ArrayList"
	import="java.util.Collections"
	language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>授業情報変更</title>
</head>
<body>
<form method="post" action="ReviseJugyoServlet">
<%HttpSession session = request.getSession(false); %>
<h1>クラス：<%=session.getAttribute("Class") %></h1>
<h1>授業名：<%=session.getAttribute("subjects_name") %></h1>
<h1>-------------------------------</h1>
<h1>現状</h1>
<h1><%=session.getAttribute("Nitiji") %><br><%=session.getAttribute("Jigen") %>限</h1>
<h1>教室（３つまで）（空欄=未設定）</h1>
<h1>
<%
String room_cd1 = (String)session.getAttribute("room_cd1");
String room_cd2 = (String)session.getAttribute("room_cd2");
String room_cd3 = (String)session.getAttribute("room_cd3");
if(room_cd1 == null){
	%>
	[]
	<%
}else{
	%>
	[<%=room_cd1%>]
	<%
}
if(room_cd2 == null){
	%>
	[]
	<%
}else{
	%>
	[<%=room_cd2%>]
	<%
}
if(room_cd3 == null){
	%>
	[]
	<%
}else{
	%>
	[<%=room_cd3%>]
	<%
}
%>
</h1>

<h1>-------------------------------</h1>
<h1>変更したい箇所</h1>
<h1>
日付<input type="date" name="calendar" min="0000-01-01" max="9999-12-31" value="<%=session.getAttribute("Nitiji") %>">
：時限<select name="jigen">
<%
ArrayList<String> jigenList = new ArrayList<String>();
for (String item : new String[]{"1", "2", "3", "4", "5"}) {
    jigenList.add(item);
}
String remove_jigen = (String)session.getAttribute("Jigen");
jigenList.remove(jigenList.indexOf(remove_jigen));
%>
<option value="<%=remove_jigen %>" selected><%=remove_jigen %>（初期値）</option>
<%
for(int i=0; i<jigenList.size();i++){
%>
	<option value="<%= jigenList.get(i) %>"><%= jigenList.get(i) %></option>
<%
}
%>
</select>
<br>
<%
ArrayList<String> room_cd = new ArrayList<String>();
ArrayList<String> room_name = new ArrayList<String>();
RoomListDAO rlDAO = new RoomListDAO();
room_cd = rlDAO.list();
room_name = rlDAO.to_name(room_cd);
ArrayList<String> remove_room_cd = new ArrayList<String>();
Collections.addAll(remove_room_cd,room_cd1,room_cd2,room_cd3);
room_cd.removeAll(remove_room_cd);
room_name = rlDAO.to_name(room_cd);
%>
<select name="room_cd1">
<%
if(room_cd1 == null){
	%>
	<option value="nothing" selected>---（初期値）</option>
	<%
}else{
	%>
	<option value="<%=room_cd1%>" selected><%=room_cd1%>（初期値）</option>
	<option value="nothing">---（削除）</option>
	<%
}
for(int i=0; i<room_cd.size();i++){
%>
	<option value="<%= room_cd.get(i) %>"><%= room_name.get(i) %></option>
<%
}
%>
</select>

<select name="room_cd2">
<%
if(room_cd2 == null){
	%>
	<option value="nothing" selected>---（初期値）</option>
	<%
}else{
	%>
	<option value="<%=room_cd2%>" selected><%=room_cd2%>（初期値）</option>
	<option value="nothing">---（削除）</option>
	<%
}
for(int i=0; i<room_cd.size();i++){
%>
	<option value="<%= room_cd.get(i) %>"><%= room_name.get(i) %></option>
<%
}
%>
</select>

<select name="room_cd3">
<%
if(room_cd3 == null){
	%>
	<option value="nothing" selected>---（初期値）</option>
	<%
}else{
	%>
	<option value="<%=room_cd3%>" selected><%=room_cd3%>（初期値）</option>
	<option value="nothing">---（削除）</option>
	<%
}
for(int i=0; i<room_cd.size();i++){
%>
	<option value="<%= room_cd.get(i) %>"><%= room_name.get(i) %></option>
<%
}
%>
</select>

</h1>
<button type="submit" name="result" value="revise">修正する</button>
<button type="submit" name="result" value="delete">削除</button>
<button type="submit" name="result" value="back">戻る</button>
</form>
</body>
</html>