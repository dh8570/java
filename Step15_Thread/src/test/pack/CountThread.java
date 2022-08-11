package test.pack;

public class CountThread extends Thread {
	@Override
	public void run() {
		int count=0;
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			System.out.println("현재 카운트:"+count);
			if(count==10) {
				break;
			}
		}
	}
}
