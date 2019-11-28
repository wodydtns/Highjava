package kr.or.ddit.basic;

public class SingletonTest {
	public static void main(String[] args) {
		// MySingleton test1 = new MySingleton(); // new 사용 불가
		
		//getInstance() 이용해 객체 생성
		MySingleton test2 = MySingleton.getInstance();
		MySingleton test3 = MySingleton.getInstance();
		
		System.out.println("test=> " + test2);
		System.out.println("test=> " + test3);
		
	}
}
