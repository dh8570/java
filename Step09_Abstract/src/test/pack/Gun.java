package test.pack;

public class Gun extends Weapon {
	private static int damage = 100;
	
	public Gun() {
		super();
	}
	
	@Override
	public int attack(int hp, int bullet) {
		
		for(int i=0; i<bullet; i++) {
			hp = hp - Gun.damage;
		}
		System.out.println(-Gun.damage+"*"+bullet);
		System.out.println("현재 hp : "+hp);
		
		if(hp <= 0) {
			return super.finish();
		}
		
		return hp;
	}
}
