<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href='calendar/fullcalendar.min.css' rel='stylesheet' />
<link href='calendar/fullcalendar.print.min.css' rel='stylesheet' media='print' />

<script src='calendar/lib/moment.min.js'></script>
<script src='calendar/lib/jquery.min.js'></script>
<script src='calendar/fullcalendar.min.js'></script>
<script src='calendar/locale/ja.js'></script>


<script>


var default_ymd_format = 'YYYY-MM-DD HH:mm'
  $(document).ready(function() {
    $('#calendar').fullCalendar({

	  //Toolbar
      header: {
    	 // fullcalendarのヘッダーに配置するボタン
         // 左側には「前月、翌月、今日」のボタン
         // 中央には表示している月
         // 右側には月表示、週表示、日表示、月予定
         left: 'prev,next today',
         center: 'title',
         right: 'month,agendaWeek,agendaDay'
      },
      //Option
      editable: true,			// 編集可能設定
      selectable: true,			// カレンダー空白部分のドラッグ可能
      selectHelper: true,		// これをtrueにすると範囲設定できます
      defaultView: 'month',		//初期ビュー
//    selectMinDistance: 1,
      //Theme

      //Sizing

      //MonthView
      firstDay: 1,
      defaultDate: '2018-12-01', //getToday(), //下に関数を用意しています
      eventLimit: true, // allow "more" link when too many events
      eventDurationEditable: true,
      timeFormat: 'HH:mm',

      //AgendaView
      minTime: '09:15:00',
      maxTime: '18:30:00',
      slotDuration: '00:15:00',
      slotLabelInterval: '00:15:00',
      slotLabelFormat: [
    	  'HH:mm'

      ],

      eventClick: function(calEvent, jsEvent, view) {
  	  	$('#title').val(calEvent.title);
	  	$('#start').val(calEvent.start.format(default_ymd_format));
	  	$('#end').val(calEvent.end.format(default_ymd_format));
	  	$.ajax("./CalendarDetailServlet",{
	  		type: 'get',
	  		dataType: 'json',
	  		data:{
	  			seki_no : "<%= request.getRemoteUser()%>",
	  			subjectID : calEvent.title,
	  			start : calEvent.start.format(default_ymd_format),
	  			end : calEvent.end.format(default_ymd_format)
	  		}
	  	}).done(function(data){
	  		console.log(data);
	  		/* ここで科目詳細のデータを生成しています */
	  		var result = "科目名："+ data[0].subject_cd +"<br>" + "出席日数："+ data[0].count +"<br>" + "開始時刻："+ data[0].start +"<br>" + "終了時刻："+ data[0].end +"<br>"
	  		$("#subjectDetail").html(result);
	  	})


      },

      events: 'CalendarView'

      /* eventClickのメソッドについて
       *
       * 学生と先生の場合で処理を分ける
       *
       * 学生の場合
       * イベントをクリックしたら
       * 	クリックした日付の詳細画面へ遷移させる
       * 空白をクリックしたら
       *	何もしない
       *
       * 先生の場合
       * イベントをクリックしたら
       *	確認・変更画面に遷移
       * 空白をクリックしたら
       *	科目登録画面に遷移
       *
       * TODO:(先生)科目確認画面を作る
       * TODO:(先生)を作る
      */
    });
    function getToday(){
		var today = new Date();
     	var year = today.getFullYear();
     	var month = today.getMonth()+1;
      	var day = today.getDate();
      	var result = '\'' + year + '-' + month + '-' + day + '\'';
      	return result
      }
  });
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
	session.setAttribute("seki_no",username);
	%>
	ログインIDは<%= username %><br>

  <div id='calendar'></div>
 <button>Submit</button>
 <div id ="subjectDetail"></div>
 <a href="ShowLogoutServlet">ログアウト</a>
</body>
</html>
