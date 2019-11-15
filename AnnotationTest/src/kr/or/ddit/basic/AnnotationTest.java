package kr.or.ddit.basic;

import java.lang.reflect.Method;
//리플렉션이란 객체를 통해 클래스의 정보를 분석해 내는 프로그램 기법


public class AnnotationTest {
	public static void main(String[] args) throws Exception{
		
		System.out.println(PrintAnnotaion.id);
		
		//reflection 기능을 이용한 메소드 실행 
		// 메소드 타입의 배열 생성
		Method[] declaredMethods = Service.class.getDeclaredMethods(); // Service.class -> Service 클래스의 정보 가져오기
		
		for(Method m : declaredMethods) {
			System.out.print(m.getName());//메소드명 출력 getDeclaredAnnotation<- 어노테이션에 접근하는 메소드
			for(int i=0;i<m.getDeclaredAnnotation(PrintAnnotaion.class).count(); i++) { // PrintAnnotaion.class타입 
				//PrintAnnotation의 count값 만큼 반복
				System.out.print(m.getDeclaredAnnotation(PrintAnnotaion.class).value());
				//PrintAnnotation의 value값 출력
			}
			System.out.println(); //줄바꿈
			
			//메소드 정보를 m으로 가져옴 -> 객체 생성 후 실행하는 것과 동일
			m.invoke(new Service());  //reflection기능을 이용한 메소드 실행
		}
	}
}
