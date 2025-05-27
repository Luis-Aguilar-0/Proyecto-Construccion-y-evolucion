package uacm;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import logic.Juego;
import persistencia.Sesion;

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
    @FXML
    private Label lb_precio;
    @FXML 
    private Label lb_precioAjoloCoins;
    @FXML
    private Button bt_carrito;
    @FXML
    private Button bt_inicio;


    private void mostrarInfo(Juego juego){
        
        // // Asignando las imagenes del juego
        // Image imagenCentro = new Image(getClass().getResource(juego.getImagenes()[1]).toExternalForm());
        // imgCentro.setImage(imagenCentro);
        // Image imagenDerecha = new Image(getClass().getResource(juego.getImagenes()[2]).toExternalForm());
        // imgRight.setImage(imagenDerecha);
        // Image imagenIzquierda = new Image(getClass().getResource(juego.getImagenes()[3]).toExternalForm());
        // imgLeft.setImage(imagenIzquierda);
        // Asiganando las imagenes
        for(int i = 0; i < juego.getImagenes().length;i++){

            Image imagenJuego = new Image(getClass().getResource(juego.getImagenes()[i]).toExternalForm());
            if(i == 0) imagenPrimcipal.setImage(imagenJuego); 
            if(i == 1) imgCentro.setImage(imagenJuego);
            if(i == 2) imgRight.setImage(imagenJuego);
            if(i == 3) imgLeft.setImage(imagenJuego);

        }
        
        // Asignando titulo del juego
        txt_tituloJuego.setText(juego.getNombreJuego());

        // Asignando los requistos del juego
        lb_rMinimos.setWrapText(true);// Permite ajustar le label si el texto no se muestra por completo
        lb_rRecomendados.setWrapText(true);
        lb_descripsion.setWrapText(true);
        lb_rMinimos.setText(fortatoTexto(juego.getrMininos()));
        lb_rRecomendados.setText(fortatoTexto(juego.getrRecomendados()));
        lb_descripsion.setText(fortatoTexto(juego.getDescripcion()));

        // Asignando otra info como ditribuidor, fecha de lanzamiento etc...
        String info = "Desarrollador: " + "\n" +juego.getDesarrollador() + "\n" + "Fecha de lanzamiento: " + "\n" + juego.getFechaLanzamiento().toString();
        lb_infoJuego.setText(info);
        
        // Asignando precios
        //lb_precio.setWrapText(true);
        double precio = juego.getPrecio();
        lb_precio.setText("Precio: $"+String.format("%.2f", precio));
        // lb_precioAjoloCoins.setText("cero");

    }

    private String fortatoTexto(String texto){
        String resultado = "";
        String[] textoSeparado = texto.split("\\.");// Separa la cadena cuando encuentra un " . "
        
        for(String tex : textoSeparado){
            resultado += tex + "\n";
        }
        return resultado;
    }

    private void cargaIntefaz(String interfaz){

        try {
            Stage satgeNew = new Stage();
            Parent root;
            FXMLLoader loader = new FXMLLoader(getClass().getResource(interfaz));
            root = loader.load();
            Scene scene = new Scene(root);
            satgeNew.setScene(scene);
            satgeNew.show();
        } catch (Exception e) {
           e.printStackTrace();
        };

    }

    private void cerrarVentana(Button boton){
        Stage ventanaActual = (Stage) boton.getScene().getWindow();
        ventanaActual.close();
    } 

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        Juego juego = Sesion.getJuegoPagina();// recuperamos el juego

        mostrarInfo(juego);

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

        //boton inicio
        bt_inicio.setOnMouseClicked(event ->{
            cerrarVentana(bt_inicio);
            cargaIntefaz("/fxmls/InicioGap.fxml"); 
        });
    }

}
