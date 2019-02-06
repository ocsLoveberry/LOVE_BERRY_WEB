<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href='../LOVE_BERRY_WEB/calendar/fullcalendar.min.css' rel='stylesheet' />
<link href='../LOVE_BERRY_WEB/calendar/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<link href='../LOVE_BERRY_WEB/calendar/modal.css' rel='stylesheet'/>
<script src='../LOVE_BERRY_WEB/calendar/lib/moment.min.js'></script>
<script src='../LOVE_BERRY_WEB/calendar/lib/jquery.min.js'></script>
<script src='../LOVE_BERRY_WEB/calendar/fullcalendar.min.js'></script>
<script src='../LOVE_BERRY_WEB/calendar/locale/ja.js'></script>
<script src="../LOVE_BERRY_WEB/calendar/Student_Calendar.js"></script>
<script>
$(document).ready(function(){
	initializePage(<%= request.getRemoteUser()%>);
})
</script>

<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 900px;
    margin: 0 auto;
  }

.fc-sun {
    color: red;
    background-color: #fff0f0;
}

/* 土曜日 */
.fc-sat {
    color: blue;
    background-color: #f0f0ff;
}

</style>
</head>
<body>
<%
	String username = request.getRemoteUser();
	session.setAttribute("seki_no",username);
	%>
	ログインIDは<%= username %><br>
<a href="ShowLogoutServlet">ログアウト</a><br>
  <div id='calendar'></div>
 <div id ="subjectDetail"></div>
 <a href="ShowTopServlet">トップに戻る</a>
</body>
</html>
