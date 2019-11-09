package kr.or.ddit.basic;


public class T04_ThreadTest {
	/*
	 *  1~20억까지의 합계를 구하는데 걸리는 시간 체크하기
	 *  전체 합계를 구하는 작업을 단독으로 했을 때(1개의 쓰레드를 사용했을 때)와
	 *  여러 쓰레드로 분할해서 작업할 때의 시간을 확인해보기
	 *  
	 */
	public static void main(String[] args) {
		//단독으로 처리 시
		SumThread sm = new SumThread(1L,2000000000L);
		long startTime = System.currentTimeMillis();
		sm.start();
		
		try {
			sm.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("단독으로 처리할 때의 시간 : "+  (endTime-startTime));
		System.out.println("\n\n");
		
		// 여러 쓰레드가 협력해서 처리시
		SumThread[] smThs = new SumThread[] {
				new SumThread(1L,50000000L),
				new SumThread(50000001L,100000000L),
				new SumThread(100000001L,150000000L),
				new SumThread(100000001L,200000000L)
		};
		startTime =System.currentTimeMillis();
		for(int i=0;i < smThs.length;i++) {
			smThs[i].start(); // 쓰레드 실행 부 
		}
		for(int i=0;i < smThs.length;i++) {
			try {
				smThs[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("협력 처리 시 처리 시간:" + (endTime-startTime));
		
	}
}
class SumThread extends Thread{
	private long max, min;
	
	public SumThread(long min, long max) {
		this.max = max;
		this.min = min;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for(int i=1;i<=max; i++) {
			sum +=i;
		}
		System.out.println(min + " ~ " + max + "까지의 합" + sum);
	}
	
}