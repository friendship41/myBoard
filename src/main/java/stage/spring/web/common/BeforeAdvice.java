package stage.spring.web.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice 
{
	public void beforeLog(JoinPoint joinPoint)
	{
		String method = joinPoint.getSignature().getName();
		Object[] arg = joinPoint.getArgs();
		System.out.println("[사전처리] : " + method + "() 메서드의 ARGS정보 : " + arg[0].toString());
//		System.out.println("[사전처리] : 비즈니스 로직 수행 전 동작");
	}
}
