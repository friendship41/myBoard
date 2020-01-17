package stage.spring.collection;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = factory.getBean(CollectionBean.class);
		
		List<String> addressList = bean.getAddressList();
		
		System.out.println(addressList);
		
		factory.close();
	}
}
