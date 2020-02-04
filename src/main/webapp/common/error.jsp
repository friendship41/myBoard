<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
<h1>에러페이지</h1>
<hr>
<table border="1">
	<tr>
		<td>기본 에러 화면 입니다</td>
	</tr>
</table>
<br><br>
<table border="1">
	<tr>
		<td>메세지</td>
		<td>${requestScope.exception}</td>
	</tr>
</table>
<br><br>
<a href="javascript:history.back()">뒤로가기</a>
</body>
</html>