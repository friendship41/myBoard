package stage.spring.web.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice 
{
	@Around("PointcutCommon.allPointCut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable
	{
		String method = joinPoint.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object resultObj = joinPoint.proceed();
		
		stopWatch.stop();
		
		System.out.println(method + "() 메서드 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis() + "ms");
		return resultObj;
	}
}
