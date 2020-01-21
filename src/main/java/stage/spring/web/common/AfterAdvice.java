package stage.spring.web.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice 
{
	@Pointcut("execution(* stage.spring.web..*Impl.*(..))")
	public void allPointCut() {}
	
	@After("allPointCut()")
	public void finallyLog()
	{
		System.out.println("[사후처리] : 비즈니스 로직 수행 후 무조건 동작");
	}
}
