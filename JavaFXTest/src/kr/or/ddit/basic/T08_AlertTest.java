package kr.or.ddit.basic;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class T08_AlertTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Alert alertInformation = new Alert(AlertType.INFORMATION);
		
		alertInformation.setTitle("INFORMATION");
		alertInformation.setContentText("INFORMATION Alert창입니다.");
		alertInformation.showAndWait(); // Alert창 보이기
		
		//==========================================================
		Alert alertError = new Alert(AlertType.ERROR);
		
		alertError.setTitle("ERROR");
		alertError.setContentText("ERROR Alert창입니다.");
		alertError.showAndWait();
		
		//==========================================================
		
		Alert alertWarning = new Alert(AlertType.WARNING);
		alertWarning.setTitle("WARNING");
		alertWarning.setContentText("WARNING Alert창입니다");
		alertWarning.showAndWait();
		//==========================================================
		
		Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
		alertConfirm.setTitle("CONFIRMATION");
		alertConfirm.setContentText("CONFIRMATION Alert창입니다.");
		
		// Alert창을 보여주고 사용자가 누른 버튼 값 읽어오기
		ButtonType confirmResult = alertConfirm.showAndWait().get();
		
		if(confirmResult == ButtonType.OK) {
			System.out.println("OK버튼을 눌렀습니다.");
			
		}else if(confirmResult == ButtonType.CANCEL) {
			System.out.println("취소버튼을 눌렀습니다.");
		}
		//==========================================================
		
		//Javascript의 prompt 창과 같은 기능
		TextInputDialog javaPrompt = new TextInputDialog("기본값");
		
		javaPrompt.setTitle("PROMPT창"); // 창 제목
		// 출력 메시지
		javaPrompt.setHeaderText("TextInputDialog창입니다.");
		
		// 창을 보이고 입력한 값을 읽어오기
		// Optional 객체 - 타입 안정성을 높이기 위한 객체 - null값을 방지하기 위해서.
		Optional<String> result = javaPrompt.showAndWait();
		String strResult = null; // 입력한 값이 저장될 변수
		
		// 입력한 값이 있는지 없는지 검사(값 입력 후 'OK'버튼 눌렸는 지 검사)
		if(result.isPresent()) {
			strResult = result.get(); // 값 읽어오기
		}
		System.out.println("읽어온 값 : " + strResult);
		
	}
	public static void main(String[] args) {
		launch(args);
	} 
	
}
