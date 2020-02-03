package stage.spring.web.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import stage.spring.web.board.impl.BoardDAO;

@Controller
public class DeleteBoardController
{
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) 
	{
		boardDAO.deleteBoard(vo);
		
		return "getBoardList.do";
	}

}
