package stage.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import stage.spring.web.board.impl.BoardDAO;

public class DeleteBoardController implements Controller
{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
	{
		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(Integer.parseInt(request.getParameter("seq")));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(boardVO);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}

}
