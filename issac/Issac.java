package java_day26.issac;

public class Issac {
	private int toast = 0;

	public synchronized void makeToast() {
		toast += 1;
		System.out.println("토스트를 하나 만들었습니다. 재고: " + toast);

		// Wait Set에서 대기중인 임의의 스레드를 하나 깨운다.
//		notify();

		// 대기중인 스레드를 모두 깨운다.
		notifyAll();
	}

	public synchronized void buyToast(String name, int count) {
		if (toast < count) {
			try {
				// 스레드를 깨울때까지(notify()) 해당 스레드는 대기
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		
		if (toast >= count) {
			toast -= count;
			System.out.println(name + "에게 토스트를 " + count + " 개 팔았습니다. 재고: " + toast);
		} else {
			// 재귀함수 사용 
			// maketoast가 notify()를 실행해서 wait()중이 현재 스레드를 깨워도,
			// toast가 count보다 적으면
			// 함수를 다시 실행해서 wait()로 만든다.
			buyToast(name, count);
		}
	}
}
