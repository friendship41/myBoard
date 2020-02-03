package stage.spring.web.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import stage.spring.web.board.impl.BoardDAO;

@Controller
public class GetBoardListController
{
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) 
	{
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList.jsp");
		
		return mav;
	}

}
