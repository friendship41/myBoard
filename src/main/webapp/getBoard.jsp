<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="stage.spring.web.board.BoardVO" %>
<%
	BoardVO board = (BoardVO) request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=board.getTitle()%></title>
</head>
<body>
<h1>글 상세</h1>
<a href="logout.do">로그아웃</a>
<hr>
<form action="updateBoard.do" method="post">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="<%=board.getTitle()%>"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=board.getWriter()%></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content"><%=board.getContent()%></textarea></td>
		</tr>
		<tr>
			<td>등록일</td>
			<td><%=board.getRegDate()%></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td><%=board.getCnt()%></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="글수정"></td>
		</tr>
	</table>
	<input type="hidden" name="seq" value="<%=board.getSeq()%>">
</form>
<hr>
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=<%=board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글목록</a>
</body>
</html>