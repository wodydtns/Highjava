package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class T04_FxmlLayout extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
			// fxml 파일을 로딩해서 현재 stage에 적용하기
		
		//Parent 객체는 모든 컨테이너의 조상 객체
		
		//방법 1 - except 절대 경로로 지정할 수도 있음
		//getClass().getResource("FxmlLayout.fxml") 현재 클래스 기준 
		/*
		Parent root = FXMLLoader.load(getClass().getResource("FxmlLayout.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("fxml문서를 이용한 레이아웃");
		primaryStage.setScene(scene);
		primaryStage.show();
	}	*/
		//방법2 
		// FXMLLoad의 인스턴스를 이용해 fxml파일을 로딩하는 방법
		// => 나중에 인스턴스를 이용해 해당 fxml의 컨트롤러 객체를 가져올 수 있다.
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FxmlLayout.fxml"));
		Parent root = loader.load(); // loader의 인스턴스 객체 사용
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("fxml문서를 이용한 레이아웃");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);	
	}
	

}
