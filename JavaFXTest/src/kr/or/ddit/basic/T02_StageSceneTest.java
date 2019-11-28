package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class T02_StageSceneTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox(); // 컨트롤들을 세로로 배치해주는 컨테이너
		root.setPrefWidth(650); // VBox 의 넓이
		root.setPrefHeight(150); // VBox 의 높이
		root.setAlignment(Pos.CENTER); // 컨트롤들을 가운데로 정렬
		root.setSpacing(20); // 컨트롤과 컨트롤 사이의 간격
		
		Label label = new Label(); // Label 객체 생성
		label.setText("안녕하세요 자바FX입니다.");
		label.setFont(new Font(50)); // Font 객체를 이용해 글자크기 설정
		
		Button btn = new Button();
		btn.setText("확인");
		
		// 버튼에 대한 클릭 이벤트 처리
		// 방법1 -> 람다식을 사용하지 않는 경우
			btn.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// 처리할 내용을 기술하는 영역
					Platform.exit(); // 프로그램 종료
				}
			});
		
		//방법 2 -> 람다식 사용
		//btn.setOnAction((ActionEvent event)->{Platform.exit();}); 의 생략
		btn.setOnAction(e->Platform.exit()); // 파라미터 값이라 e,hello도 가능
		
		//vBox에 컨트롤들 추가
		root.getChildren().add(label);
		root.getChildren().add(btn);
		
		//root.getChildren().addAll(label,btn);
		
		//VBox 루트 컨테이너로 하는 Scene 객체 생성
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("stage와 Scene연습"); // 창 제목
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
