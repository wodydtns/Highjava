package kr.or.ddit.basic;
/*
 * 은행의 입출금을 쓰레드로 처리하는 예제
 * (Lock을 이용한 동기화 처리)
 */

import java.util.concurrent.locks.ReentrantLock;

public class T17_LockAccountTest {
		public static void main(String[] args) {
			LockAccount lAcc = new LockAccount();
			lAcc.setBalance(10000); // 입금
			
			BankThread2 bth1 = new BankThread2(lAcc);			
			BankThread2 bth2 = new BankThread2(lAcc);
			
			bth1.start();
			bth2.start();
		}
}

//입출금을 담당하는 클래스
class LockAccount{
	private int balance; // 잔액
	
	//lock 객체 생성 => 되도록이면 private final로 만든다.
	private final ReentrantLock lock = new ReentrantLock();
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	//입금하는 메소드
	public void deposit(int money) {
		//Lock 객체의 lock() 메소드가 동기화 시작, unlock()메소드가 동기화의 끝
		// lock() 메소드로 동기화를 설정한 곳에서는 반드시 unlock()으로 해제해주어야한다.
		lock.lock(); // 시작
		balance += money; // 동기화 처리 부분
		lock.unlock(); // 해제
		
	}
	
	// 출금하는 메소드(출금 성공: true, 실패 : false)
	public boolean withdraw(int money) {
		lock.lock();
		boolean chk = false;
		// try~catch 블럭을 사용할 경우 -> unlock()메소드 호출을 finally 블럭에서 하도록 함
		try {
			if(balance >=money) {
				for(int i=1; i<=1000000000;i++) {}
				balance -= money;
				System.out.println("메소드 안에서 balance = " + getBalance());
				chk = true;
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		return chk;
	}
}
//은행업무를 처리하는 쓰레드
class BankThread2 extends Thread{
	private LockAccount lAcc;
	
	public BankThread2(LockAccount lAcc) {
		this.lAcc = lAcc;
	}
	@Override
	public void run() {
		boolean result = lAcc.withdraw(6000);
		System.out.println("쓰레드 안에서 result=" + result + ", balance = " + lAcc.getBalance());
	}
}
