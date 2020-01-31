package stage.spring.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.spring.web.board.BoardVO;
import stage.spring.web.board.impl.BoardDAO;

public class UpdateBoardController implements Controller
{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) 
	{
		int seq = Integer.parseInt(request.getParameter("seq"));

		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		return "getBoard.do?seq="+seq;
	}

}
