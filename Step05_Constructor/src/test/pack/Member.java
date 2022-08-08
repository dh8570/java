package test.pack;

public class Member {
	public int num;
	public String name;
	public String addr;
	
	public Member() {
		System.out.println("기본 생성자가 호출");
	}
	
	public Member(int num, String name, String addr) {
		this.num = num;
		this.name = name;
		this.addr = addr;
		System.out.println("num: "+this.num+"\nname: "+this.name+"\naddr: "+this.addr);
	}
}
