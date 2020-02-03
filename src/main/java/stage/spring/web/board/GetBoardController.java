package stage.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import stage.spring.web.board.impl.BoardDAO;

@Controller
public class GetBoardController
{
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) 
	{
		BoardVO board = boardDAO.getBoard(vo);

		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}

}
