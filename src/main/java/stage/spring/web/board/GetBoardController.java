package stage.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import stage.spring.web.board.impl.BoardDAO;

public class GetBoardController implements Controller
{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
	{
		int seq = Integer.parseInt(request.getParameter("seq"));

		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}

}
