package java_day26.factory;

public class Soup implements Runnable {
	Factory factory;

	Soup(Factory factory) {
		this.factory = factory;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			factory.makeSoup();
		}
	}
}
