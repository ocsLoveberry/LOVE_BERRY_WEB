/**
 *
 */



var default_ymd_format = 'YYYY-MM-DD HH:mm'
var input_subject_ymd_format = 'YYYY-MM-DD'
var seki_no;
var isAddedSubjectList = 0;
var modal_flg = false;
var overLay_flg = false;

function initializePage(input_seki_no) {
	seki_no = input_seki_no;
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
		//selectMinDistance: 1,

		//MonthView
		firstDay: 1,
		defaultDate: '2018-11-01', //getToday(), //下に関数を用意しています
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

//		日付クリック
		dayClick: function (date, allDay, isEvent, view) {
			modalOpen();
//			$('#calendar').css("pointer-events","none");
			console.log(isEvent);
//			重複チェック

			setAddSubjectForms(date);
//			$("#form_add_subject").submit(function(e){
//				dbに挿入する処理はーと
//				addSubjectToDB();
//				submitを更新させない処理
//				return false;
//			})
			$("#submit").click(function(){
				addSubjectToDB();
			})
		},

//		イベントクリック
    	eventClick: function (calEvent, jsEvent, view) {
    		modalOpen();
    		setEditSubjectForms(calEvent)
    		$("#submit").click(function(){
				editSubjectToDB();
			})
		},

		events : 'CalendarView'

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
	},input_seki_no);

	function getToday() {
		var today = new Date();
		var year = today.getFullYear();
		var month = today.getMonth() + 1;
		var day = today.getDate();
		var result = '\'' + year + '-' + month + '-' + day
				+ '\'';
		return result
	};

	function modalOpen(){
		$('#overlay').fadeIn();
		$('#modal').fadeIn();
//		$('#calendar').css("pointer-events","none");
		$('#close-btn').on('click', function(){
			$('#overlay').fadeOut();
			$('#modal').fadeOut();
		});
			$('#overlay').on('click', function(){
			$('#overlay').fadeOut();
			$('#modal').fadeOut();
		});
	};

//	新規科目登録
	function setAddSubjectForms(date){
		$("#input_start_date").val(date.format(input_subject_ymd_format));
		$("#modal-title").text("新規科目登録");
		$("#submit").val("登録");
//		科目名リスト追加済みでないか？
		if(isAddedSubjectList != 1){
			$.ajax("./GetCalenderSubjectListServlet",{
			  		type: 'get',
			  		dataType: 'json',
				})
				.done(
				function(data) {
					for(var i = 0; i < data.length; i++){
//						console.log("data[i].subjects_name"+data[i].subjects_name)
//						console.log("data[i].subjects_cd)"+ data[i].subjects_cd);
						$('#input_subject_cd').append($('<option>').val(data[i].subjects_cd).text(data[i].subjects_name));
					}
//					追加済みフラグtrue
					isAddedSubjectList = 1;
				})
		}
	}

//	科目編集機能
	function setEditSubjectForms(calEvent){
		$("#input_start_date").val(calEvent.start.format(input_subject_ymd_format));
		$("#modal-title").text("科目編集");
		$("#submit").val("変更");
//		科目名リスト追加済みでないか？
		if(isAddedSubjectList != 1){
			$.ajax("./GetCalenderSubjectListServlet",{
			  		type: 'get',
			  		dataType: 'json',
				})
				.done(
				function(data) {
					for(var i = 0; i < data.length; i++){
//						console.log("data[i].subjects_name"+data[i].subjects_name)
//						console.log("data[i].subjects_cd)"+ data[i].subjects_cd);
						$('#input_subject_cd').append($('<option>').val(data[i].subjects_cd).text(data[i].subjects_name));
					}
//					追加済みフラグtrue
					isAddedSubjectList = 1;
				})
			$.ajax("./GetEditCalenderSubjectListServlet",{
			  		type: 'get',
			  		dataType: 'json',
			  		data: {
			  			tokutei_cd : calEvent.id
			  		}
				})
				.done(
				function(data) {
					$("#input_start_time_cd").val(data[0].start_time_cd);
					$("#input_room_cd1").val(data[0].room_cd1);
					$("#input_room_cd2").val(data[0].room_cd2);
					$("#input_room_cd3").val(data[0].room_cd3);
					$("#input_comment").val(data[0].comment);

					isAddedSubjectList = 1;
				})
		}



//		科目名リスト追加済みでないか？
		if(isAddedSubjectList != 1){
			$.ajax("./GetCalenderSubjectListServlet",{
			  		type: 'get',
			  		dataType: 'json',
				})
				.done(
				function(data) {
					for(var i = 0; i < data.length; i++){
//						console.log("data[i].subjects_name"+data[i].subjects_name)
//						console.log("data[i].subjects_cd)"+ data[i].subjects_cd);
						$('#input_subject_cd').append($('<option>').val(data[i].subjects_cd).text(data[i].subjects_name));
					}
//					追加済みフラグtrue
					isAddedSubjectList = 1;
				})
		}
	}

//	submit押された時の処理
	function addSubjectToDB(){
		var input_subject_cd = $('#input_subject_cd').val();
		var input_start_date = $("#input_start_date").val();
		var input_start_time_cd = $("#input_start_time_cd").val();
		var input_room_cd1 = $("#input_room_cd1").val();
		var input_room_cd2 = $("#input_room_cd2").val();
		var input_room_cd3 = $("#input_room_cd3").val();
		var input_comment = $("#input_comment").val();
		alert(input_subject_cd)
	  	$.ajax("./CalendarAddSubjectServlet",{
	  		type: 'get',
	  		data:{
	  			subject_cd: input_subject_cd,
	  			start_date: input_start_date,
	  			start_time_cd: input_start_time_cd,
	  			room_cd1: input_room_cd1,
	  			room_cd2: input_room_cd2,
	  			room_cd3: input_room_cd3,
	  			comment: input_comment
			}
		}).done(function(data){
			$("#testDiv").html(data);
			alert("科目を登録しました");
		})
	}

	function editSubjectToDB(){
		var input_subject_cd = $('#input_subject_cd').val();
		var input_start_date = $("#input_start_date").val();
		var input_start_time_cd = $("#input_start_time_cd").val();
		var input_room_cd1 = $("#input_room_cd1").val();
		var input_room_cd2 = $("#input_room_cd2").val();
		var input_room_cd3 = $("#input_room_cd3").val();
		var input_comment = $("#input_comment").val();
		alert(input_subject_cd)
//		jugyoTBL書き換え
	  	$.ajax("./CalendarEditSubjectServlet",{
	  		type: 'get',
	  		data:{
	  			subject_cd: input_subject_cd,
	  			start_date: input_start_date,
	  			start_time_cd: input_start_time_cd,
	  			room_cd1: input_room_cd1,
	  			room_cd2: input_room_cd2,
	  			room_cd3: input_room_cd3,
	  			comment: input_comment
			}
		}).done(function(data){
			$("#testDiv").html(data);
			alert("科目内容を変更しました");
		})

	}
}
