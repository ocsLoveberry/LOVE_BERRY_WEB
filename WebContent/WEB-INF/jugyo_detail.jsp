<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>授業詳細</title>
</head>
<body>
<form method="post" action="JugyoDetailServlet">
<%HttpSession session = request.getSession(false); %>

<h1>
<%= session.getAttribute("subjects_cd")%><br>
<%= session.getAttribute("subjects_name")%><br>
<%= session.getAttribute("Nitiji")%><br>
<%= session.getAttribute("Jigen")%><br>
<%= session.getAttribute("room_cd1")%><br>
<%= session.getAttribute("room_cd2")%><br>
<%= session.getAttribute("room_cd3")%><br>

</h1>
<button type="submit" name="result" value="revise">修正</button>
<button type="submit" name="result" value="ok">戻る</button>
</form>
</body>
</html>