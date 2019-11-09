package kr.or.ddit.basic;

class Util{
	/*
	 * 제너릭 메소드 <T,R> R method(T t) 
	 * 
	 * 파라미터 타입과 리턴타입으로 타입 파라미터를 가지는 메소드
	 * 클래스는 제너릭이 아니지만 메소드가 제너릭 / 클래스, 메소드 모두 제너릭
	 * 선언방법 : 리턴타입 앞에 <> 기호 추가+ 타입 파라미터 기술 후 사용
	 * 
	 */
	//<제너릭 타입> 리턴타입 메소드명
	public static <K,V> boolean compare(Pair<K,V> p1, Pair<K,V> p2) { 
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
}

/*
 *  멀티타입<K,V>을 가지는 제너릭 클래스
 *  
 */
class Pair<K,V>{
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
}
public class T04_GenericMethodTest {
	public static void main(String[] args) {
		Pair<Integer,String> p1 =new Pair<Integer,String>(1,"홍길동");
		Pair<Integer,String> p2 =new Pair<Integer,String>(1,"홍길동");
		
		//구체적타입 명시적으로 지정(생략 가능)
		boolean result1 = Util.<Integer, String>compare(p1, p2);
		
		if(result1) {
			System.out.println("p1,p2를 비교했을 때 논리(의미)적으로 동일한 객체");
		}else {
			System.out.println("p1,p2를 비교했을 때 논리(의미)적으로 동일한 객체 아님");
			
		}
		Pair<String, String> p3 = new Pair<>("001","홍길동"); // <> = <String, String> 생략 가능 
		Pair<String, String> p4 = new Pair<>("002","홍길동");
		boolean result2 = Util.compare(p3, p4);
		
		if(result2) {
			System.out.println("p3와 p4를 비교했을 때 논리(의미)적으로 동일한 객체");
		}else {
			System.out.println("p3와 p4를 비교했을 때 논리(의미)적으로 동일한 객체 아님");
		}
		
	}
	
}