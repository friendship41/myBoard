package stage.spring.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import stage.spring.web.user.impl.UserDAO;

public class LoginController implements Controller
{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		ModelAndView mav = new ModelAndView();
		if(user !=null)
		{
			session.setAttribute("id", id);
			mav.setViewName("redirect:getBoardList.do");
		}
		else
		{
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}

}
