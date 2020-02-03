package stage.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import stage.spring.web.board.impl.BoardDAO;

public class InsertBoardController implements Controller
{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
	{
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}

}
