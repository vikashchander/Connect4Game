package com.javaFx;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public Label welcome;
	@FXML
	public ChoiceBox<String> choicebox;
  @FXML
  public TextField textfield;
	@FXML
	public Button convert;

	private static final String C_to_F_text= "Celsius to Fahrenheit";
	private static final String F_to_C_text ="Fahrenheit to Celsius";

	private boolean isC_to_F = true;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
       choicebox.getItems().add(C_to_F_text);
       choicebox.getItems().add(F_to_C_text);
       choicebox.setValue(C_to_F_text);
       choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
       {if(newValue.equals(C_to_F_text)){
       	isC_to_F = true;
       }else{
       	isC_to_F = false;   
       }


       });
		convert.setOnAction(event -> {
      	convert();
			//System.out.println("Button is Clicked");


      });
	}

	private void convert() {
	String input = textfield.getText();
	float enteredTemperature = 0.0f;
	try{
		enteredTemperature = Float.parseFloat(input);
	}
	catch(Exception e){
        warnUser();
        return;
		}
	float newTemperature =  0.0f;
	if(isC_to_F){
		newTemperature = (enteredTemperature *9/5) + 32;
	}
	else {
		newTemperature = (enteredTemperature -32)*5/9;
	}
	display(newTemperature);
	}

	private void warnUser() {
	Alert alert = new Alert(Alert.AlertType.ERROR);
	alert.setTitle("Error Occrance");
	alert.setHeaderText("Error : Invalid Input");
	alert.setContentText("Invalid temperature");
	alert.show();
	}

	private void display(float newTemperature) {
		String unit = isC_to_F?" F": " C";
		System.out.println("the temperature is : "+ newTemperature +unit);
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("conversion");
		alert.setHeaderText("Temperature Converter");
		alert.setContentText("the new temperature is "+newTemperature+unit);
		alert.show();

	}
}
