package java_day26;

public class ExThread extends Thread {
	
	int num;
		
	ExThread(int num, String name) {
		super(name);
		this.num = num;
	}
	
	@Override
	public void run() {
		// 현재 실행중인 Thread의 이름 출력
		System.out.println(super.getName());
		ThreadMain.printNumbers(this.num);
	}
}
