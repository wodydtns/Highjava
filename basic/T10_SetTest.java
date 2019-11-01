package kr.or.ddit.basic;

import java.util.SortedSet;
import java.util.TreeSet;

public class T10_SetTest {
	/*
	 * TreeSet 예제 
	 */
	public static void main(String[] args) {
		//HashSet은 데이터의 순서가 없으나(등록된 순서를 알 수 없음)  TreeSet은 자동 정렬 기능이 있음
		
		TreeSet<String> ts = new TreeSet<>();
		
		// 영어 대문자를 문자열로 변환해 TreeSet에 저장
		for(char ch='Z'; ch>='A';ch--) { // 정렬되는지 확인하려고 일부러 뒤에서부터 데이터 삽입
			String temp = String.valueOf(ch);
			ts.add(temp);
		}
		System.out.println("TreeSet 자료: "+ ts);
		
		//TreeSet에 저장된 자료 중 특정한 자료보다 작은 자료를 찾아서
		//SortedSet으로 변환하는 메소드가 있다 
//			=> headSet(기준값)메소드 (기본적으로 '기준값'을 포함시키지 않는다)
		//  => headSet(기준값, 논리값) (논리값이 true이면 '기준값'을 포함)
		SortedSet<String> ss1 = ts.headSet("K");
		System.out.println("K 이전 자료: " + ss1); // 기준값 미포함  // a~k전까지
		System.out.println("K 이전 자료(기준값 포함): "+ ts.headSet("K", true)); //기준값 포함 a~k까지
		
		// '기준값'보다 큰 자료를 찾아SortedSet으로 반환하는 메소드
		// tailSet(기준값) => 기본적으로 '기준값'을 포함시킴
		// tailSet(기준값,논리값) => 논리값이 false이면 '기준값'을 포함하지 않음
		SortedSet<String> ss2 = ts.tailSet("K");
		System.out.println("K 이후 자료:" + ss2); // k이후~z까지
		System.out.println("K 이후 자료(기준값 포함) : " + ts.tailSet("K", false)); // k~z까지
		
		// subSet(기준값1, 기준값2) => 기준값1~기준값2 사이의 값을 가져온다
		// 기준값1을 포함하고 기준값2는 포함하지 않고 값을 가져온다
		// subSet(기준값1, 논리값1, 기준값2, 논리값2) => 각 기준값을 포함할 지 여부 설정(논리값이 true이면 포함, false이면 미포함)
		System.out.println("K(포함)부터 N(미포함)까지: " +ts.subSet("K", "N"));
		System.out.println("K(포함)부터 N(포함)까지: " +ts.subSet("K", true, "N",true));
		System.out.println("K(미포함)부터 N(미포함)까지: " +ts.subSet("K",false, "N",false));
		System.out.println("K(미포함)부터 N(포함)까지: " +ts.subSet("K",false, "N",true));
		
		
	}
}
