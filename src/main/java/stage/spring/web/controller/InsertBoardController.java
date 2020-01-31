package stage.spring.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.spring.web.board.BoardVO;
import stage.spring.web.board.impl.BoardDAO;

public class InsertBoardController implements Controller
{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) 
	{
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}

}
