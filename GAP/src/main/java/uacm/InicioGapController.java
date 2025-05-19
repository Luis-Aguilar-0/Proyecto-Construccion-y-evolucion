package uacm;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import logic.Usuario;
import persistencia.Sesion;

/**
 *
 * @author Frncs.Fox
 */
public class InicioGapController implements Initializable{
    @FXML
    private ImageView imgInicio;
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
    private MenuButton menuPerfil_btn;
    @FXML
    private Button categorias_btn;
    @FXML
    private ImageView img1Play;
    @FXML
    private ImageView img2Play;
    @FXML
    private ImageView img3Play;
    @FXML
    private ImageView img4Play;
    @FXML
    private ImageView img5Play;
    @FXML
    private ImageView img6Play;
    @FXML
    private ImageView img1Xbox;
    @FXML
    private ImageView img2Xbox;
    @FXML
    private ImageView img3Xbox;
    @FXML
    private ImageView img4Xbox;
    @FXML
    private ImageView img5Xbox;
    @FXML
    private ImageView img6Xbox;
    @FXML
    private ImageView img1Nin;
    @FXML
    private ImageView img2Nin;
    @FXML
    private ImageView img3Nin;
    @FXML
    private ImageView img4Nin;
    @FXML
    private ImageView img5Nin;
    @FXML
    private ImageView img6Nin;
    @FXML
    private MenuItem verPerfil_Item;
    @FXML
    private MenuItem cerrarSesion_Item;
    
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
    
    private void abrirVentana(String rutaFXML, String tituloVentana) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(tituloVentana);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void cargarImagenPerfil() {
        Usuario u = Sesion.getUsuario();
        if (u != null && u.getImagenPerfil() != null) {
            imgInicio.setImage(new Image(new ByteArrayInputStream(u.getImagenPerfil())));
        } else {
           
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarImagenPerfil();
        
        btnIzquierda_play.setOnAction(e -> moverIzquierdaPlay());
        
        btnDerecha_play.setOnAction(e -> moverDerechaPlay());
        
        btnIzquierda_box.setOnAction(e -> moverIzquierdaBox());
        
        btnDerecha_box.setOnAction(e -> moverDerechaBox());
        
        btnIzquierda_nin.setOnAction(e -> moverIzquierdaNin());
        
        btnDerecha_nin.setOnAction(e -> moverDerechaNin());
        
        Image image = new Image("file:src/main/resources/imagenes/imagesPerfil/perfilgato.jpg");
        
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);
        imageView.setPreserveRatio(true);
        
        menuPerfil_btn.setGraphic(imageView);
        
        //Juegos Playstation
        img1Play.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "The Last Of Us"));
        img2Play.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "God Of War"));
        img3Play.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Uncharted"));
        img4Play.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Horizon"));
        img5Play.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Spider Man"));
        img6Play.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Returnal"));
        
        //Juegos XBox
        img1Xbox.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Mortal Kombat 1"));
        img2Xbox.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Grand Theft Auto"));
        img3Xbox.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Elden Ring"));
        img4Xbox.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Cyber Punk"));
        img5Xbox.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Howarts Legacy"));
        img6Xbox.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Battlefield V"));
        
        //Juegos Nintendo
        img1Nin.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Mario Party"));
        img2Nin.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Zelda: Tears of the kindom"));
        img3Nin.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Pokemon Purpura"));
        img4Nin.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Super Mario Odyssey"));
        img5Nin.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Super Smash Bros"));
        img6Nin.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", "Mario Kart 8"));
        
        categorias_btn.setOnAction(eh -> abrirVentana("/fxmls/Categorias.fxml", "Categorias.fxml"));
        botonBiblioteca.setOnAction(eh -> abrirVentana("/fxmls/BibliotecaPerfil.fxml", "Biblioteca"));
        verPerfil_Item.setOnAction(eh -> abrirVentana("/fxmls/Perfil2.fxml", "Categorias"));
        cerrarSesion_Item.setOnAction(eh -> abrirVentana("/fxmls/CerrarSesion.fxml", "Categorias"));
    }
}
