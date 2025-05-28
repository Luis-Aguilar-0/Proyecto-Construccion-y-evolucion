package uacm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.Usuario;
import persistencia.Sesion;
import persistencia.UsuarioDAO;

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
    @FXML
    private Text text_paquetes;
    @FXML
    private Pane pane_text;
    @FXML
    private Button agregarTarjeta_bttn;
    @FXML
    private Label nombrePaquete_label;
    @FXML
    private Label precioPaquete_label;
    @FXML
    private VBox vbox_compra;
    @FXML
    private Label label_falla;
    @FXML
    private Button pagar_bttn;
    @FXML
    private Label marcador_label;
    
    private Integer compra = 0;
    
    private UsuarioDAO usuarioDAO;
    
    private final Usuario u = Sesion.getUsuario();

    private void comprarAjolocoins(){
        if(compra == null){
            return;
        }
        
        boolean exito = usuarioDAO.updateAjolocoins(u.getId(), compra);
        
        if(exito){
            u.setAjoloCoins(u.getAjoloCoins() + compra);
            System.out.println("Los axolocoins aniadidos a la cuenta son: " + compra);
            marcador_label.setText(u.getAjoloCoins() + "Ax");
        }else{
            System.out.println("No se pudo hacer la compra");
        }
    }
    
    private void mostrarCoins(){
        if(u != null && u.getAjoloCoins() != 0){
            marcador_label.setText(u.getAjoloCoins().toString() + "Ax");
        }else{
            marcador_label.setText("0Ax");
        }
    }
    
    private boolean validarTarjeta(){
        return u != null && u.getTarjetaUser() != null;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarCoins();
        
        pagar_bttn.setDisable(true);
        
        try {
            this.usuarioDAO = new UsuarioDAO();
        } catch (SQLException ex) {
            throw new RuntimeException("Error al inicializar UsuarioDAO", ex);
        }
        
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
        
        paqueteSelectro.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            label_falla.setText("");
            pagar_bttn.setDisable(false);
            
            vbox_compra.setVisible(true);
            if (newToggle == magic_radioBttn) {
                pane_text.setPrefHeight(180);
                text_paquetes.setText("""
                                        ¡Descubre el poder del Paquete Mágico!
                                    
                                    Obtén 125 AxoloCoins y desbloquea diversión sin límites con nuestros juegos más encantadores. Usa este poder para explorar mundos, ganar recompensas y vivir la magia del juego.
                                      
                                                                $150.00MX""");
                nombrePaquete_label.setText("  Magic Pack:                                  125Ax");
                precioPaquete_label.setText("  Total a pagar:                     $150.00MX");
                compra = 125;
            } else if (newToggle == legend_radioBttn) {
                pane_text.setPrefHeight(200);
                text_paquetes.setText("""
                                                            ¡Gran eleccion!
                                      
                                      El paquete Legendary te da 525Ax (AxoloCoins), ideal para quienes quieren conquistar cada nivel sin límites. Desbloquea recompensas legendarias con 525 AxoloCoins y lleva tu experiencia al siguiente nivel.
                                      
                                                                    $499.00MX""");
                nombrePaquete_label.setText("  Legendary Pack:                        525Ax");
                precioPaquete_label.setText("  Total a pagar:                     $499.00MX");
                compra = 525;
            } else if (newToggle == god_radioBttn) {
                pane_text.setPrefHeight(200);
                text_paquetes.setText("""
                                                ¡Que te pareceria mas potencia!
                                      
                                      Con 1000Ax (AxoloCoins), el paquete God te coloca en la cima del poder. ¡Juega sin límites y conquista todo! Da el salto definitivo. Con 1000Ax, el paquete God te transforma en el jugador que todos quieren ser.
                                      
                                                                    $899.00MX""");
                nombrePaquete_label.setText("  God Pack:                                  1000Ax");
                precioPaquete_label.setText("  Total a pagar:                     $899.00MX");
                compra = 1000;
            }
        });
        
        agregarTarjeta_bttn.setOnAction(eh -> {
            label_falla.setText("");
            
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/AgregarTarjeta.fxml"));
                Parent root = loader.load();

                Stage nuevaVentana = new Stage();
                nuevaVentana.setScene(new Scene(root));
                nuevaVentana.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        pagar_bttn.setOnAction(eh ->{        
            if(validarTarjeta()){
                comprarAjolocoins();
            }else{
                label_falla.setText("Porfavor agrega una tarjeta para realizar la compra.");
                
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Tarjeta no registrada");
                alerta.setHeaderText(null);
                alerta.setContentText("Necesitas agregar una tarjeta para completar tu compra.");
                alerta.showAndWait();
            }
        });
        
    }    
}
