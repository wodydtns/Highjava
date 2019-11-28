package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ComboGugudanController implements Initializable {

	@FXML
	private ComboBox<Integer> cmbDan; //fxml에서 동일한 id값을 찾아서 -> 객체를 가져옴 = fxml과 컨트롤러의 id값이 같아야함 
	@FXML 
	private Button btnDan;
	@FXML 
	private TextArea txtResult;
	/*
	 * (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 * fxml에서 값을 읽어온 이후 initialize를 실행함
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Integer> list = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9);
		cmbDan.setItems(list);
		
		btnDan.setOnAction(e->{
			int dan = cmbDan.getSelectionModel().getSelectedItem();
			txtResult.setText(dan + "단\n\n");
			for(int i=1;i<=9;i++) {
				int r = dan * i;
				txtResult.appendText(dan + " * "+ i + " * " + " = " + r + "\n"); // 값을 추가하는 메소드 appendText
			}
		});
	}
	/*
	 *  단 버튼이 클릭되었을 때 처리하는 메소드
	 *  값은 initialize 에서 가져옴
	 */
	// 이벤트로 사용된다는 의미 <-@FXML 
	@FXML 
	public void btnDanClick(ActionEvent event) {
				
		btnDan.setOnAction(e->{
			int dan = cmbDan.getSelectionModel().getSelectedItem();
			txtResult.setText(dan + "단\n\n");
			for(int i=1;i<=9;i++) {
				int r = dan * i;
				txtResult.appendText(dan + " * "+ i + " * " + " = " + r + "\n"); // 값을 추가하는 메소드 appendText
			}
		});
	}

	
	
}
