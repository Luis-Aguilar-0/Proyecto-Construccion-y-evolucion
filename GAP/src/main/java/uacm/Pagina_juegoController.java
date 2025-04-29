package uacm;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Pagina_juegoController implements Initializable {
    @FXML
    private Label lb_rMinimos;
    @FXML
    private Label lb_rRecomendados;
    @FXML
    private Label lb_infoJuego;
    @FXML
    private Label lb_descripsion;
    @FXML
    private BorderPane borderPaneImagen;
    @FXML
    private ImageView imgLeft;
    @FXML
    private ImageView imgCentro;
    @FXML
    private ImageView imgRight;
    @FXML
    private Pane paneImagenPrincipal;
    @FXML
    private ImageView imagenPrimcipal;
    @FXML
    private Text txt_tituloJuego;
    @FXML
    private Button btn_agregaraAlCarrito;
    @FXML
    private Button btn_Comprar;
    @FXML
    private AnchorPane anchoPane_paginaJuego;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        // cambio de imagenes
        imgLeft.setOnMouseClicked(event -> {

            imagenPrimcipal.setImage(imgLeft.getImage());

        });
        imgCentro.setOnMouseClicked(event -> {

            imagenPrimcipal.setImage(imgCentro.getImage());

        });
        imgRight.setOnMouseClicked(event -> {
            imagenPrimcipal.setImage(imgRight.getImage());
        });

        System.out.println("Intentando establecer el texto del Label");
        lb_rMinimos.setWrapText(true);

        lb_rMinimos.setText("Los requisitos minimos son 10Gb ram \n como minimo una tarjeta grafica de 16GB ram cvavacvagsfdgafdgasfdSFASDFASDF " );
       

    }

}
