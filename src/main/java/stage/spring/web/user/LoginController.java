package stage.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stage.spring.web.user.impl.UserDAO;

@Controller
public class LoginController
{
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(UserVO vo)
	{
		return "login.jsp";
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpSession session, UserVO vo, UserDAO userDAO, Model model) 
	{
		UserVO user = userDAO.getUser(vo);
		if(user !=null)
		{
			session.setAttribute("id", user);
			return "getBoardList.do";
		}
		else
		{
			model.addAttribute("userVO",vo);
			return "login.jsp";
		}
	}

}
