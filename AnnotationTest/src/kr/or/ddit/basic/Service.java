package kr.or.ddit.basic;
/*
 * 애너테이션 사용 예제
 */

public class Service {
	@PrintAnnotaion()
	public void method1() { // 디폴트값이 적용 <value
		System.out.println("메소드1에서 출력되었습니다.");
	}
	
	@PrintAnnotaion("%") // value="%" 에서 타입요소이름을 생략 가능, 다른값과 동시에 쓸 때는 value를 명시해야함  // value일때만 생략가능
	public void method2() {
		System.out.println("메소드2에서 출력되었습니다.");
	}
	@PrintAnnotaion(value="#", count=25) // 다른값도 가져오므로 value 생략 불가
	public void method3() {
		System.out.println("메소드3에서 출력되었습니다.");
	}
	
}
