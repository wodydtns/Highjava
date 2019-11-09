package kr.or.ddit.basic;

import java.util.Vector;

public class T01_VectorTest {
	
		public static void main(String[] args) {
			//vector => List 계열 클래스
			
			Vector v1 = new Vector();
			System.out.println("first: "+ v1.size());
			
			// Vector는 add() 메서드를 이용해 데이터 추가 가능, 객체도 담을 수 있음 / 기본형 타입도 객체화해 저장(오토박싱)
			v1.add("aaa");
			v1.add(111);
			v1.add(new Integer(123)); // 객체형태로 저장 -> wrapper 클래스라고 부름
			v1.add('a');
			v1.add(true);
			v1.add(3.14);
			
			System.out.println("현재 크키 : " +  v1.size());
			
			//Vector는 addElement() 메소드를 통해 추가 가능 = add()와 동일
			v1.addElement("CCC");
			
			System.out.println("v1 => "+ v1.toString());
			
			//add(index, 데이터) => 벡터의 index 번째에 '데이터'를 끼워넣음, 인덱스 번호는 0부터 / 인덱스 번호가 없으면 앞에서부터 차례대로
			v1.add(1,"kkk");
			System.out.println("v1 =>" + v1.toString());
			
			//set(index, 데이터) => 벡터의 index번째의 값을 주어진 '데이터'로 덮어쓴다(반환값은 원래 데이터)
			
			String temp = (String)v1.set(0,"zzz"); // 원래 자료를 보관하는 방법 
			System.out.println("set명령 후 v1=> "+ v1);
			System.out.println("원래의 데이터 :" + temp);
			
			// remove(index) => 벡터의 index번째 자료를 삭제 => 자료가 삭제되면 index번째의 다음번째 이후의 데이터들이 자동으로 앞으로 당겨져 채워진다.(반환값 : 삭제된 데이터)
			// remove(삭제할 데이터) => '삭제할 데이터'를 찾아 삭제  => 삭제할 데이터가 여러 개일 경우 앞에서부터 삭제 / 삭제할 데이터가 정수형 or char형이면 삭제할 데이터를 객체로 변환해 사용해야한다.
			
			 v1.remove(0);
			 System.out.println("삭제 후: "+ v1);
			 System.out.println();
			 
			 temp = (String)v1.remove(0);
			 System.out.println("삭제된 자료: "+ temp);
			 System.out.println("삭제 후 : " + v1);
			 
			 v1.add(123);
			 v1.remove(true);
			 System.out.println("삭제 후 :" + v1);
			 System.out.println();
			 
			 v1.remove(new Integer(123));
			 System.out.println("삭제 후: "+ v1);
			 System.out.println();
			 
			 v1.remove(new Character('a'));
			 System.out.println("삭제 후: "+ v1);
			 System.out.println();
			 
			 v1.remove(3.14);
			 System.out.println("삭제 후: "+ v1);
			 System.out.println();
			 		
			//get(index) => index번째 자료를 반환
			 int data = (int) v1.get(0); 
			 System.out.println("0번째 자료: "+ v1.get(0));
			 System.out.println("---------------------------------");
			 
			 
			 /*
			  * 제너릭 타입(generic type) 
			  * - Collection 객체를 선언할 때 <>안에 그 Collection이 저장할 데이터 타입을 정해주는 것
			  * - 이런 방식으로 선언하게 되면 그 테이터 타입 이외의 데이터를 저장할 수 없다
			  * - 제너틱 타입으로 선언할 수 있는 데이터 타입은 클래스여야한다.
			  * (ex. int->Integer, boolean->Boolean, char -> Character 등)
			  * =>제너릭 타입으로 선언하게 되면 데이터를 꺼내올 때 별도의 형변환이 필요없다.
			  * 
			  */
			 
			 Vector<String> v2 = new Vector<String>();//String만 저장가능 // 들어가는 데이터 타입을 제한해 프로그램의 에러를 막기 위한 방법- 컴파일러가 체크
			 Vector<Integer> v3 = new Vector<>();//Integer형만 저장 가능 // 생략해도 가능 - 컴파일러가 자동으로 도와줌
			 
			 v2.add("Hello");
//			 v2.add(123); 오류 : 다른 데이터타입의 데이터를 추가할 수 없다 // 인덱스 값으로 컴퓨터가 이해
			 
			 String temp2 = v2.get(0);
			 System.out.println("temp2 => " + temp2); 
			 //===========================================================
			 
			 v2.clear(); // 벡터의 모든 데이터를 삭제
			 System.out.println("clear() 후 v2의 size = " + v2.size());
			 
			 v2.add("AAA");
			 v2.add("BBB");
			 v2.add("CCC");
			 v2.add("DDD");
			 v2.add("EEE");

			 Vector<String> v4 = new Vector<>();
			 v4.add("BBB");
			 v4.add("EEE");
			 
			 System.out.println("삭제되기 전 v2 =>" + v2);
			 //removeAll(Collection객체) => 벡터의 데이터 중 'Collection객체'가 가지고 있는 모든 데이터 삭제
			 //removeAll(파라미터) 파라미터에는 객체만 넣을 수 있음 -> 객체가 담고 있는 값으로 특정 값을 지움
			 // 여러 값을 지울 수 있음 / remove는 하나만 삭제 가능
			 v2.removeAll(v4);
//			 v2.removeAll(123); -> Collection 클래스를 넣야아함, 특정 값으로는 사용 불가
			 
			 System.out.println("삭제된 후 v2 => " + v2);
			 
			 v2.clear();
			 
			 v2.add("AAA");
			 v2.add("BBB");
			 v2.add("CCC");
			 v2.add("DDD");
			 v2.add("EEE");
			 
			 //벡터의 데이터들을 순서대로 모두 가져와 사용하고 싶으면 반복문을 사용(주로 for문사용)
			 for(int i=0;i <v2.size();i++) {
				 System.out.println(i + "번째 자료: "+ v2.get(i));
			 }

			 System.out.println("=====================================================");
			 
			 /*
			  * 향상된 for문
			  * for(자료형명 변수명 : 배열변수나 Collection계열 변수){
			  * 	처리할 내용들; 
			  *     ... 
			  *     }
			  *     => 주어진 '배열변수나 Collection계열 변수'의 데이터 개수만큼 반복
			  *     => 반복할 때마다 '배열변수나 Collection계열 변수'의 데이터를 하나씩 꺼내와 '변수명'에 저장 후 '처리할 내용들'로 처리
			  *     
			  */
			 for(String s : v2){ // 인덱스 접근이 불가, 성능이 좋은 편이라 권장
				 System.out.println(s);
			 }
			 System.out.println("======================================================");
			 
			 // 만약 제너릭을 사용하지 않은 Collection을 향상된 for문으로 처리할 경우 Object형으로 처리
			 for(Object obj :v1) {
				 System.out.println(obj);
			 }
			 //=============================================================================
			 
			 System.out.println("-----------------백터 사이즈 및 용량 메소드 예제----------------------");
			 //capacity : 데이터를 넣을 수 있는 용량
			 // size : 데이터의 개수 size <= capacity
			 Vector v= new Vector(5); // 용량이 5인(사이즈는 0) 벡터 생성
			 v.add("홍길동");
			 v.add("이순신");
			 v.add("3");
			 print(v);
			  
			 v.trimToSize(); // 벡터의 용량을 현재 벡터 사이즈로 줄임
			 System.out.println("=== After trinToSize() ===");
			 print(v);
			 
			 v.ensureCapacity(5); // 현재 용량이 최소용량보다 작다면 신규용량 = 현재용량 * 2로 만듦 
			                      // 그래도 최소용량보다 작다면 -> 신규용량 = 최소용량으로 설정
			 					  // minimum 5 / 현재는 3 -> 현재 capacity*2 > 5 -> capacity 는 6
			  					  // capacity*2 임에도 < ensureCapacity(n) 라면 capacity=ensureCapacity
			 System.out.println("=== After ensureCapacity(5) ===");
			 print(v);
			 
			 v.setSize(7); // 현재 용량이 설정 사이즈보다 작으면 -> 신규용량 = 현재용량 *2  // 그래도 작으면 신규용량 = 설정사이즈로 설정
			 // 사이즈를 7로 만듦 -> 현 capacity를 늘림 -> 현 capacity = 6 => 곱하기 2를 시도 => capacity(12) > size(7)
			 System.out.println("=== After setSize(5) ===");
			 print(v);
			 
			 v.clear();
			 
			 System.out.println("=== After clear() ===");
			 print(v);
			 // size =0이 되고 capacity는 12로 그대로 유지
			 
		}
		
		public static void print(Vector v) {
			System.out.println(v);
			System.out.println("size: " + v.size());
			System.out.println("capacity: " + v.capacity());
		}
}

