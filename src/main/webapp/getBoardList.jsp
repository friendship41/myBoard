<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="stage.spring.web.board.BoardVO" %>
<%@ page import="stage.spring.web.board.impl.BoardDAO" %>
<%@ page import="java.util.List" %>
<%
	List<BoardVO> boardList = (List<BoardVO>) request.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<h1>회원제 게시판</h1>
<h3>테스트 회원님 환영합니다. <a href="logout.do">로그아웃</a></h3>
<hr>
<!-- 검색 시작 -->
<form action="getBoardList.do" method="post">
	<table border="1">
		<tr>
			<td>
				<select name="searchCondition">
					<option value="TITLE">제목</option>
					<option value="CONTENT">내용</option>
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
	<% 
	for(BoardVO board : boardList)
	{%>
		<tr>
			<td><%=board.getSeq()%></td>
			<td><a href="getBoard.do?seq=<%=board.getSeq()%>"><%=board.getTitle()%></a></td>
			<td><%=board.getWriter()%></td>
			<td><%=board.getRegDate()%></td>
			<td><%=board.getCnt()%></td>
		</tr>
	<%
	}%>
</table>
<hr>
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
</body>
</html>