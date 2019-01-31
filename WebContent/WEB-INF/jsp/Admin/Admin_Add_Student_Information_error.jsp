<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
@TODO:学籍番号がかぶったときにエラーを表示させる処理
<jsp:forward page="regis.jsp">
    <jsp:param name="error_SQLIntegrityConstraintViolationException" value="true" />
</jsp:forward>
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
問題が発生しました。もう一度やり直してください。<br>
<a href="ShowAddStudentInformationServlet">戻る</a>

</body>
</html>