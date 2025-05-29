package uacm;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;
    //private barraPersonalizada o;

    @Override
    public void start(Stage stage) throws IOException {
        //carga del fxml                                                  
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/Login.fxml"));
        Parent root = loader.load();
       
        scene = new Scene(root,900,600);
        stage.setResizable(false);//permite ajustar el tamaño de la interfaz con le mause
        stage.setTitle("AjoloTienda");//añade un titulo a la barra de titulo

        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
