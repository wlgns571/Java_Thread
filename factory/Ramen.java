package java_day26.factory;

public class Ramen implements Runnable {
	Factory factory;

	Ramen(Factory factory) {
		this.factory = factory;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			factory.makeRamen();
		}
	}

}
