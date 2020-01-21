package stage.spring.web.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon 
{
	@Pointcut("execution(* stage.spring.web..*Impl.*(..))")
	public void allPointCut() {}
	
	@Pointcut("execution(* stage.spring.web..*Impl.get*(..))")
	public void getPointCut() {}
}
