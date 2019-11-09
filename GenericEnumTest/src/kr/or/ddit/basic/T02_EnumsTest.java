package kr.or.ddit.basic;

/*
 *	열거형 : 상수값들을 선언하는 방법
 *	 static final int A = 0;
 *	 static final int B = 1;
 *	 static final int C = 2;
 *	 static final int D = 3;
 *
 *	enum Data { A,B,C,D}
 *
 * 	-열거형 선언하는 방법
 * 	enum 열거형이름 {상수값1, 상수값2....,상수값n}
 * 	
 */
public class T02_EnumsTest {
		// City 열거형 객체 선언(기본값을 이용하는 열거형)
		public enum City { 서울,부산,대구,광주,대전};
		
		// 데이터를 임의로 지정한 열거형 객체선언
		// 데이터 값을 정해줄 경우 생성자를 만들어 괄호 안의 값이 변수에 저장되도록 해야함
		
		public enum Season{
			봄("3월부터 5월까지"), 여름("6월부터 8월까지"), 
			가을("9월부터 11월까지"), 겨울("12월부터 2월까지");
			
			//괄호 속 값이 저장될 변수 선언
			private String str;
			
			// 생성자 만들기(열거형의 생성자는 제어자가 통상적으로 'private') 
			Season(String data){ // private Season(String data)와 동일
				str = data;		 // enum Season 안에 선언한 값이 data를 참조 -> str로 넘어옴 
			}
			
		//값을 반환하는 메소드 작성
		public String getStr() { // getter,setter에서 getter 에 해당하는 메소드
			return str;
		}
	}
		public static void main(String[] args) {
			/*
			 * 열거형에서 사용되는 메소드
			 * 1. name() : 열거형 상수의 이름을 문자열로 반환
			 * 2. ordinal() : 열거형 상수가 정의된 순서값을 반환(0부터 시작) <인덱스 반환>
			 * 3. valueOf("열거형 상수 이름"); : 지정된 열거형에서 '열거형 상수이름'과 일치하는 열거형 상수 반환
			 * 
			 */
			City myCity1; // 열거형 객체변수 선언 , default 생성자가 있음
			City myCity2; // city타입만 넣을 수 있게 제한
			
			// 열거형 객체 변수에 값 저장하기
			myCity1 = City.서울; // enum타입의 city타입을 생성, enum 문법을 통해 객체화 / 방법1
			myCity2 = City.valueOf("서울"); // City enum에서 '서울'상수를 가져옴 / 방법2 - 값이 동일한 것을 비교해서 동일한 enum을 가져옴
			
			System.out.println("myCity1 : " + myCity1.name());
			System.out.println("myCity의 ordinal : " + myCity1.ordinal());
			
			System.out.println("myCity2 : " + myCity2.name()); // city의 String값 반환
			System.out.println("myCity의 ordinal : " + myCity2.ordinal());
			System.out.println("===============================================");
			
			Season ss = Season.valueOf("여름"); // Season ss = Season.여름
			System.out.println("name => " + ss.name());
			System.out.println("ordinal => " + ss.ordinal());
			System.out.println("get 메소드=> " + ss.getStr()); 
			System.out.println("===============================================");
			
			//열거형이름.values() : 데이터를 배열로 가져온다
 			Season[] enumArr = Season.values();
			for(int i=0;i<enumArr.length;i++) {
				System.out.println(enumArr[i].name() + " : " + enumArr[i].getStr());
			}
			System.out.println();
			
			for(City city:City.values()) { // enum 타입도 iterable 구현
				System.out.println(city+ " : " + city.ordinal());
			}
			
			City city = City.대구;
			System.out.println(city == City.대전); 
			System.out.println(city == City.대구);
			System.out.println(ss == Season.여름);
//			System.out.println(ss == City.광주); 같은 타입끼리 비교해야한다. -> 타입 안전성이 높다.
			
			System.out.println("대구 =>" + city.compareTo(City.대구)); // comparable도 구현해놓음 - 대구는 ordinal
			System.out.println("서울 =>" + city.compareTo(City.서울)); // 서울은 ordinal이 0 -> 대구는 2 -> 2만큼 차이난다 라고 결과값을 보여줌
			System.out.println("대전 =>" + city.compareTo(City.대전)); // 대전은 ordinal이 4 -> 대구는 2 -> -2만큼 차이난다.
			
		}
}


