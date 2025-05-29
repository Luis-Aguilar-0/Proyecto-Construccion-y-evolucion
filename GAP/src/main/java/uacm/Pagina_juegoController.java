package uacm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
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
import javafx.util.Duration;
import logic.GestorCarrito;
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
    @FXML
    private Button regreso_bttn;


    private void mostrarInfo(Juego juego){
        for(int i = 0; i < juego.getImagenes().length;i++){
            Image imagenJuego = new Image(getClass().getResource(juego.getImagenes()[i]).toExternalForm());
            if(i == 0) imagenPrimcipal.setImage(imagenJuego); 
            if(i == 1) imgCentro.setImage(imagenJuego);
            if(i == 2) imgRight.setImage(imagenJuego);
            if(i == 3) imgLeft.setImage(imagenJuego);
        }
        txt_tituloJuego.setText(juego.getNombreJuego());
        lb_rMinimos.setWrapText(true);
        lb_rRecomendados.setWrapText(true);
        lb_descripsion.setWrapText(true);
        lb_rMinimos.setText(fortatoTexto(juego.getrMininos()));
        lb_rRecomendados.setText(fortatoTexto(juego.getrRecomendados()));
        lb_descripsion.setText(fortatoTexto(juego.getDescripcion()));
        String info = "Desarrollador: " + "\n" +juego.getDesarrollador() + "\n" + "Fecha de lanzamiento: " + "\n" + juego.getFechaLanzamiento().toString();
        lb_infoJuego.setText(info);
        double precio = juego.getPrecio();
        lb_precio.setText("Precio: $"+String.format("%.2f", precio));
        lb_precioAjoloCoins.setText(juego.getPrecioAjoloCoins().toString() + " Ax");

    }

    private String fortatoTexto(String texto){
        String resultado = "";
        String[] textoSeparado = texto.split("\\.");
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
        Juego juego = Sesion.getJuegoPagina();
        mostrarInfo(juego);

        imgLeft.setOnMouseClicked(event -> {
            imagenPrimcipal.setImage(imgLeft.getImage());
        });
        imgCentro.setOnMouseClicked(event -> {
            imagenPrimcipal.setImage(imgCentro.getImage());
        });
        imgRight.setOnMouseClicked(event -> {
            imagenPrimcipal.setImage(imgRight.getImage());
        });

       
        btn_Comprar.setOnAction(eh -> {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/PayPage.fxml"));
            Parent root = loader.load();

            Stage nuevaVentana = new Stage();
            nuevaVentana.setScene(new Scene(root));
            
            PayPageController controller = loader.getController();
            controller.cargarJuegoDesdePagina(juego);
            
            nuevaVentana.show();

            } catch (IOException e) {
                e.printStackTrace();
            } 
        });

        bt_inicio.setOnMouseClicked(event ->{
            cerrarVentana(bt_inicio);
            cargaIntefaz("/fxmls/InicioGap.fxml"); 
        });

        regreso_bttn.setOnMouseClicked(event ->{
            if(Sesion.getPantallaOrigen().equals("/fxmls/InicioGap.fxml")){
                cerrarVentana(bt_inicio);
                cargaIntefaz("/fxmls/InicioGap.fxml"); 
            }
            if(Sesion.getPantallaOrigen().equals("/fxmls/Categorias.fxml")){
                cerrarVentana(regreso_bttn);
                cargaIntefaz("/fxmls/Categorias.fxml");
            }
        });
    }
    
    @FXML
    public void irCarrito() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/Carrito.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Carrito de Compras");
            stage.setScene(new Scene(root));
            stage.show();
            // Cerrar la ventana actual
            Stage currentStage = (Stage) bt_carrito.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void AgregarAlCarrito(ActionEvent event) {
        Juego juego = Sesion.getJuegoPagina();
        if (juego != null) {
            GestorCarrito.agregarJuego(juego);
            System.out.println("'" + juego.getNombreJuego() + "' añadido al carrito via Pagina_juegoController.");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/Exito.fxml"));
                Parent root = loader.load();
                Stage exitoStage = new Stage();
                exitoStage.setScene(new Scene(root));
                exitoStage.show();
                PauseTransition delay = new PauseTransition(Duration.seconds(2));
                delay.setOnFinished(e -> exitoStage.close());
                delay.play(); 
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
    }
}
