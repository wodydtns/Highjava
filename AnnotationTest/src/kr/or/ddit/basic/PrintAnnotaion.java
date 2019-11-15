package kr.or.ddit.basic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * annotation : 프로그램 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시킨 것
 * (JDK1.5부터 지원)
 * 주석처럼 프로그래밍 언어에 영향을 미치지 않으면서도 다른 프로그램에 유용한 정보를 제공
 * 
 * 종류 : 1. 표준 애너테이션(주로 컴파일러에게 유용한 정보 제공을 위한 애너테이션)
 * 		 2. 메타 애너테이션(애너테이션을 위한 애너테이션, 애너테이션 정의 시 사용하는 애너테이션)
 * 		 
 * 애너테이션 타입 정의하기
 * @interface 애너테이션이름 {
 * 		타입요소이름(); // 반환값이 있고 매개변수는 없는 추상메소드 형태
 * 		...
 * }
 * 애너테이션 요소의 규칙
 * 1. 요소의 타입은 기본형, String, enum, annotation, class만 허용
 * 2. ()안의 매개변수를 선언할 수 없다.
 * 3. 예외를 선언할 수 없다.
 * 4. 요소의 타입에 타입 매개변수(지네릭타입 문자)를 사용할 수 없다.
 */

@Target(ElementType.METHOD) // annotation이 적용가능한 대상을 지정
@Retention(RetentionPolicy.RUNTIME) // 유지되는 기간(SOURCE, CLASS:기본, RUNTIME)
//SOURCE, CLASS:기본, RUNTIME / source는 컴파일 전까지 유지 / class / runtime - 실행까지 유지
public @interface PrintAnnotaion { //PrintAnnotaion 어노테이션의 이름
	int id = 100; // 상수선언 가능, static final int id = 100;와 동일함 
	String value() default "-"; // 기본값을 '-'로 지정 , 파라미터를 넣을 수 없다.
	int count() default 20; // 기본값을 20으로 지정
	
}
