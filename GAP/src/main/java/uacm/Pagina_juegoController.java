package uacm;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Pagina_juegoController implements Initializable {

    @FXML
    private Text txt_tituloJuego;
    @FXML
    private Button btn_agregaraAlCarrito;
    @FXML
    private Button btn_Comprar;
    @FXML
    private AnchorPane anchoPane_paginaJuego;
    @FXML
    private BorderPane borderPane;
  
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        //modificando le color de los botones y el texto
        btn_agregaraAlCarrito.setStyle("#FFADF4");
        btn_agregaraAlCarrito.setBackground(new Background(new BackgroundFill(Color.web("#A057B4"),new CornerRadii(5), Insets.EMPTY)));

        btn_Comprar.setStyle("#FFADF4");
        btn_Comprar.setBackground(new Background(new BackgroundFill(Color.web("#A057B4"),new CornerRadii(5), Insets.EMPTY) ) );

        txt_tituloJuego.setStyle("#FFADF4");
        txt_tituloJuego.setText("HolaMundo");

      
    }

}
