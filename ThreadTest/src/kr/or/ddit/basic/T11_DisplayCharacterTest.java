package kr.or.ddit.basic;

/*
 * 3개(명)의 쓰레드가 각각 알파벳 대문자를 출력 -> 출력을 끝낸 순서대로 
 * 나타내는 프로그램 
 */
public class T11_DisplayCharacterTest {

	static String strRank = ""; // 순위 저장
	public static void main(String[] args) {
		DisplayCharacter[] disChars = new DisplayCharacter[] {
				new DisplayCharacter("홍길동"),
				new DisplayCharacter("박재욱"),
					
				new DisplayCharacter("노드"),
		};
		for(int i =0; i < disChars.length;i++) {
			disChars[i].start();
		}
		for(DisplayCharacter dc : disChars) {
			try {
				dc.join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	System.out.println("경기 끗");
	System.out.println("----------------------------");
	System.out.println();
	System.out.println("경기 결과");
	System.out.println("순위: " + strRank);
	}
	
}
// 영어 대문자를 출력하는 쓰레드
class DisplayCharacter extends Thread{
	private String name;
	
	public DisplayCharacter(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(char ch='A';ch<='Z';ch++) {
			System.out.println(name + "의 출력 문자: " + ch);
		}
		try {
			//sleep() 메소드 에서는
			Thread.sleep((int)(Math.random()*300)+200);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + "출력 끝");
		T11_DisplayCharacterTest.strRank += name + " ";
	}
	
}