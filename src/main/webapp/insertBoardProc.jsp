<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="stage.spring.web.board.BoardVO"%>
<%@ page import="stage.spring.web.board.impl.BoardDAO"%>
<%
	request.setCharacterEncoding("utf-8");

	BoardVO vo = new BoardVO();
	vo.setTitle(request.getParameter("title"));
	vo.setWriter(request.getParameter("writer"));
	vo.setContent(request.getParameter("content"));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.insertBoard(vo);
	
	response.sendRedirect("getBoardList.jsp");
%>