package stage.spring.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class TVUser {

	public static void main(String[] args) {
//		높은 결합도의 구조
//		TV tv = new SamsungTV(); 
//		TV tv = new LgTV();
		
//		조금 나아진 결합도의 구조
//		BeanFactory factory = new BeanFactory();
//		TV tv = (TV) factory.getBean(args[0]);
		
//		스프링 기능을 이용한 낮은 결합도 구조
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv = factory.getBean(LgTV.class);
//		System.out.println(tv.getClass().getName());
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		factory.close();
	}

}
