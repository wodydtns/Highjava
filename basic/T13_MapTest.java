package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class T13_MapTest {
	/*
	 * Map => key값과 value값을 한 쌍으로 관리하는 객체
	 * 	   => key값은 중복을 허용x 순서없음, value값은 중복 허용o
	 *     
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
	
		//자료 추가 => put(key값, value값) -> 자체 인터페이스를 가지고 있어서 list,set에서 값을 추가하는 add와 다른 예악어 사용
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1111-1111");
		
		System.out.println("map => " + map);
		
		//자료 수정=> 데이터를 저장할 때 key값이 같으면 나중에 입력한 값이 저장된다 / put(수정할key값, 새로운value값)
		// 이미 있는 key값을 가지고 접근해서 수정해야함
		
		map.put("addr", "서울");
		System.out.println("map => " + map);
		
		// 자료 삭제 => remove(삭제할 key값)
		map.remove("name");
		System.out.println("map => " + map);
		
		// 자료 읽기 => get(key값)
		System.out.println("addr = " + map.get("addr"));
		System.out.println("================================");
		
		//key값들을 읽어와 자료를 출력하는 방법
		// 방법1 => keySet() 메소드 사용
		// keySet()메소드 => Map의 key값들만 읽어와 Set형으로 반환
		
		Set<String> keySet = map.keySet();
		System.out.println("Iterator를 이용한 방법");
		
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("================================");
		
		//방법2 => Set형의 데이터를 '향상된 for문'으로 처리 -> Iterator 미사용
		System.out.println("향상된 for문을 이용하는 방법");
		
		for(String key:keySet) {
			System.out.println(key + " : " + map.get(key));
		}
		
		//방법3 => value값만을 읽어와 출력 =>? values()메소드 사용
		System.out.println("================================");
		System.out.println("values() 메소드를 이용하는 방법");
		for(String value:map.values()) {
			System.out.println(value);
		}
		System.out.println("================================");
		
		//방법 4=> Map에는 Entry라는 내부 class가 있음 -> 
		// Entry 클래스는 key, value라는 멤버변수로 구성되어 있음
		// Map에서 이 Entry클래스들을 Set형식으로 저장해 관리
		// 데이터 무결성을 위해 key,value라는 한 쌍으로 묶어놓았음 == Entry
		
		// Entry객체 전체를 가져오기(가져온 Entry들은 Set형식으로 되어 있음), 
		// => entrySet() 메소드를 이용해 가져옴
		
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		
		// 가져온 Entry객체들을 순서대로 처리하기 위 Iterator 객체로 변환
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		while(entryIt.hasNext()) { // 뽑아올 때 entry 객체를 가져옴 
			Map.Entry<String, String> entry = entryIt.next();  // entry 객체로 가져와야함
			
			System.out.println("key값 : "+ entry.getKey()); // 내부적으로 getkey와 getvalue를 정의해놓음
			System.out.println("value값 : "+ entry.getValue());
			System.out.println();
		}
	
		
	}
}
