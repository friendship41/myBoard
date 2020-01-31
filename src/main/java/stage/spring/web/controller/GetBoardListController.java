package stage.spring.web.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stage.spring.web.board.BoardVO;
import stage.spring.web.board.impl.BoardDAO;

public class GetBoardListController implements Controller
{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		request.setAttribute("boardList", boardList);
		
		return "getBoardList";
	}

}
