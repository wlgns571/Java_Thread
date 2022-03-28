package java_day26.factory;

public class FactoryMain {
	public static void main(String[] args) {
		Factory factory = new Factory();
		factory.endFactory = new EndFactory() {
			
			@Override
			public void theEnd() {
				System.out.println("공장 가동을 중지합니다.");
			}
		};
		
		Ramen ramen = new Ramen(factory);
		Thread thread1 = new Thread(ramen, "면");
		thread1.start();
		
		Thread thread2 = new Thread(new Soup(factory), "스프");
		thread2.start();
		
		new Thread(new Packing(factory), "포장").start();
	}
}
