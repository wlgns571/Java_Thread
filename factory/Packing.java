package java_day26.factory;

public class Packing implements Runnable {
	Factory factory;
	
	Packing(Factory factory) {
		this.factory = factory;
	}
	
	@Override
	public void run() {
		factory.Packing();
	}
}
