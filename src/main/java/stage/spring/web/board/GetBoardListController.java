package stage.spring.web.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import stage.spring.web.board.impl.BoardDAO;

public class GetBoardListController implements Controller
{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList.jsp");
		
		return mav;
	}

}
