package stage.spring.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyLifeBeanMain {

	public static void main(String[] args) {
//		FileSystemResource fileSystemResource = new FileSystemResource(new File("src/main/resources/applicationContext.xml"));
		
//		XmlBeanFactory factory = new XmlBeanFactory(fileSystemResource);
		
//		factory.addBeanPostProcessor(new CustomBeanPostProcessor());
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		MyLifeBean myLifeBean = factory.getBean(MyLifeBean.class);
		
		System.out.println("============객체 받아오기 완료===============");
		
		myLifeBean.sayHello();
		
//		factory.destroyBean("myLifeBean", myLifeBean);
		factory.close();
	}

}
