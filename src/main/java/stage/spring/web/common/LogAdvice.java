package stage.spring.web.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice 
{
	@Pointcut("execution(* stage.spring.web..*Impl.*(..))")
	public void allPointCut() {}
	
	@Pointcut("execution(* stage.spring.web..*Impl.get*(..))")
	public void getPointCut() {}
	
	@Before("allPointCut()")
	public void printLog()
	{
		System.out.println("[공통 로그] : 비즈니스 로직 수행 전 동작");
	}
}
