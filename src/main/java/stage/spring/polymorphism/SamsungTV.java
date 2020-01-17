package stage.spring.polymorphism;

public class SamsungTV implements TV {
	
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println("SamsungTV 객체 생성");
	}
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("SamsungTV 객체 생성2");
		this.speaker = speaker;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV 전원을 켠다.");
	}

	public void powerOff() {
		System.out.println("SamsungTV 전원을 끈다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
