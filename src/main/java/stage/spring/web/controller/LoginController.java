package stage.spring.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stage.spring.web.user.UserVO;
import stage.spring.web.user.impl.UserDAO;

public class LoginController implements Controller
{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		if(user !=null)
		{
			session.setAttribute("id", id);
			return "getBoardList.do";
		}
		else
		{
			return "login";
		}
	}

}
