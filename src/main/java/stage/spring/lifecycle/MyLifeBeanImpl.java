package stage.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyLifeBeanImpl implements MyLifeBean, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean
{
	private String greeting;
	private String beanName;
	private BeanFactory beanFactory;
	
	
	public MyLifeBeanImpl() {
		System.out.println("1. 빈의 생성자 실행");
	}
	
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("2. 빈의  setter메서드 실행");
	}

	
	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
		System.out.println("3. beanName 설정");
		System.out.println("----> " + this.beanName);
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		System.out.println("4. beanFactory 설정");
		System.out.println("----> " + this.beanFactory);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("6. property 설정 완료");
	}
	
//	XML에서 초기화 메서드로 설정
	public void init() 
	{
		System.out.println("7. 초기화 메서드 수행");
	}

	@Override
	public void sayHello() {
		System.out.println(greeting + beanName + "!!!");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("종료");
	}

}
