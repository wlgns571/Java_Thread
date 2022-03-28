package java_day26.issac;

public class IssacMain {
	public static void main(String[] args) {
		Issac issac = new Issac();
		Chef chef = new Chef(issac);
		Customer minwoo = new Customer(issac, 2, "민우");
		Customer jaehun = new Customer(issac, 5, "재훈");
		Customer eunji = new Customer(issac, 3, "은지");
		
		chef.start();
		minwoo.start();
		jaehun.start();
		eunji.start();
		
	}
}
