package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T09_ComboBoxTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		HBox hbox = new HBox();
		TextArea txtArea = new TextArea();
		
		ComboBox<String> combo = new ComboBox<>();
		combo.getItems().addAll("한강","금강","영산강","낙동강");
		combo.setValue("한강"); // 처음에 보이는 부분의 데이터 세팅
		
		//방법 1 . ComboBox의 값이 변경될 때의 처리 => change 이벤트 처리
		//ComboBox<String> 이벤트 발생하는 곳
		//getSelectionModel() > 데이터를 관리하는 모델 객체
//		getSelectedItem()  > 모델 내 요소 가져오기
		combo.setOnAction(e->{
//			System.out.println(((ComboBox<String>)e.getSource()).getSelectionModel().getSelectedItem());
			txtArea.setText((((ComboBox<String>)e.getSource()).getSelectionModel().getSelectedItem()));
		});
//	위와 동일
//		combo.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event) {
//				txtArea.setText((((ComboBox<String>)e.getSource()).getSelectionModel().getSelectedItem()));
//			}
//		});
		
		//방법2)
		// new ChangeListener 값이 변경되는 것을 eventlistner
		//combo객체에 listener를 추가 
		// change 변화 이벤트를 듣는 부분
		combo.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				txtArea.setText(oldValue);
			}	
		});
		
		ObservableList<String> fruitList = FXCollections.observableArrayList("사과","배","복숭아","포도","김");
		
		// 객체 생성 및 데이터 초기화를 동시에 실행
		ComboBox<String> combo2 = new ComboBox<>(fruitList);
		
		// 데이터를 초기화 후 추가하기
		combo2.getItems().addAll("대추","호두");
		
		combo2.setValue("포도");
		Button button = new Button("확인");
		
		button.setOnAction(e->{
			if(combo.getValue() != null && combo2.getValue() != null) {
				txtArea.setText(combo.getValue() + " 지역에는 " + combo2.getValue() + " 가 유명합니다.");
				
			}
		});
		hbox.setSpacing(10);
		hbox.setPadding(new Insets(10));
		hbox.getChildren().addAll(combo,combo2,button);
		
		root.setTop(hbox);
		root.setCenter(txtArea);
		
		Scene scene = new Scene(root,500,400);
		primaryStage.setTitle("ComboBox연습");
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}	
	public static void main(String[] args) {
		launch(args);
	}

}
