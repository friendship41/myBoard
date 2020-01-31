<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="stage.spring.web.user.UserVO" %>
<%@ page import="stage.spring.web.user.impl.UserDAO" %>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	if(user !=null)
	{
		session.setAttribute("id", id);
		response.sendRedirect("getBoardList.jsp");
	}
	else
	{
		response.sendRedirect("login.jsp");
	}
%>