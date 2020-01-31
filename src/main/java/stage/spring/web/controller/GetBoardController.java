package stage.spring.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.spring.web.board.BoardVO;
import stage.spring.web.board.impl.BoardDAO;

public class GetBoardController implements Controller
{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) 
	{
		int seq = Integer.parseInt(request.getParameter("seq"));

		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		request.setAttribute("board", board);
		return "getBoard";
	}

}
