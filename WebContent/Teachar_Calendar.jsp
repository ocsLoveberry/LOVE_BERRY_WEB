<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href='calendar/fullcalendar.min.css' rel='stylesheet' />
<link href='calendar/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<link href="modal.css" rel="stylesheet">
<script src='calendar/lib/moment.min.js'></script>
<script src='calendar/lib/jquery.min.js'></script>
<script src='calendar/fullcalendar.min.js'></script>
<script src='calendar/locale/ja.js'></script>
<script src="Teachar_Calendar.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
<script>
$(document).ready(function(){
	initializePage(<%=request.getRemoteUser()%>);
});
</script>

<script type="text/javascript">

</script>

<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}

/* 日曜日 */
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
		session.setAttribute("seki_no", username);
	%>
	ログインIDは<%=username%><br>

	<a href="ShowLogoutServlet">ログアウト</a>
	<div id='calendar'></div>
	<div id="subjectDetail"></div>

	<div class="overlay" id="overlay"></div>
		<div class="modal" id="modal">
			<div class="add_subject">
			<form id="form_add_subject">
			<div class="modal-header" id="modal-header">
				<label>新規科目登録</label>
	  			<button class="modal-close-btn" id="close-btn" value="x"><i class="fa fa-times" title="とじろー！"></i></button>
	  			<hr>
	  		</div>
	  		<div class="modal-body" id="modal-body">
	  			<div class="row">
	  				<!-- @TODO:コンボボックスにします！ -->
	 	 			<label>科目名</label>
	 	 			<select id="input_subject_cd">
	 	 			</select>
	  			</div>
	  			<div class="row">
	  				<label>日付：</label>
	  				<input type="text" id="input_start_date" placeholder="yyyy-mm-dd">
	  			</div>
	  			<div class="row">
	 	 			<label>時限：</label>
	 	 			<select id="input_start_time_cd">
	 	 				<option value="1">1</option>
	 	 				<option value="2">2</option>
	 	 				<option value="3">3</option>
	 	 				<option value="4">4</option>
	 	 				<option value="5">5</option>
	 	 				<option value="6">6</option>
	 	 			</select>
	  			</div>
	  			<div class="row">
	  			 	<div class="roomName">
	  			 		<label>使用教室１：</label>
	  			 		<select id="input_room_cd1">
							<optgroup label="<---1階教室--->"></optgroup>
								<option value="101">101教室</option>
							<optgroup label="<---2階教室--->"></optgroup>
								<option value="201">201教室</option>
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
	  				</div>
	  			</div>
	  			<div class="row">
	  			 	<div class="roomName">
	  			 		<label>使用教室２：</label>
	  			 		<select id="input_room_cd2">
	  			 			<optgroup label="<---不使用--->"></optgroup>
								<option value="" selected="selected">使わない</option>
							<optgroup label="<---1階教室--->"></optgroup>
								<option value="101">101教室</option>
							<optgroup label="<---2階教室--->"></optgroup>
								<option value="201">201教室</option>
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
	  				</div>
	  			</div>
	  			<div class="row">
	  			 	<div class="roomName">
	  			 		<label>使用教室３：</label>
	  			 		<select id="input_room_cd3">
							<optgroup label="<---不使用--->"></optgroup>
								<option value="" selected="selected">使わない</option>
							<optgroup label="><---1階教室--->"></optgroup>
								<option value="101">101教室</option>
							<optgroup label="<---2階教室--->"></optgroup>
								<option value="102">201教室</option>
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
	  				</div>
				</div>
				<div class="row">
					<label>コメント：</label>
					<input type="text" id="input_comment" placeholder="コメントを入力してください">
				</div>
	  		</div>
	  		<!-- end modar-body -->
			<hr>
			<div class="testInput">
			</div>
		  	<div class="moda-footer" id="modal-footer">
		  		<input type="submit" value="登録" name="submit" id="submit">
		  	</div>
		</form>
		</div>
	  <!-- end add-subject  -->
</div>
</body>
</html>
<!--
ajaxで随時カレンダー取得（表示されている期間）
viewRender: function(view) {
	var date = $('#calendar').fullCalendar('getDate');
	$.ajax({

		url: '/path/to';,

		dataType: 'json',

		type:'post',

		data: {

			'date': date.format('Y-M-D')

		},

		success: function(EventSource) {

			calendar.fullCalendar('addEventSource', EventSource);

		},

		error: function(data) {

			// エラーの処理

		}

	});

}

 -->


