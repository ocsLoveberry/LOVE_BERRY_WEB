<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生検索</title>
</head>
<body>
<b>学生検索</b><br>
<form action="ShowStudentSearchResultServlet" target="example">
<input type="radio" name="radio_Name_or_SekiNo" value="select_Name" checked>
氏名
<input type="text" name="text_Student_name" maxlength="6">
<input type="radio" name="radio_Name_or_SekiNo" value="select_sekiNo">
学籍番号
<input type="text" name="text_Student_SekiNo" maxlength="6"><br>
<input type="submit" value="検索">
</form>
<iframe name="example" width="1000px" height="700px">

</iframe>
</body>
</html>