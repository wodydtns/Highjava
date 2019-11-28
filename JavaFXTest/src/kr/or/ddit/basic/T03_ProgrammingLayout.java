package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T03_ProgrammingLayout extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		//HBox 컨테이너 생성
		HBox hbox = new HBox();
		
		//안쪽 여백 설정하기
		//Insets객체는 값을 주는 순서가 위, 오른쪽, 아래, 왼쪽 순으로 설정
		hbox.setPadding(new Insets(50,50,50,50));
//		hbox.setPadding(new Insets(50));
//		hbox.setMargin(btn,new Insets(50));
		hbox.setSpacing(50); // 컨트롤과 컨트롤 사이의 간격
		
		//한줄의 데이터를 입력받는 컨트롤 : TextField 객체
		TextField txtField = new TextField();
		txtField.setPrefWidth(200); // TextField의 넓이 크기 설정
		
		Button btn = new Button("확 인"); //버튼 객체 생성
		
		//HBox 추가하기
//		hbox.getChildren().addAll(txtField,btn); // 넣는 순서 중요 - 넣는 순서대로 보여준다.
		hbox.getChildren().addAll(btn,txtField);
		//Scene 객체 생성
		Scene scene = new Scene(hbox);
		primaryStage.setTitle("자바코드를 이용한 레이아웃 설정하기");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
