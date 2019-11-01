package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T06_ListSortTest {
	/*
	 * 정렬과 관련된 interface에는 Comparable & Comparator가 있다 
	 * - 보통 객체 자체에 정렬기능을 넣기 위해 Comparable을 구현 
	 * - 정렬기준을 별도로 구현하고 싶다면 Comparator를 구현
	 * 
	 * -Comparable 에서는 compareTo() 메소드 구현
	 *  Comparator 에서는 compare() 메소드 구현
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬 전: "+ list);
		
		//정렬은 Collections.sort() 메소드를 이용해 정렬
		// 정렬은 기본적으로 ' 오름차순 정렬' 수행
		// 정렬 방식을 변경하려면 정렬방식을 결정하는 객체를 만들어 
//		   Collections.sort()메소드에 인수를 넘겨주면 된다.
		Collections.sort(list);
		System.out.println("정렬 후: "+list );
		
		Collections.shuffle(list); // 데이터를 섞어준다
		System.out.println("자료가 섞인 후: " +list);
		
		//정렬방식을 결정하는 객체를 이용해 정렬
		Collections.sort(list, new Desc());
		
		System.out.println("정렬 후: "+list);
	}
}

/*
 * 정렬방식을 결정하는 class는 Comparator라는 인터페이스를 구현해야함
 * 이 Comparator인터페이스의 compare()라는 메소드를 재정의해 구현하면 된다
*/
class Desc implements Comparator<String>{
	
	/*
	 *  compare()메소드의 반환값을 결정하는 방법
	 *  - 이 메소드가 양수를 반환하면 두 값의 순서가 바뀐다
	 *  
	 *  - 오름차순 정렬일 경우 
	 *  -> 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환
	 *  
	 *  - String 객체에는 정렬을 위해 compareTo() 메소드가 구현되어 있다
	 *  - 이 메소드의 반환값은 오름차순으로 반환하도록 구현되어 있다
	 *  	(Wrapper 클래스,Date,File 클래스에도 구현되어 있음)
	 */
	
	@Override
	public int compare(String str1, String str2) { // 리스트 안에 값 2개를 가져오는 것
		
		return str1.compareTo(str2)* -1; // 내림차순으로 만들기 위해서 사용 - 디폴트가 오름차순이므로 -1을 곱해줘야 역순으로 가능
	}
	
}
