<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="stage.spring.web.board.BoardVO"%>
<%@ page import="stage.spring.web.board.impl.BoardDAO"%>
<%
	BoardVO boardVO = new BoardVO();
	boardVO.setSeq(Integer.parseInt(request.getParameter("seq")));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.deleteBoard(boardVO);
	
	response.sendRedirect("getBoardList.jsp");
%>