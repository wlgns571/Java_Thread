package java_day26.issac;

public class Customer extends Thread {
	private Issac issac;
	private int count;
	
	Customer(Issac issac, int count, String name) {
	 super(name);
	 this.issac = issac;
	 this.count = count;
	}
	
	@Override
	public void run() {
		// 토스트를 구매한다.
		issac.buyToast(super.getName(), count);		
	}
}
