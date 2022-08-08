package test.pack;

public class Messenger {
	public static void sendMessage(String msg) {
		System.out.println(msg+" 를 전송 합니다.");
	}
	
	public static String getMessage() {
		return "hello";
	}
	
	public static void useRadio(Radio r) {
		r.listenMusic();
	}
}
