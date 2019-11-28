package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	   @Override
	   public void start(Stage primaryStage) {
	      Stage primaryStage1 = new Stage();
	        Parent root;
	      try {
	         root = FXMLLoader.load(getClass().getResource("./asdf.fxml"));
	         Scene scene = new Scene(root);
	         scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	         primaryStage1.setScene(scene);
	         primaryStage1.show();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }


	   }
	   
	   public static void main(String[] args) {
	      launch(args);
	   }
	}