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
        stage.setResizable(true);//permite ajustar el tamaño de la interfaz con le mause
        stage.setTitle("AjoloTienda");//añade un titulo a la barra de titulo

        stage.setScene(scene);
        stage.show();

    }


    
/* 

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

//evento tareas temporizador
    private static Parent loadFXML(String fxml) throws IOException {
        String fxmlPath;

        switch (fxml) {
            case "Login":
                fxmlPath = PathsFXMLS.LOGIN;
                break;
            case "Perfil":
                fxmlPath = PathsFXMLS.PERFIL;
                break;
            case "OlvidoContrasena":
                fxmlPath = PathsFXMLS.OLVIDO_CONTRASENA;
                break;
            default:
                throw new IOException("Archivo FXML no encontrado: " + fxml);
        }

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlPath));
        return fxmlLoader.load();
    }
 
*/

    public static void main(String[] args) {
        launch();

        
    }
}
