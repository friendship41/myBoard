package stage.spring.web.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient 
{
	public static void main(String[] args) 
	{
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserService userService = container.getBean(UserService.class);
		
		UserVO userVO = new UserVO();
		userVO.setId("root");
		userVO.setPassword("1");
		
		UserVO user = userService.getUser(userVO);
		
		if(user == null)
		{
			System.out.println("로그인 실패");
		}
		else
		{
			System.out.println(user.getName() + "님 환영합니다");
		}
		
		container.close();
	}

}
