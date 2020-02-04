<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<h1>회원제 게시판</h1>
<h3>${id.name}님 환영합니다 &nbsp;&nbsp;<a href="logout.do">로그아웃</a></h3>
<hr>
<!-- 검색 시작 -->
<form action="getBoardList.do" method="post">
	<table border="1">
		<tr>
			<td>
				<select name="searchCondition">
					<c:forEach var="condition" items="${conditionMap}">
						<option value="${condition.value}">${condition.key}</option>
					</c:forEach>
				</select>
				<input type="text" name="searchKeyword" required="required"/>
				<input type="submit" value="검색"/>
			</td>
		</tr>
	</table>
</form>
<br>
<!-- 검색 종료 -->
<table border="1">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="board" items="${boardList}">
		<tr>
			<td>${board.seq}</td>
			<td><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
			<td>${board.writer}</td>
			<td>${board.regDate}</td>
			<td>${board.cnt}</td>
		</tr>
	</c:forEach>
</table>
<hr>
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
</body>
</html>