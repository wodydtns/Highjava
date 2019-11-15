package kr.or.ddit.basic;

import java.util.Enumeration;
import java.util.ResourceBundle;

/*
 * ResourceBundle 객체 => 확장자가 properties인 파일 정보를 읽어와
 * 						 key값과 value값을 분리한 정보를 갖는 객체
 * 				      => 읽어온 파일은 'key값 = value값' 형태로 되어있어야한다.
 */
public class T07_ResourceBundleTest {
	public static void main(String[] args) {
		//ResourceBundle 객체를 이용해 파일 읽어오기
		
		//ResourceBundle객체 생성하기
		// - 파일을 지정할 때 '파일명'만 지정하고 확장자는 지정하지 않는다
		//   => why: 확장자는 항상 properties이기 때문
		
		//bin 바로 아래에 있기 때문에 .. 이 필요없음
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		
		//key값들만 읽어오기
		Enumeration<String> keys = bundle.getKeys();
		
		//key값 개수만큼 반복해서 value값 가져오기
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			
			//key값을 이용해 value값을 읽어오는 방법
			// 		=> bundle객체변수.getString(key값);
			String value = bundle.getString(key);
			System.out.println(key + " => " + value);
			
		}
		System.out.println("출력 완료");
	}
}
