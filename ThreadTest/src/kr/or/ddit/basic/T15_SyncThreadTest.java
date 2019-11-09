package kr.or.ddit.basic;

public class T15_SyncThreadTest {
	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		
		WorkerThread th1 = new WorkerThread("1번쓰레드", sObj);
		WorkerThread th2 = new WorkerThread("2번 쓰레드", sObj);
		th1.start();
		th2.start();
	}
}

//공통으로 사용할 객체 생성
class ShareObject {
	private int sum =0;

	//동기화 하는 방법 : 메소드 자체에 동기화 설정하기

	public void add() {
//	synchronized public void add() { // 동기화처리 방법1.
		synchronized (this) { // 동기화처리 방법 2. : 동기화 블럭으로 설정하기
		for(int i=0; i < 1000000000;i++) {}// 동기화처리 전까지 시간 벌기 용

			
			int n = sum;
			
			n+=10; // 10증가
			sum = n;
		System.out.println(Thread.currentThread().getName()+"합계: " + sum); //getName() 쓰레드의 이름을 가져오는 메소드
		}
	}

	public int getSum() {
		return sum;
	}
}
	//작업을 수행하는 쓰레드
	class WorkerThread extends Thread{
		ShareObject sObj;

		public WorkerThread(String name, ShareObject sObj) {
			super(name);
			this.sObj = sObj;
		}
		@Override
		public void run() {
			for(int i=1;i<=10;i++) {
				sObj.add();
			}
		}
	}


