package kr.or.ddit.basic;
/*
 *  쓰레드의 수행시간 체크하기
 */

public class T03_ThreadTest {
	public static void main(String[] args) {
		Thread th = new Thread(new MyRunner()); // Runnable 객체를 상속받은 객체만 넣어야함

		//1970년 1월 1일 0시0분0초(표준시)로부터 경과한 시간 -> 밀리세컨드 단위로 나타내기
		long startTime = System.currentTimeMillis();

		th.start(); // 쓰레드 작업 시작

		try {
			
			th.join(); // 현재 실행중인 쓰레드에서 작업중인 쓰레드(지금 th쓰레드)가 종료될 때까지 기다린다. 
					   // -> 현 예제에서는 main 쓰레드가 th 쓰레드가 끝나기까지 기다린다.
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();

		System.out.println("경과시간: " + (endTime-startTime)); // th 쓰레드가 실행된 시간 
	}
}
/*
 * 1~1000000000 - 1~ 10억 까지 합계를 구하는 쓰레드
 */
class MyRunner implements Runnable{

	@Override
	public void run() {
		long sum = 0;
		for(long i=1L; i<=1000000000;i++) {
			sum += i;
		}
		System.out.println("합계: "+ sum);
	}


}
