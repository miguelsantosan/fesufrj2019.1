package model;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import model.server.MySQLConnector;
import controller.ScenesManager;

public class Main extends Application {
	
	
	ScenesManager manager = new ScenesManager();
	
	@Override
    public void start(Stage primaryStage) throws IOException{
		MySQLConnector.abrirConexao();
		
    	manager.mostrarTelaDeLogin();
        ScenesManager.primaryStage.show();
    }
	
	@Override
    public void stop() {
        // executed when the application shuts down
        MySQLConnector.fecharConexao();
    }
	
	

    public static void main(String[] args) {
        launch(args);
    }
}