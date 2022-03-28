package java_day26.issac;

public class Chef extends Thread {
	private Issac issac;
	
	Chef(Issac issac) {
		this.issac = issac;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			issac.makeToast();
		}
	}
}
