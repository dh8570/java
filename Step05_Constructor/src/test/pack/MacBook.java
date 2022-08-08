package test.pack;

public class MacBook {
	private Cpu cpu;
	private Memory memory;
	private HardDisk hardDisk;
	
	public MacBook(Cpu cpu, Memory memory, HardDisk hardDisk) {
		this.cpu = cpu;
		this.memory = memory;
		this.hardDisk = hardDisk;
	}
	
	public void doGame() {
		if(this.cpu==null || this.memory==null || this.hardDisk==null) {
			System.out.println("부품 필요");
			return ;
		}
		System.out.println("게임 실행");
	}
}
