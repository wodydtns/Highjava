package kr.or.ddit.basic;

public class T09_ThreadDaemonTest {
	public static void main(String[] args) {
		AutoSaveThread autoSave = new AutoSaveThread();
		
		//데몬 쓰레드로 설정하기(start() 메소드 호출 전 설정)
		autoSave.setDaemon(true); // 설정하지 않으면 autosave 가 무한루프에 빠진다. 
		autoSave.start();
		
		try {
			for(int i=1;i<=20;i++) {
				System.out.println("작업" + i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("메인 쓰레드 종료");
	}
}
// 자동 저장하는 쓰레드 클래스
class AutoSaveThread extends Thread{
	public void save() {
		System.out.println("작업한 내용을 저장합니다.");
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			save(); // 저장 기능 호출
		}
	}
}
