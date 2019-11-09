package kr.or.ddit.basic;

public class T01_ArgsTest {
	/*
	 * 가변형 인수 : 메소드의 매개변수 개수가 실행 시마다 다를 경우 사용 -> 데이터가 몇개 넘어올 지 모를 때 사용
	 * 			   가변형 인수는 메소드 안에서 배열로 처리
	 *  		   가변형 인수는 한가지 자료형만 사용 가능
	 *  		   타입명...변수이름 => ex) int...data
	 */
	// 배열을 이용한 메소드
	// 매개변수로 받은 정수들의 합계를 구하는 메소드(이 정수들의 개수는 상황에 따라 달라짐)
	
	public int sumArr(int[] data) {
		int sum=0;
		for(int i=0;i<data.length;i++) {
			sum += data[i];
		}
		return sum;
	}
	// 가변형 인수를 이용한 메소드
	public int sumArg(int...data) {
		int sum=0;
		for(int i=0;i < data.length;i++) {
			sum += data[i];
		}
		return sum;
	}
	// 가변형 인수와 일반적인 인수를 같이 사용할 경우 -> 가변형 인수를 제일 뒤쪽에 배치해야함
	public String sumArg2(String name, int...data) { // int...data => 배열처럼 초기화됨 
		int sum=0;
		for(int i=0;i < data.length;i++) {
			sum += data[i];
		}
		return name + "씨 점수:" + sum;
	}
	public static void main(String[] args) {
			T01_ArgsTest at = new T01_ArgsTest();
			
			int[] nums = {100,200,300,};
			System.out.println(at.sumArg(nums));
			System.out.println(at.sumArr(new int[] {1,2,3,4,5}));
			System.out.println(at.sumArg(100,200,300));
			System.out.println(at.sumArg(1,2,3,4,5));
			System.out.println();
			
			System.out.println(at.sumArg2("홍길동", 1,2,3,4,5,6,7,8,9,10));
	}
}
