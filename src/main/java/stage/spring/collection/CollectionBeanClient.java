package stage.spring.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = factory.getBean(CollectionBean.class);
		
		List<String> addressList = bean.getAddressList();
		System.out.println(addressList);
		
		System.out.println("============================");
		Map<String, String> addressMap = bean.getAddressMap();
		for(String addressKey : addressMap.keySet())
		{
			System.out.println(String.format("키 : %s, 값: %s", addressKey, addressMap.get(addressKey)));
		}
		
		System.out.println("============================");
		Properties addressProperties = bean.getAddressProperties();
		for(String addressKey : addressProperties.stringPropertyNames())
		{
			System.out.println(String.format("키 : %s, 값: %s", addressKey, addressProperties.get(addressKey)));
		}
		
		System.out.println("============================");
		Set<String> addressSet = bean.getAddressSet();
		for(String address : addressSet)
		{
			System.out.println(address);
		}
		
		factory.close();
	}
}
