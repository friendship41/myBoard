package stage.spring.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import stage.spring.web.user.impl.UserDAO;

@Controller
public class LoginController
{
	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request, UserVO vo, UserDAO userDAO, ModelAndView mav) 
	{	
		HttpSession session = request.getSession();
		
		UserVO user = userDAO.getUser(vo);
		
		if(user !=null)
		{
			session.setAttribute("id", user.getId());
			mav.setViewName("getBoardList.do");
		}
		else
		{
			mav.setViewName("login.jsp");
		}
		return mav;
	}

}
