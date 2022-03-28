package java_day26.factory;

public class Factory {
	int countRamen = 0; // 생산된 라면 갯수
	int countSoup = 0; // 생산된 스프 갯수
	int count = 0; // 생산된 라면 갯수
	
	public EndFactory endFactory;
	
	public synchronized void makeRamen() {
		System.out.println("면을 만들었습니다. 면 수량: " + countRamen);
		countRamen++;
		notify();
	}

	public synchronized void makeSoup() {
		System.out.println("스프을 만들었습니다. 스프 수량: " + countSoup);
		countSoup += 2;
		notify();
	}

	public synchronized void Packing() {
		if (countRamen > 0 && countSoup > 0) {
			countRamen--;
			countSoup--;
			count++;
			
			System.out.println("라면포장을 완료했습니다. 라면포장 수량: " + count);
			
			if (count == 10) {
				endFactory.theEnd();
				return;
			}
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		Packing();
		
	}
}
