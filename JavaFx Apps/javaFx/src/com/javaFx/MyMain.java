package com.javaFx;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MyMain extends Application {
public static void main(String[] args){
System.out.println("Main");
	launch(args);
}

	@Override
	public void init() throws Exception {
	System.out.println("init");
	super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	System.out.println("Start");
	 FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar =createMenu();
		rootNode.getChildren().add(0, menuBar);
		Scene scene = new Scene(rootNode, 300, 275);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter");
		primaryStage.show();
	}
  private MenuBar createMenu(){
	  Menu fileMenu = new Menu("File");
	  MenuItem newFlie = new MenuItem("New");
	  newFlie.setOnAction(event -> System.out.println("new is clicked"));

	  /*newFlie.setOnAction(new EventHandler<ActionEvent>() {
		  @Override
		  public void handle(ActionEvent event) {
			  System.out.println("new is clicked");
		  }
	  });*/
	  SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
	  MenuItem saveFile = new MenuItem("Save");
	  SeparatorMenuItem separatorMenuItem2 = new SeparatorMenuItem();
	  MenuItem Quit = new MenuItem("Quit");
	  Quit.setOnAction(event ->
	  {Platform.exit();
	  System.exit(0);             // Lamda expression
	  });
	  /* Quit.setOnAction(new EventHandler<ActionEvent>() {
		  @Override
		  public void handle(ActionEvent event) {
			  Platform.exit();
			  System.exit(0);
		  }
	  }); */
	  fileMenu.getItems().addAll(newFlie, separatorMenuItem, saveFile, separatorMenuItem2,Quit);

	  // helpMenu
	  Menu helpMenu = new Menu("Help");
	  SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
	  MenuItem aboutApp = new MenuItem("About App");
	  aboutApp.setOnAction(event -> aboutApp());
	  MenuItem aboutDeveloper = new MenuItem("About Developer");
	  aboutDeveloper.setOnAction(event -> aboutDeveloper());
	  helpMenu.getItems().addAll(aboutApp, separatorMenuItem1,aboutDeveloper);

	  //menuBar
	  MenuBar menuBar = new MenuBar();
	  menuBar.getMenus().addAll(fileMenu, helpMenu);
	  return menuBar;
  }

	private void aboutDeveloper() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("About Developer");
		alertDialog.setHeaderText("Vikash Chander");
		alertDialog.setContentText("I Love To Play Around With Code And Create Games ");
		alertDialog.show();
	}

	private void aboutApp(){
	  Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
	  alertDialog.setTitle("My First Desktop App");
	  alertDialog.setHeaderText("Learning JavaFx");
	  alertDialog.setContentText("This App For Learning Purpose..........");

	  alertDialog.show();
	}
	@Override
	public void stop() throws Exception {
	System.out.println("Stop");
	  super.stop();
	}
}
