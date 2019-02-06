<%@page import="javaBeans.ClassSubjects"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<ClassSubjects> classSubject = (ArrayList<ClassSubjects>) request.getAttribute("classSubject");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/LOVE_BERRY_WEB/css/Teacher_Sub_List.css">
<title>科目一覧画面</title>
</head>
<body>
	<div id="main">
		<h2>科目名</h2>
		<form action="ShowTeacherSubjectDetailServlet" method="post"
			name="sort_form">
			<select name="hoge"
				onchange="dropsort((outputSelectedValueAndText(this)))">
				<option selected="selected" disabled="disabled" class="opt">科目を選択してください</option>
				<%
					for (ClassSubjects csView : classSubject) {
				%>


				<option
					value="ShowTeacherSubjectDetailServlet?Subjects_cd=<%=csView.getSubjects_cd()%>"
					target="subjectDetail" class="opt"><%=csView.getSubjects_cd()%>
				</option>
				<%
					}
				%>
			</select>
		</form>

		<iframe name="subjectDetail" width="900px" height="700px" id="frame"></iframe>
		<br>
		<div id="yazi">
			<form action="ShowTopServlet">
				<input type="submit" value="トップに戻る" id="back">
			</form>
		</div>
	</div>
	<script>
		function dropsort(B) {
			var browser = document.sort_form.hoge.value;
			document.getElementById('frame').contentWindow.location.replace(B);
			//alert(B);
		}
		function outputSelectedValueAndText(obj) {
			/*
			 * obj は select タグであり、selectedIndex プロパティには
			 * 変更後の選択項目のインデックスが格納されています
			 */
			var idx = obj.selectedIndex;
			var value = obj.options[idx].value; // 値

			// 値とテキストをコンソールに出力
			//console.log('value = ' + value + ', ' + 'text = ' + text);
			//alert(value);
			/*
			 * 出力例）選択肢２に変更された場合
			 * ----------------------------------------------
			 * value = 値2, text = 選択肢２
			 */
			return value;
		}
	</script>
</body>
</html>