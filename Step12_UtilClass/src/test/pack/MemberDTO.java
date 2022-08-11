package test.pack;

public class MemberDTO {
	private int num;
	private String name;
	private String addr;
	
	public MemberDTO() {
		
	}
	
	public MemberDTO(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public int getNum() {
		return num;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddr() {
		return addr;
	}
}
