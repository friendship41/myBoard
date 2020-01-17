package stage.spring.polymorphism;

class TVUser {

	public static void main(String[] args) {
//		TV tv = new SamsungTV(); 
//		TV tv = new LgTV();
		BeanFactory factory = new BeanFactory();
		TV tv = (TV) factory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
