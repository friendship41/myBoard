package stage.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import stage.spring.web.board.impl.BoardDAO;

@Controller
public class InsertBoardController
{
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO)
	{
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}

}
