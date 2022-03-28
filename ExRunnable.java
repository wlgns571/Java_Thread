package java_day26;

public class ExRunnable implements Runnable {
	int num;
	
	ExRunnable(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		// 현재 실행 중인 스레드의 이름 출력
		System.out.println(Thread.currentThread().getName());
		ThreadMain.printNumbers(num);
	}
	
}
