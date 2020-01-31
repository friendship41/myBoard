package stage.spring.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stage.spring.web.board.BoardVO;
import stage.spring.web.board.impl.BoardDAO;
import stage.spring.web.user.UserVO;
import stage.spring.web.user.impl.UserDAO;

@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		processRequest(request, response);
	}
	
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(path);
		
		if(path.equals("login.do"))
		{
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
				response.sendRedirect("getBoardList.do");
			}
			else
			{
				response.sendRedirect("login.jsp");
			}
		}
		else if(path.equals("logout.do"))
		{
			session.invalidate();
			response.sendRedirect("login.do");
		}
		else if(path.equals("insertBoard.do"))
		{
			BoardVO vo = new BoardVO();
			vo.setTitle(request.getParameter("title"));
			vo.setWriter(request.getParameter("writer"));
			vo.setContent(request.getParameter("content"));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			response.sendRedirect("getBoardList.do");
		}
		else if(path.equals("updateBoard.do"))
		{
			int seq = Integer.parseInt(request.getParameter("seq"));

			BoardVO vo = new BoardVO();
			vo.setSeq(seq);
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			response.sendRedirect("getBoard.do?seq="+seq);
		}
		else if(path.equals("deleteBoard.do"))
		{
			BoardVO boardVO = new BoardVO();
			boardVO.setSeq(Integer.parseInt(request.getParameter("seq")));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(boardVO);
			
			response.sendRedirect("getBoardList.do");
		}
		else if(path.equals("getBoard.do"))
		{
			int seq = Integer.parseInt(request.getParameter("seq"));

			BoardVO vo = new BoardVO();
			vo.setSeq(seq);
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			request.setAttribute("board", board);
			RequestDispatcher disp = request.getRequestDispatcher("getBoard.jsp");
			disp.forward(request, response);
		}
		else if(path.equals("getBoardList.do"))
		{
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			request.setAttribute("boardList", boardList);
			RequestDispatcher disp = request.getRequestDispatcher("getBoardList.jsp");
			disp.forward(request, response);
		}
	}

}
