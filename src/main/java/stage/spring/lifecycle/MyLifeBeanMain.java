package stage.spring.lifecycle;

import java.io.File;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class MyLifeBeanMain {

	public static void main(String[] args) {
		FileSystemResource fileSystemResource = new FileSystemResource(new File("src/main/resources/applicationContext.xml"));
		
		XmlBeanFactory factory = new XmlBeanFactory(fileSystemResource);
		
		factory.addBeanPostProcessor(new CustomBeanPostProcessor());
		
		MyLifeBean myLifeBean = factory.getBean(MyLifeBean.class);
		
		System.out.println("============객체 받아오기 완료===============");
		
		myLifeBean.sayHello();
		
		factory.destroyBean("myLifeBean", myLifeBean);
	}

}
