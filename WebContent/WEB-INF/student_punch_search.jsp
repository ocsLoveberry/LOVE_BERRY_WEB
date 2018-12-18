<!-- @author ace -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Allerta+Stencil"
	rel="stylesheet">
<link rel="stylesheet" href="stu_punch_search.css">
<title>打刻検索画面</title>

</head>
<body>
	<!-- ヘッダー -->
	<header>
		<div class="id">
			<div id="header">
				<h1 class="LB">
					<a href="stu_top.html">Love&Berry</a>
				</h1>
				<!-- リンク -->
				<div class="link">
					<a href="javascript:history.back();">戻る</a>
					<a href="showLogoutServlet">ログアウト</a>
				</div>
				<p></p>
			</div>
		</div>
	</header>

	<div id="main">
		<form id="date" class="date" action="StudentPunchSearchResultServlet" method="post">

			日付：<input type="date" name="formEntryDate">
			 教室：
			<select name="formClassroom">
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
			<p><input type="submit" id="kensaku_button" value="打刻検索！"></p>
		</form>
	</div>
</body>
</html>