package kr.or.ddit.basic;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

public class ControllControll implements Initializable{

	@FXML private RadioButton male;
	@FXML private RadioButton female;
	@FXML private CheckBox mountain;
	@FXML private CheckBox travel;
	@FXML private CheckBox reader;
	@FXML private CheckBox baduk;
	@FXML private CheckBox janggi;
	@FXML private CheckBox game;
	@FXML private CheckBox tennis;
	@FXML private CheckBox badmin;
	@FXML private TextField userName;
	@FXML private TextArea txtResult;
	@FXML private Button sum;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
						
		ToggleGroup group = new ToggleGroup();
		
		male.setToggleGroup(group);
		female.setToggleGroup(group);
		male.setSelected(true);
		
	}
	@FXML
	public void btnClick(ActionEvent event) {
		
			String name = userName.getText();
			String result = "";
			String gender = "";
			if(male.isSelected()) {
				gender += "남자";
			}else {
				gender += "여자";
			}
			if(mountain.isSelected()) {
				result +=  "등산, ";   
			}
			if(travel.isSelected()) {
				result +=  "여행, ";   
			}
			if(reader.isSelected()) {
				result +=  "독서, ";   
			}
			if(baduk.isSelected()) {
				result +=  "바둑, ";   
			}
			if(janggi.isSelected()) {
				result +=  "장기, ";   
			}
			if(game.isSelected()) {
				result +=  "게임, ";   
			}
			if(tennis.isSelected()) {
				result +=  "테니스, ";   
			}
			if(badmin.isSelected()) {
				result +=  "배드민턴, ";   
			}
			txtResult.appendText(name +"님은" + gender+ "이고 취미는" + result +"입니다.");
		};
		
	}
	






