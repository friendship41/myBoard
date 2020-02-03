package stage.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import stage.spring.web.board.impl.BoardDAO;

public class UpdateBoardController implements Controller
{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
	{
		int seq = Integer.parseInt(request.getParameter("seq"));

		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoard.do?seq="+seq);
		
		return mav;
	}

}
