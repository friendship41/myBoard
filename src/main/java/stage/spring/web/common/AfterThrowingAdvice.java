package stage.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice 
{
	@AfterThrowing(pointcut = "PointcutCommon.allPointCut()", throwing = "e")
	public void exceptionLog(JoinPoint joinPoint, Exception e)
	{
		String method = joinPoint.getSignature().getName();
		System.out.println("[예외처리] : " + method + "() 수행 중 발생한 예외 메세지 : " + e.getMessage());
	}
}
