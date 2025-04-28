package uacm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Frncs.Fox
 */
public class InicioGapController {

    @FXML
    private HBox top_hbox;
    @FXML
    private VBox lateral_vbox;
    @FXML
    private Button botonBiblioteca;
    @FXML
    private Button btnDerecha_play;
    @FXML
    private Button btnIzquierda_play;
    @FXML
    private ScrollPane carrucel_scPn_play;
    @FXML
    private ScrollPane carrucel_scPn_box;
    @FXML
    private Button btnDerecha_box;
    @FXML
    private Button btnIzquierda_box;
    @FXML
    private ScrollPane carrucel_scPn_nin;
    @FXML
    private Button btnDerecha_nin;
    @FXML
    private Button btnIzquierda_nin;

    private final double speed_scroll = 0.1;
    
    @FXML
    private void moverIzquierdaPlay(){
        double nuevaPosicion = carrucel_scPn_play.getHvalue() - speed_scroll;
        
        carrucel_scPn_play.setHvalue(Math.max(nuevaPosicion, 0));
    }    
    
    @FXML
    private void moverDerechaPlay(){
        double nuevaPosicion = carrucel_scPn_play.getHvalue() + speed_scroll;
        
        carrucel_scPn_play.setHvalue(Math.min(nuevaPosicion, 1));
    }
    
    @FXML
    private void moverIzquierdaBox(){
        double nuevaPosicion = carrucel_scPn_box.getHvalue() - speed_scroll;
        
        carrucel_scPn_box.setHvalue(Math.max(nuevaPosicion, 0));
    }    
    
    @FXML
    private void moverDerechaBox(){
        double nuevaPosicion = carrucel_scPn_box.getHvalue() + speed_scroll;
        
        carrucel_scPn_box.setHvalue(Math.min(nuevaPosicion, 1));
    }
    
    @FXML
    private void moverIzquierdaNin(){
        double nuevaPosicion = carrucel_scPn_nin.getHvalue() - speed_scroll;
        
        carrucel_scPn_nin.setHvalue(Math.max(nuevaPosicion, 0));
    }    
    
    @FXML
    private void moverDerechaNin(){
        double nuevaPosicion = carrucel_scPn_nin.getHvalue() + speed_scroll;
        
        carrucel_scPn_nin.setHvalue(Math.min(nuevaPosicion, 1));
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        
        
        btnIzquierda_play.setOnAction(e -> moverIzquierdaPlay());
        
        btnDerecha_play.setOnAction(e -> moverDerechaPlay());
        
        btnIzquierda_box.setOnAction(e -> moverIzquierdaBox());
        
        btnDerecha_box.setOnAction(e -> moverDerechaBox());
        
        btnIzquierda_nin.setOnAction(e -> moverIzquierdaNin());
        
        btnDerecha_nin.setOnAction(e -> moverDerechaNin());
    }
}
