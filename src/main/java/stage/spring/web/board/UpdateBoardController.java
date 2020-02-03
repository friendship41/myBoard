package stage.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import stage.spring.web.board.impl.BoardDAO;

@Controller
public class UpdateBoardController
{
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) 
	{
		boardDAO.updateBoard(vo);
		
		return "redirect:getBoard.do?seq="+vo.getSeq();
	}

}
