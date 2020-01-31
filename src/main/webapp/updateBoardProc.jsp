<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="stage.spring.web.board.BoardVO"%>
<%@ page import="stage.spring.web.board.impl.BoardDAO"%>
<%
	request.setCharacterEncoding("utf-8");

	int seq = Integer.parseInt(request.getParameter("seq"));

	BoardVO vo = new BoardVO();
	vo.setSeq(seq);
	vo.setTitle(request.getParameter("title"));
	vo.setContent(request.getParameter("content"));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.updateBoard(vo);
	
	response.sendRedirect("getBoard.jsp?seq="+seq);
%>