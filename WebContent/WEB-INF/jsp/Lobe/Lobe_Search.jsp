<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LOBE検索</h1>
<form name="lobeForm" action=ShowLobeSearchResultServlet method="post" target="resultTarget">
<input type="radio" name="classRoomNameOrLobeName" value="checkedClassroom" checked="checked">
教室名：
<select name="classRoomName">
			<optgroup label="<---全教室--->"></optgroup>
			<option value="all">全教室</option>
			<optgroup label="<---1階教室--->"></optgroup>
			<option value="101">101教室</option>
			<optgroup label="<---2階教室--->"></optgroup>
			<option value="102">102教室</option>
			<option value="202">202教室</option>
			<option value="203">203教室</option>
			<option value="204">204教室</option>
			<optgroup label="<---3階教室--->"></optgroup>
			<option value="301">301教室</option>
			<option value="302">302教室</option>
			<option value="303">303教室</option>
			<option value="304">304教室</option>
			<optgroup label="<---4階教室--->"></optgroup>
			<option value="401">401教室</option>
			<option value="402">402教室</option>
			<option value="403">403教室</option>
			<option value="404">404教室</option>
			<optgroup label="<---5階教室--->"></optgroup>
			<option value="501">501教室</option>
			<option value="502">502教室</option>
			<option value="503">503教室</option>
			<option value="504">504教室</option>
			<optgroup label="<---6階教室--->"></optgroup>
			<option value="601">601教室</option>
			<option value="602">602教室</option>
			<option value="603">603教室</option>
			<option value="604">604教室</option>
			</select>
<input type="radio" name="classRoomNameOrLobeName" value="checkedLobeID">
LOBE名：<input type="text" name="lobeName">
<input type="submit" value="検索">
</form>
<form action="ShowLobeNewRegistrationServlet">
<input type="submit" value="新規登録">
</form>
<form action="ShowTopServlet">
<input type="submit" value="トップへ戻る">
<iframe name="resultTarget" width="1000px" height="700px">
</form>

</body>
</html>