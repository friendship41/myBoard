package stage.spring.web.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice 
{
	public void exceptionLog(JoinPoint joinPoint, Exception e)
	{
		String method = joinPoint.getSignature().getName();
		System.out.println("[예외처리] : " + method + "() 수행 중 발생한 예외 메세지 : " + e.getMessage());
	}
}
