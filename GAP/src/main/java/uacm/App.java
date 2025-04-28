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
        //stage.initStyle(StageStyle.UNDECORATED); //elimina la barra de titulo del sitema
        
        //carga del fxml                                                  
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/Perfil2.fxml"));
        Parent root = loader.load();
        
        //ajuste automatico para cada pantalla, solo funciona si pones el tu fxml en la linea de arriba
        //Rectangle2D tamPantalla = Screen.getPrimary().getVisualBounds();
        //scene = new Scene(root, tamPantalla.getWidth(), tamPantalla.getHeight());

        //scene = new Scene(barraPersonalizada.cargaBarra(stage, root) ,600,400); //carga la barra personalizada
        scene = new Scene(root,900,600);
        stage.setResizable(true);//permite ajustar el tamaño de la interfaz con le mause
        stage.setTitle("AjoloTienda");//añade un titulo a la barra de titulo

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws IOException {
        launch();

        
    }


}
