package uacm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Frncs.Fox
 */
public class RecargaAxolotlController implements Initializable {

    @FXML
    private Button regreso_bttn;
    @FXML
    private RadioButton magic_radioBttn;
    @FXML
    private ToggleGroup paqueteSelectro;
    @FXML
    private RadioButton legend_radioBttn;
    @FXML
    private RadioButton god_radioBttn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        regreso_bttn.setOnAction(eh ->{
            try{
                //cargar el archivo FXML de la ventana anterior
                Parent root = FXMLLoader.load(getClass().getResource("/fxmls/InicioGap.fxml"));
                
                //obtener el stage actual desde el boton
                Stage stage = (Stage) ((Node) eh.getSource()).getScene().getWindow();
                
                //remplazar la escena
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                
            }catch(IOException e){
                e.printStackTrace();
            }
        });
        
        System.out.println(paqueteSelectro.getSelectedToggle());
        
        
    }    
    
}
