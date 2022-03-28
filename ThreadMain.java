package java_day26;

public class ThreadMain {
	public static void main(String[] args) {
		// printNumbers(1);
		// printNumbers(20);
		// 기본적으로 스레드를 나눠주지 않으면
		// 위에서부터 코드가 실행된다.

		System.out.println("\n=====================================\n");

		// 1. Thread를 상속(extends)받은 클래스를 이용해서
		// 멀티 스레드를 구현하는 방법
		ExThread exThread = new ExThread(100, "민우");
		exThread.start();
		ExThread exThread2 = new ExThread(200, "재훈");
		exThread2.start();

		// 2. Runnable 인테페이스를 구현(implements)한
		// 클래스를 이용
		ExRunnable exRunnable = new ExRunnable(300);
		Thread exThread3 = new Thread(exRunnable, "은지");
		exThread3.start();

		Thread exThread4 = new Thread(new ExRunnable(400), "남규");
		exThread4.start();

		// 3. 람다식 사용
		Thread exThread5 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
			printNumbers(500);
		}, "범석");
		exThread5.start();
		
		System.out.println("MainThread: 일하지 않는자");

	}

	// 입력받은 숫자부터 +5까지 콘솔창에 숫자 출력
	static void printNumbers(int num) {
		for (int i = num; i < num + 5; i++) {
			System.out.println(i);

			try {
				// 실행에 텀(term)을 주고 싶은 경우에 사용
				// sleep() 안에 숫자는 밀리초 단위
				// 현재 이 코드를 실행 중인 스레드를 대기시키는 것으로
				// 다른 스레드는 영향을 받지 않는다.
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
