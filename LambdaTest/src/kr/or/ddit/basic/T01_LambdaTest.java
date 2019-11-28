package kr.or.ddit.basic;

/*
 * 	람다식 => 익명함수를 생성하기 위한 식 
 * 			 자바에서는 '매개변수를 가진 코드 블럭' => 런타임 시 익명구현 객체 생성
 * 
 * 형식) 인터페이스명 객체변수명 = 람다식
 * 람다식의 형식 ) (매개변수1,매개변수2,매개변수3...) -> {처리할 코드; 처리할 코드; ...}
 * 	=>람다식으로 변환할 수 있는 인터페이스는 추상메소드가 1개인 인터페이스만 변환할 수 있다.
 * 	이런 인터페이스를 '함수적 인터페이스'라고 한다.
 * 	이 함수적 인터페이스를 만들 때 @FunctionalInterface로 지정한다.	
 */
public class T01_LambdaTest {
	public static void main(String[] args) {
		// 람다식을 사용하지 않은 경우
		 Thread th1 = new Thread(
			 new Runnable() { 
				
				@Override
				public void run() {
					for(int i=1;i<=10;i++) {
						System.out.println(i);
					}
				}
			});
		//람다식을 사용하는 경우
		 Thread th2 = new Thread(
		 ()->{
			 for(int i=1;i<=10;i++) {
				 System.out.println("람다-" +i);
			 }
		 });
		 
		/*
		 * 람다식 작성 방법
		 * 기본형식 : (자료형이름 매개변수명, ...) -> {실행문들;..}
		 * 
		 * 1) 매개변수의 '자료형 이름'은 생략 가능
		 * ex) (int a) -> {System.out.println(a);}
		 *   == (a) ->  {System.out.println(a);}
		 * 
		 * 2) 매개변수가 1개일 경우 소괄호('()') 생략 가능
		 * 단, '자료형 이름'을 지정할 경우 소괄화를 생략할 수 없음
		 * ex) a->  {System.out.println(a);}
		 * 
		 * 3) '실행문'이 1개일 경우 '{}'를 생략 할 수 있다.
		 * (이 때 문장의 끝을 나타내는 세미콜론도 생략)
		 * ex) a -> System.out.println(a) -- 문장이 하나라서 세미콜론도 생략
		 * 
		 * 4) 매개변수가 하나도 없으면 소괄호를 생략할 수 없다.
		 * ex) () -> System.out.println("hi")
		 * 
		 * 5) 반환값이 있을 경우 return 명령 사용
		 * ex) (a,b) -> { return a+b;} -- statement가 하나라서 {} 생략 가능
		 * 	   (a,b) -> return a+b
		 * 
		 * 6) 실행문에 return문만 있을 경우 return 과 {}를 생략할 수 있다.
		 * ex) (a,b) -> a+b
		 */
	}
}
