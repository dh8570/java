package test.pack;

public abstract class Weapon {
	public void prepare(int bullet) {
		System.out.println(bullet+"발 장전 중");
	}
	
	public int finish() {
		System.out.println("게임을 종료합니다.");
		return 0;
	}
	
	public abstract int attack(int hp, int bullet);
}
