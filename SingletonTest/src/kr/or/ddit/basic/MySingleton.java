package kr.or.ddit.basic;
/*
 * singleton패턴 : 객체(인스턴스)를 한개만 만들어지게 하는 프로그래밍 방법
 *  - singleton Class를 구성하는 방법
 *  1. 자기 자신 Class의 참조변수를 멤버변수로 선언
 *  (이 변수는 private static으로 지정)
 *  2. 생성자를 private
 *  (외부에서 생성자에 접근하지 못하게 하기 위해 -> 외부에서 new 명령을 사용하지 못하게 하기 위해서)
 *  3. 객체(인스턴스)는 내부에서 생성해 이 생성된 객체를 반환하는 메소드를 만든다.
 *  (이 메서드의 이름은 보통 getInstance()로 지정)
 *  
 */
public class MySingleton {
	//자기 자신의 class의 참조값을 저장하는 멤버변수 선언
	private static MySingleton single;
	
	//생성자를 private로 지정
	private MySingleton() {
		System.out.println("생성자입니다.");
	}
	
	public static MySingleton getInstance() {
		if(single == null) {
			single = new MySingleton();
		}
		return single;
	}
	// 나머지 내용들은 이 클래스로 처리할 내용들을 기술
	public void displayText() {
		System.out.println("안녕하세요.싱글톤입니다.");
	}
	
}
