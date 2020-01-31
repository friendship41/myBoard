package stage.spring.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.spring.web.board.BoardVO;
import stage.spring.web.board.impl.BoardDAO;

public class DeleteBoardController implements Controller
{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) 
	{
		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(Integer.parseInt(request.getParameter("seq")));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(boardVO);
		
		return "getBoardList.do";
	}

}
