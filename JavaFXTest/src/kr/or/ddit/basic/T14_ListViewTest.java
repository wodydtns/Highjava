package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class T14_ListViewTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		ListView<String> list = new ListView<>();
		
		Label label = new Label();
		label.setFont(new Font(20));
		
		//ListView에 들어갈 데이터 구성하기
		ObservableList<String> data = FXCollections.observableArrayList(
					"green","gold","red","blue","black",
					"brown","buleviolet","pink","yellow","chocolate"
				);
//		list.setItems(data); // ListView에 데이터 세팅하기 1
		
		//데이터 세팅방법 2
		list.getItems().addAll("green","gold","red","blue","black",
					"brown","buleviolet","pink","yellow","chocolate");
		
		//ListView에 값이 선택되었을 때 처리
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				label.setText(newValue); // 현재 선택된 값 -> newValue / 이전에 선택된 값 -> oldValue
				label.setTextFill(Color.web(newValue)); // 글자 색 변경
			}	@Override
			public Listcell<String cell(ListView<String> param){
				return new ListCell<String>()
						protected void updateItem(String item,boolean empty) {
					 	super.updateItem(item,empty);
					 	
					 	//변경되는 데이터가 문자열이면 setText() 사용
					 	//setText(item);
					 	
					 	Rectangle rect = new Rectangle(100,20);
					 	if(item != null) { // 또는 !empty
					 		rect.setFill(Color.web(item));
					 		
					 		Label lblTxt = new Label(item);
					 		lblTxt.setTextFill(Color.web(item));
					 		
					 		HBox hb2 = new Hbox(10);
					 		hb2.getChildren().addAll(rect,lblTxt, new ImageView
					 				(new Image(getClass().getResourceAsStream("images/Security.png"))));
					 	}
				}
		});
		
		//ListView의 내용은 변경하지 않고 화면에 보이는 부분만 변경하는 방법
	
		list.setCellFactory(new Callback<ListView<String>, ListCell<String>>(
				) {

					@Override
					public ListCell<String> call(ListView<String> param) {
						
						return new ListCell<String>()
								protected void updateItem(String item,boolean empty) {
						 	super.updateItem(item,empty);
						 	
						 	//변경되는 데이터가 문자열이면 setText() 사용
						 	//setText(item);
						 	
						 	Rectangle rect = new Rectangle(100,20);
						 	if(item != null) { // 또는 !empty
						 		rect.setFill(Color.web(item));
						 		
						 		Label lblTxt = new Label(item);
						 		lblTxt.setTextFill(Color.web(item));
						 		
						 		HBox hb2 = new Hbox(10);
						 		hb2.getChildren().addAll(rect,lblTxt, new ImageView
						 				(new Image(getClass().getResourceAsStream("images/Security.png"))));
					}
			
		});
		
	
	}
	public static void main(String[] args) {
		launch(args);
	}

}	
