package kr.or.ddit.basic;

/*
 *  멀티 쓰레드 프로그램
 */
public class T02_ThreadTest {
	public static void main(String[] args) {
		// 방법1 : Thread 클래스를 상속한 class의 인스턴스 생성 후 이 인스턴스의 start() 메소드 호출
		MyThread1 th1 = new MyThread1();
		
		//방법2 : Runnable 인터페이스를 구현한 class의 인스턴스 생성 후 이 인스턴스를 
//		Thread 객체의 인스턴스를 생성할 때 생성자의 매개변수로 넘겨주는 방법 
		// 이 때 생성된 Thread객체의 인스턴스의 start()메소드 호출
		MyThread2 r1 = new MyThread2(); // Runnable 객체만 가져옴 - run()을 가져옴
		Thread th2 = new Thread(r1); // thread객체를 가져와야함 -> 여기에 run을 실행하겠다고 말하는 것 - run()을 실행
		
		//방법3 : 익명 클래스를 이용하는 방법 
		// Runnable 인터페이스를 구현한 익명크래스를 
		//Thread 인스턴스를 생성할 때 매개변수로 넘겨주기
		Thread th3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=10;i++) {
					System.out.print("@");
				}
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		th1.start(); //start를 이용해 동작하도록 함 // 메인 thread가 thread1,2,3을 동작 시킴 -> 총 4개의 쓰레드가 동작
		th2.start(); // 콜스택 하나 늘려주는 메소드 // 메인 말고 다른 쓰레드 하나가 실행하는 것
		th3.start();
		th1.run(); // 메인 스레드가 실행
		System.out.println("메인 메소드 끗");
}


} 
class MyThread1 extends Thread{ // 이 자체가 Thread
	@Override
	public void run() { //run이 실행하는 부분
		for(int i=1;i<=10;i++) {
			System.out.print("*");
			try {
				//Thread.sleep(시간) => 주어진 시간동안 작업을 잠시 멈춤
				//시간은 밀리세컨드 단위 => 1000 은 1초
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThread2 implements Runnable{ // thread method run() - 
		@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.print("$");
			try {
				//Thread.sleep(시간) => 주어진 시간동안 작업을 잠시 멈춤
				//시간은 밀리세컨드 단위 => 1000 은 1초
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
