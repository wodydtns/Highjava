package kr.or.ddit.basic;

public class T02_LambdaTest2 {
	public static void main(String[] args) {
		// 람다식을 사용하지 않았을 경우
		/*
		LambdaTestInterface1 lam1 = new LambdaTestInterface1() {

			@Override
			public void test() {
				System.out.println("안녕하세요.");
				System.out.println("익명구현객체 방식입니다.");
			}
		};
		 */
		LambdaTestInterface1 lam1 = () -> {
			System.out.println("람다식으로 처리하는 방식입니다.");
		};
		lam1.test(); // 메소드 호출

		LambdaTestInterface2 lam3 =
				(int z) -> {
					int result = z + 100;
					System.out.println("result = " + result);
				};
		lam3.test(30);
		
		LambdaTestInterface2 lam4 =
				z -> {
					int result = z + 300;
					System.out.println("result = " + result);
				};
		lam4.test(60);
		LambdaTestInterface2 lam5 =
				z ->System.out.println("result = " + (z+500));
		lam5.test(90);
		LambdaTestInterface3 lam6 = 
				(int x,int y) ->{
					int r = x+y;
					return r;
				};
				int k = lam6.test(20,50);
				System.out.println("k = " + k);

		LambdaTestInterface3 lam7 =
				(x,y)->{
					return x+y;
				};
				k = lam7.test(80,50);
				System.out.println("k = " + k);

		LambdaTestInterface3 lam8 =
				(x,y)->	x + y;

		k = lam8.test(100,200);
		System.out.println("k = " + k);

		LambdaTestInterface3 lam9 =
				(x,y) -> {return x > y ? x : y;}; //삼항연산자는 {} 생략 불가
				k = lam9.test(100,200);
				System.out.println("k = " + k);
	}			
}
