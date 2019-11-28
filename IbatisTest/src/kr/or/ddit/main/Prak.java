package kr.or.ddit.main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import kr.or.ddit.member.vo.MemberVO;

public class Prak extends Application{

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		ObservableList<MemberVO> data =
				FXCollections.observableArrayList();
		TableView<MemberVO> table = new TableView<>(data);
		
		TableColumn<MemberVO,String> idCol = new TableColumn<>("아이디");
		TableColumn<MemberVO,String> nameCol = new TableColumn<>("이름");
		TableColumn<MemberVO,String> telCol = new TableColumn<>("전화번호");
		TableColumn<MemberVO,String> addrCol = new TableColumn<>("주소");
		for(MemberVO mv : data) {
			
		idCol.setCellValueFactory(new PropertyValueFactory<>(mv.getMem_id()));
		
		nameCol.setCellValueFactory(new PropertyValueFactory<>(mv.getMem_name()));
				
		telCol.setCellValueFactory(new PropertyValueFactory<>(mv.getMem_tel()));
		
		addrCol.setCellValueFactory(new PropertyValueFactory<>(mv.getMem_addr()));
		
		table.getColumns().addAll(idCol,nameCol,telCol,addrCol);
		}
		root.setCenter(table);
		Scene scene = new Scene(root);
		primaryStage.setTitle("테스트");
		primaryStage.setScene(scene);
		primaryStage.show();

		
	}
	public static void main(String[] args) {
		launch(args);
	}
		
				
}
