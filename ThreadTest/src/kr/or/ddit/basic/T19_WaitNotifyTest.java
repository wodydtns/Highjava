package kr.or.ddit.basic;
/*
 * 동기화 영역에서만 사용하는 메소드
 * wait() 메소드 : 동기화 영역에서 락을 풀고 Wait-Set 영역으로 이동시킨다
 * notify() 또는 notifyAll()메소드 : Wait-Set 영역에 있는 쓰레드를 깨워 실행할 수 있도록 한다.
 *  (notify()는 하나, notifyAll()은 Wait-Set에 있는 전부를 깨운다.)
 *  
 *  => wait()와 notify(), notifyAll() 메소드는 동기화 영역에서만 실행할 수 있고
 *     Object클래스에서 제공하는 메소드이다.
 *     //wait의 경우 각자의 대기하는 장소가 존재 -> 특정된 한곳에 모두 모이는 곳이 아님
 *
 *
  *	wait()와 notify()를 이용한 두 쓰레드가 번갈아 가면서 한번씩 실행하는 예제 
  */
public class T19_WaitNotifyTest {
	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj);
		ThreadA thB = new ThreadA(workObj);
		
		thA.start(); //synchronized 되어있으므로 메소드가 한개씩만 접근 할 수 있음
		thB.start();
	}
}

// 공통으로 사용할 객체
class WorkObject {
	public synchronized void methodA() { // 쓰레드 A만 lock을 해제된 상태 =>synchronized는 하나만 접근 할수 있음 / 진입 이후 lock을 걸어버린다
		System.out.println("methodA()메소드 작업 중");
	
		notify(); // 처음 - 다른 쓰레드를 깨우기 - 아무 쓰레드도 없음 => 한번 더 돌 때 -> 대기 상태인 B를 깨운다 
		
		try {
			wait(); // ThreadA가 대기 상태로 -> lock을 반환 -> 한번 더 돌 때 -> B는 작동 / A는 다시 대기상태
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized void methodB() { // A가 반환 이후 쓰레드 B 사용 -> 진입 이후 lock을 걸어버린다
		System.out.println("methodB() 메소드 작업 중");
		
		notify(); // ThreadA를 깨운다 -> 한번 더 돌 때 -> 대기 상태인 A를 깨운다 / 깨우는 쓰레드는 정할 수 없다.
		
		try {
			wait(); // Thread B가 대기 상태 -> 한번 더 돌 때 -> A는 작동상태 / B는 다시 대기상태 
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

//WorkObject의 methodA() 메소드만 호출하는 쓰레드
class ThreadA extends Thread{
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	@Override
	public void run() {
		for(int i=1; i<=10;i++) {
			workObj.methodA();
		}
	}
}
//WorkObject의 methodA() 메소드만 호출하는 쓰레드
class ThreadB extends Thread{
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	@Override
	public void run() {
		for(int i=1; i<=10;i++) {
			workObj.methodB();
		}
	}
}