package stage.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice 
{
	@Before("PointcutCommon.allPointCut()")
	public void beforeLog(JoinPoint joinPoint)
	{
//		String method = joinPoint.getSignature().getName();
//		Object[] arg = joinPoint.getArgs();
//		System.out.println("[사전처리] : " + method + "() 메서드의 ARGS정보 : " + arg[0].toString());
//		System.out.println("[사전처리] : 비즈니스 로직 수행 전 동작");
	}
}
