package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.stage.Stage;
/*
 * Stage (무대) : Window browser
 * Scene (장면) : 무대에서 하나의 장면이 배치된다.
 * 	-javaFX가 실행되는 순서
 * 	  main() 메소드 -> launch()메소드 -> 해당 객체의 생성자 메소드
 *  	=> init()메소드 => start() 메소드 => 사용 후 종료
 *  	=> stop() 메소드
 */
public class T01_JavaFXLifeCycle extends Application {

	public T01_JavaFXLifeCycle() {
		System.out.println(
				Thread.currentThread().getName() + " : 생성자 호출");
	}
	@Override
	public void init() throws Exception {
		System.out.println(
				Thread.currentThread().getName() + " : init() 호출");
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println(
				Thread.currentThread().getName() + " : stop() 호출");
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(
				Thread.currentThread().getName() + " : start() 호출");
		primaryStage.show(); // 윈도우 창 하나 띄우기
	}
	
	public static void main(String[] args) {
		System.out.println(
				Thread.currentThread().getName() + " : main() 호출");
		launch(args);
	}
	
}
