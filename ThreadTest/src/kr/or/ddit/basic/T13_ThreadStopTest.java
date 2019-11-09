package kr.or.ddit.basic;
/*
 * Thread의 stop() 메소드를 호출하면 쓰레드가 바로 정지'
 * 이 때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어
 * 나중에 실행되는 프로그램에 영향을 줄 수 있다.
 * 그래서 현재 stop()메소드는 비추천
 */
public class T13_ThreadStopTest {
	public static void main(String[] args) {
			ThreadStopEx1 th = new ThreadStopEx1();
			th.start();
			
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
//			th.stop(); - 비추천
			th.setStop(true); // stop의 상태값을 이용한 종료
			
			//interrupt() 메소드를 이용해 쓰레드 멈추기
			ThreadStopEx2 th2 = new ThreadStopEx2();
			th2.start();
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			th2.interrupt();
	}
}
// interrupt()를 이용하지 않고 flag를 통해 쓰레드 멈추는 방법
class ThreadStopEx1 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println("쓰레드 정리중");
		}
		System.out.println("자원 정리 중");
		System.out.println("실행 종료");
	}
}

//interrupt() 메소드를 이용 -> 쓰레드를 멈추게 하는 방법
class ThreadStopEx2 extends Thread{
	@Override
	public void run() {
		
		//방법1 => sleep()메소드 or join()메소드 등을 사용했을 때 interrupt()메소드 호출 
		//         -> InterruptedException이 발생
		try {
			while(true) {
				System.out.println("쓰레드 처리 중");
				Thread.sleep(1);
			}
		}catch(InterruptedException e) {} // InterruptedException을 발생 시켜 while문 탈출
		
		//방법2 > interrupt()메소드가 호출되었는 지 검사하기
		while(true) {
			System.out.println("쓰레드 처리 중");
			
			//검사방법 1 => 쓰레드의 인스턴스객체용 메소드 사용
			if(this.isInterrupted()) { // interrupt() 메소드 호출되면 true / this = ThreadStopEx2 / 계속 가능
				System.out.println("인스턴스용 isInterrupted()");
				break;
			}
			
			//  검사 방법 2 => 쓰레드의 정적 메소드를 이용하는 방법
//			if(Thread.interrupted()) { // interrupt()가 호출되면 true / static으로 사용 -> 한번 호출 이후로는 false로 변환 -> 1번 이후 불가능
//				System.out.println("정적 메소드 interrupted()");
//				break;
//			}
			
		}
		System.out.println("자원 정리중");
		System.out.println("실행 종료");		
	}
}