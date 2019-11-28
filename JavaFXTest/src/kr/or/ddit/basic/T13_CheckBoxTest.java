package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class T13_CheckBoxTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Rectangle rect = new Rectangle(90,30); // 4각형 그리기
		
		rect.setArcHeight(10); // 둥근 4각형 만들기 위한 꼭지점 모 따기
		rect.setArcWidth(10);
		rect.setFill(Color.rgb(41, 41, 41)); // 4각형 내부 칠하기 // rgb타입으로 설정 
		
		String[] names = new String[] {"Security","Project","Chart"};
		
		Image[] images = new Image[names.length];
		ImageView[] icons = new ImageView[names.length];
		
		CheckBox[] chkboxs = new CheckBox[names.length];

		for(int i=0;i<names.length;i++) {
			// 출력한 이미지 읽어오기
			final Image img = images[i] = new Image(getClass().getResourceAsStream("images/" + names[i]+ ".png"));
			//이미지를 출력하는 객체 생성
			final ImageView icon = icons[i] = new ImageView();
			final CheckBox cb = chkboxs[i] = new CheckBox(names[i]);
			
			cb.selectedProperty().addListener(new ChangeListener<Boolean>() {

				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					//ImageView의 setImage() 메소드는 보여줄 이미지를 세팅하는 메소드
//					icon.setImage(newValue ? img : null);
					
					if(newValue) { // newValue => 체크 상태 / oldValue => 체크 이전의 상태
						icon.setImage(img);
					}else {
						icon.setImage(null); // ImageView에서 이미지 삭제
					}
					
					
				}
			});
		}
		Button btnOK = new Button("확인");
		
		btnOK.setOnAction(e->{
			//CheckBox의 check 여부를 확인하는 방법 
			if(chkboxs[1].isSelected()) {
				showInfo(chkboxs[1].getText() + "체크");
			}else {
				showInfo(chkboxs[1].getText() + "체크 해제");
			}
			//CheckBox의 check여부 세팅하기
			//chkboxs[0].setSelected(true); //체크하기
//			chkboxs[0].setSelected(false); // 체크 해제하기
			chkboxs[0].setSelected(!chkboxs[1].isSelected());
			
		});
		VBox vbox = new VBox(5); // spacing 주기
		vbox.getChildren().addAll(chkboxs);
		vbox.getChildren().add(btnOK);
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(icons);
		hbox.setPadding(new Insets(0,0,0,10));
		//Stackpane 패널을 쌓아서 맨 위에것만 보여줌
		StackPane stack = new StackPane();
		stack.getChildren().addAll(rect,hbox);
		StackPane.setAlignment(rect, Pos.TOP_CENTER);
		
		HBox root = new HBox();
		root.setSpacing(40);
		root.setPadding(new Insets(20,10,10,20));
		root.getChildren().addAll(vbox,stack);
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("CheckBox 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		//StackPane은 컨트롤들을 쌓아노는 방식으로 배치하는 컨테이너
		
	}
	private void showInfo(String msg) {
		Alert alertInfo = new Alert(AlertType.INFORMATION);
		
		alertInfo.setTitle("INFORAMTION");
		alertInfo.setContentText(msg);
		alertInfo.showAndWait();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
