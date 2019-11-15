package kr.or.ddit.basic;

class Util2{
	public static <T extends Number> int compare(T t1, T t2) { // T extends Number -T는 number를 상속받았다-> Number 객체를 상속받음
		double v1 = t1.doubleValue(); // int,float,double 등 number객체에서 정의해놓은 요소를 가져다 쓸 수 있음
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2); // double의 static method - compare
	}
	public static <T extends String> String com(T a1,T a2) {
		String v3 = a1.toLowerCase();
		String v4 = a2.toUpperCase();
		return v3.concat(v4);
	}
}
/*
 * 	 제한된 타입 파라미터(Bounded Parameter) 예제
 */
public class T05_GenericMethodTest {
	public static void main(String[] args) {
		
		int result1 = Util2.compare(10, 20); // AutoBoxing - 값을 저장할 때 객체화하는 것 ex) int 값->오토박싱->integer로 
											 //int , int 연산 
		System.out.println(result1); // 결과는 double값 - double.compare했으므로
		
		int result2 =Util2.compare(3.14, 3); //double, int 연산
		System.out.println(result2); // 결과는 double값 - double.compare했으므로
		
		String result3 = Util2.com("park", "jae wook");
		System.out.println(result3);
				
//		Util2.compare("c", "java"); // 에러발생 - 파라미터에 제한을 걸었으므로 String은 비교할 수 없음
		
		
	}
}
