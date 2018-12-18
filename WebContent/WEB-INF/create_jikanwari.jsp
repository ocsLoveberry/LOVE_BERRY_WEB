<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOVE BERRY</title>
</head>
<body>
<h1>時間割</h1>
<h1>担任クラス数<%= request.getAttribute("CountClass") %></h1>
<% for(int i = Integer.parseInt(request.getAttribute("CountClass").toString()); i>0 ; i--){	%>
<h1>作成する時間割を繰り返し</h1><br>
<table>
<tr>
<td>/</td>
<td>1</td>
<td>2</td>
</tr>
<tr>
<td>1</td>
<td><input type="button" value="アラート" onclick="alert('本当はここ押したら、日時,時限をsetして次のServletに遷移したい')"></td>
<td><input type="button" value="アラート" onclick="alert('行:'+this.parentNode.parentNode.rowIndex+'///列:'+this.parentNode.cellIndex)"></td>
</tr>
<tr>
<td>2</td>
<td><input type="button" value="アラート" onclick="alert('行:'+this.parentNode.parentNode.rowIndex+'///列:'+this.parentNode.cellIndex)"></td>
<td><input type="button" value="アラート" onclick="alert('行:'+this.parentNode.parentNode.rowIndex+'///列:'+this.parentNode.cellIndex)"></td>
</tr>
</table>
<% } %>
<a href="ShowLogoutServlet">ログアウト</a>
</body>
</html>