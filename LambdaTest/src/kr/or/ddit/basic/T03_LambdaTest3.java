package kr.or.ddit.basic;

public class T03_LambdaTest3 {
	static int stVar = 9;
	
	public void testMethod(final int temp) {
		final int localVar = 50;
		int kor = 100; // 자동으로 final로 만들어줌
		
		// 람다식 내부에서 사용되는 지역변수는 모두 final이어야한다.
		// 보통은 final을 붙이지 않으면 컴파일러가 자동으로 붙여준다.
		// 단, 지역변수의 값을 변경하는 식이 있을 경우 자동으로 final을 붙여주지 않는다.
		
		//temp = 500;
		//localVar = 2000;
//		kor = 400;
		
		//람다식에서 지역변수 사용하기
		LambdaTestInterface1 lt = 
				() -> {
					System.out.println("temp = " + temp);
					System.out.println("localVar= " + localVar);
					System.out.println("kor = " + kor);
					System.out.println("stVar = " + stVar);
				};
		lt.test();
		
	}
	public static void main(String[] args) {
		new T03_LambdaTest3().testMethod(200);
	}
}
