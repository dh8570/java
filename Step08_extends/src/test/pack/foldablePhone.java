package test.pack;

public class foldablePhone extends SmartPhone{
	public foldablePhone() {
		super();
		System.out.println("foldablePhone 호출");
	}
	
	public void internet() {
		System.out.println("인터넷 사용 중");
	}
	
	@Override
	public void takePicture() {
		System.out.println("aa2");
	}
}
