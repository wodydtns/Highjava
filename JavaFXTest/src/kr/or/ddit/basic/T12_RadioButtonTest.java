package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T12_RadioButtonTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 라디오 버튼을 묶음으로 처리할 객체 생성
		// 여러 가지 선택지 중 하나만 선택 가능함 
		ToggleGroup group = new ToggleGroup();
		
		ImageView icon = new ImageView(); // 이미지를 보기 위한 객체 ImageView
		
		RadioButton rb1 = new RadioButton("HOME");
		rb1.setToggleGroup(group); // 라디오 버튼을 그룹에 추가
		rb1.setUserData("Home"); // 유저가 선택했을 때의 값을 나타내기 위한 데이터 설정
		
		RadioButton rb2 = new RadioButton("CALENDAR");
		rb2.setToggleGroup(group);
		rb2.setUserData("CALENDAR");
		
		RadioButton rb3 = new RadioButton("Contacts");
		rb3.setToggleGroup(group);
		rb3.setUserData("Contacts"); // <-> getUserData
		// 그룹 내에서 RadioButton 중 하나가 선택되었을 때 처리하기
		// 클릭하면 change 이벤트가 발생
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				//선택된 항목(라디오버튼)이 있는 지 검사
				if(group.getSelectedToggle().getUserData() != null) {
					String url = group.getSelectedToggle().getUserData().toString(); // 유저가 선택한 토글 url
					Image img = new Image(getClass().getResourceAsStream("images/"+url+".jpg"));
					icon.setImage(img);
				}
			}
		});
		
		rb1.setSelected(false); // 선택된 상태로 설정하기 - 기본설정값
//		rb1.isSelected() -- 라디오 버튼1이 선택되었는가
		
		HBox hbox = new HBox();
		VBox vbox = new VBox();
		
		vbox.getChildren().addAll(rb1,rb2,rb3);
		vbox.setSpacing(10);
		hbox.getChildren().addAll(vbox,icon);
		hbox.setSpacing(50);
		hbox.setPadding(new Insets(10));
		
		Scene scene = new Scene(hbox,250,150);
		primaryStage.setTitle("라디오버튼 예제");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
