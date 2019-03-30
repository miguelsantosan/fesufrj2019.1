package model;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException{
    	
    	Main.primaryStage = primaryStage;
    	mostrarTelaDeLogin();
        primaryStage.show();
    }

    public void mostrarTelaDeLogin() throws IOException {
    	// Exibe a tela de login
    	Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
        primaryStage.setTitle("Você Aluga");
        primaryStage.setScene(new Scene(root));
    }

   
    
    
    public static void main(String[] args) {
        launch(args);
    }
}