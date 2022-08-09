package test.dto;

public class WorkDto {
	private int num = 0;
	private String content = null;
	private String datetime = null;
	
	public WorkDto() {
		
	}
	
	public WorkDto(int num, String content, String datetime) {
		this.num = num;
		this.content = content;
		this.datetime = datetime;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public String getDatetime() {
		return this.datetime;
	}
}
