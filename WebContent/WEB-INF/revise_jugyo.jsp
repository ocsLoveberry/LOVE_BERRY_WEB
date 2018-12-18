<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>授業情報変更</title>
</head>
<body>
<form method="post" action="">
<h1>クラス：<%=session.getAttribute("Class")%></h1>
<h1>現状どこまで変更許すか未定</h1>
<h1>
メモ<br>
room_cdの変更だけなら容易。<br>
日時、時限を変更する場合、tokutei_cdも変わる。<br>
tokutei_cd変更前に該当する授業をもつ全クラスの該当jikanwari削除<br>
該当授業の日時時限+tokutei_cd更新→授業情報に追加して更新？（めんどいｗ）<br>


</h1>
<button type="submit" name="result" value="revise">修正する</button>
<button type="submit" name="result" value="delete">削除</button>
</form>
</body>
</html>