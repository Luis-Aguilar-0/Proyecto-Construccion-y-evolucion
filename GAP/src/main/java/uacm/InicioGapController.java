package uacm;

import java.io.ByteArrayInputStream; 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView; 
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import logic.Usuario;                 
import persistencia.Sesion;           

/**
 *
 * @author Frncs.Fox
 */
public class InicioGapController implements Initializable {
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
    private Button recarga_bttn;

    // metoodo para cargar la imagen de perfil en el MenuButton 
    private void cargarImagenPerfilDelMenu() {
        Usuario usuarioLogueado = Sesion.getUsuario();
        ImageView imageViewParaMenu;
        Image imagenAMostrar = null;

        // Ruta de la imagen predeterminada
        String rutaImagenPredeterminada = "/imagenes/imagesPerfil/perfilgato.jpg"; 

        if (usuarioLogueado != null && usuarioLogueado.getImagenPerfil() != null) {
            try {
                // Intenta cargar la imagen de perfil del usuario desde el byte[]
                imagenAMostrar = new Image(new ByteArrayInputStream(usuarioLogueado.getImagenPerfil()));
            } catch (Exception e) {
                System.err.println("Error al cargar imagen de perfil del usuario: " + e.getMessage());
                // Si hay un error se usa la otra imagen
            }
        }
        
        imageViewParaMenu = new ImageView(imagenAMostrar);
        imageViewParaMenu.setFitWidth(80);  
        imageViewParaMenu.setFitHeight(80); 
        imageViewParaMenu.setPreserveRatio(true);

        menuPerfil_btn.setGraphic(imageViewParaMenu);
    }

    @FXML
    private void moverIzquierdaPlay() {
        double nuevaPosicion = carrucel_scPn_play.getHvalue() - speed_scroll;
        carrucel_scPn_play.setHvalue(Math.max(nuevaPosicion, 0));
    }

    @FXML
    private void moverDerechaPlay() {
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

    public void abrirVentana(String rutaFXML, MouseEvent event, String tituloVentana) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();

            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle(tituloVentana);
            nuevaVentana.setScene(new Scene(root));
            nuevaVentana.show();

            Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ventanaActual.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirVentana2(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void cambiarVentana2(String rutaFXML, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();

            Stage nuevaVentana = new Stage();
            nuevaVentana.setScene(new Scene(root));
            nuevaVentana.show();

            Object fuente = event.getSource();
            Stage ventanaActual = null;

            if (fuente instanceof Node) {
                ventanaActual = (Stage) ((Node) fuente).getScene().getWindow();
            } else if (fuente instanceof MenuItem) {
                Window ventanaMenu = ((MenuItem) fuente).getParentPopup().getOwnerWindow();
                if (ventanaMenu instanceof Stage) {
                    ventanaActual = (Stage) ventanaMenu;
                }
            }

            if (ventanaActual != null) {
                ventanaActual.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cerrarVentana(Button boton){
        Stage ventanaActual = (Stage) boton.getScene().getWindow();
        ventanaActual.close();
    } 
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarImagenPerfilDelMenu();

        btnIzquierda_play.setOnAction(e -> moverIzquierdaPlay());
        btnDerecha_play.setOnAction(e -> moverDerechaPlay());
        btnIzquierda_box.setOnAction(e -> moverIzquierdaBox());
        btnDerecha_box.setOnAction(e -> moverDerechaBox());
        btnIzquierda_nin.setOnAction(e -> moverIzquierdaNin());
        btnDerecha_nin.setOnAction(e -> moverDerechaNin());


        //Juegos Playstation
        img1Play.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "The Last Of Us"));
        img2Play.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "God Of War"));
        img3Play.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Uncharted"));
        img4Play.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Horizon"));
        img5Play.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Spider Man"));
        img6Play.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Returnal"));
        
        //Juegos XBox
        img1Xbox.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Mortal Kombat 1"));
        img2Xbox.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Grand Theft Auto"));
        img3Xbox.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Elden Ring"));
        img4Xbox.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Cyber Punk"));
        img5Xbox.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Howarts Legacy"));
        img6Xbox.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Battlefield V"));
        
        //Juegos Nintendo
        img1Nin.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Mario Party"));
        img2Nin.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Zelda: Tears of the kindom"));
        img3Nin.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Pokemon Purpura"));
        img4Nin.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Super Mario Odyssey"));
        img5Nin.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Super Smash Bros"));
        img6Nin.setOnMouseClicked(eh -> abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Mario Kart 8"));
        
        categorias_btn.setOnAction(eh -> {
            cambiarVentana2("/fxmls/Categorias.fxml", eh);
        });
        
        botonBiblioteca.setOnAction(eh -> {
            cerrarVentana(botonBiblioteca);
            //abrirVentana("/fxmls/BibliotecaPerfil.fxml", "Biblioteca"); } ;
            cambiarVentana2("/fxmls/BibliotecaPerfil.fxml", eh);
        });
        
        verPerfil_Item.setOnAction(eh -> {
            cambiarVentana2("/fxmls/Perfil2.fxml", eh);
        });
        
        cerrarSesion_Item.setOnAction(eh -> {
            abrirVentana2("/fxmls/CerrarSesion.fxml");
        });
        
        recarga_bttn.setOnAction(eh -> {
            cambiarVentana2("/fxmls/RecargaAxolotl.fxml", eh);
        });
    }
}