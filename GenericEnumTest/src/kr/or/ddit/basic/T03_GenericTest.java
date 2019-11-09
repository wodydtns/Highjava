package kr.or.ddit.basic;

/*
 * 제너릭 클래스를 만드는 방법
 * 형식) 
 *    class 클래스명<제너릭타입글자> {
 *    		제너릭타입글자 변수명; // 변수 선언에 제너릭을 사용할 경우
 *    		...
 *    
 *     		제너릭타입글자 메소드명(){ // 반환값이 있는 메소드에서 사용
 *  			 ...
 *  			return 값;   
 * 	   		}
 * 		...
 *    }
 *    -- 제너릭 타입 글자 -- 통상적으로 / 
 *    T > Type(의미)
 *    K > Key(의미)
 *    V > Value(의미)
 *    E > Element(자료구조에 들어가는 것들을 나타낼 때 사용)
 *    
 */
class NonGenericClass {
	private Object val;

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}
}

class MyGeneric<T> { // alt + shift + s -> source  // 컴파일 시점에 어떤 값이 들어갈 지만 알려주면 된다.
	private T val; // 지금은 어떤 값이 들어올 지 모르는 상태 // 해당되는 타입만 값에 담긴다-> 타입 안전한 코딩이 가능하다.

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
	
}
public class T03_GenericTest {
		public static void main(String[] args) {
				NonGenericClass ng1 = new NonGenericClass();
				ng1.setVal("가나다라");
				
				NonGenericClass ng2 = new NonGenericClass();
				ng2.setVal(100);
				
				String rtnNg1 = (String)ng1.getVal(); // 가져올 때 내가 원하는 타입으로 변환해야함 -> 변환하지 않으면 object 메소드만 사용가능
				System.out.println("문자열 반환값 rtnNg1 => " + rtnNg1);
				
				Integer irtnNg2 = (Integer) ng2.getVal();
				System.out.println("정수 반환값 irtnNg2 => " + irtnNg2);
				System.out.println();
				
				MyGeneric<String> mg1 = new MyGeneric<String>(); // 객체 생성시 타입을 정해줌 -> T 가 String으로 replace(컴파일러가)
				MyGeneric<Integer> mg2 = new MyGeneric<>(); // T 가 Integer로 replace(컴파일러가)
				
				mg1.setVal("우리나라");
				mg2.setVal(500);
			
				
				rtnNg1 = mg1.getVal();
				irtnNg2 = mg2.getVal();
				
				System.out.println("제너릭 문자열 반환값: " + rtnNg1);
				System.out.println("제너릭 문자열 반환값: " + irtnNg2);
		
		}
		
}
