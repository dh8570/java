package test.pack;

public class Member {
	public static int id = 0;
	public String name = null;
	public String addr = null;
	
	public Member(int idVal, String nameVal, String addrVal) {
		id = idVal;
		name = nameVal;
		addr = addrVal;
	}
	
	public void info() {
		System.out.println("번호: "+this.id+"\n이름: "+this.name+"\n주소: "+this.addr);
	}
}
