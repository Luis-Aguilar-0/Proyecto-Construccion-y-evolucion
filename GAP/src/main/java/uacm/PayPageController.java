package uacm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.Juego;
import logic.Tarjeta;
import logic.Usuario;
import persistencia.Sesion;
import persistencia.UsuarioDAO;

/**
 * FXML Controller class
 *
 * @author Frncs.Fox
 */
public class PayPageController implements Initializable {

    @FXML
    private Label total_lbl;
    @FXML
    private Button pagar_bttn;
    @FXML
    private GridPane gridPane_Juegos;
    @FXML
    private ToggleGroup pago_selection;
    @FXML
    private GridPane gridPane_Tarjetas;   
    @FXML
    private RadioButton axoloCoins_toggle;
    @FXML
    private Button cancelar_bttn;
    
    private UsuarioDAO usuarioDAO;
    
    private final Usuario u = Sesion.getUsuario();
    
    //<<<<<<<<<xxxxxxxxxxxxxxxx carga de Tarjetas del usuario xxxxxxxxxxxxxxxx>>>>>>>>>
        
    /*private boolean validarTarjeta(){
        return u != null && u.getTarjetasGuardadas().isEmpty() == false;
    }*/
    
    private void mostrarTarjetas(List<Tarjeta> tarjetas, GridPane contenedor){
        contenedor.getChildren().clear();
        contenedor.setAlignment(Pos.TOP_LEFT);
        
        int columnas = 1;
        int fila = 0;
        int columna = 0;
        
        if(tarjetas != null && !tarjetas.isEmpty()){
            for (Tarjeta tarjeta : tarjetas) {
                RadioButton cards = new RadioButton();
                cards.setToggleGroup(pago_selection);
                
                long numeroCompleto = tarjeta.getNumTarjeta();
                String numeroStr = String.valueOf(numeroCompleto);
                String ultimos4 = numeroStr.substring(numeroStr.length() - 4);
                
                cards.setText("Tarjeta: " + tarjeta.getTipoTarjeta() + "**** **** **** " + ultimos4);
                
                HBox contenedorTarjetas = new HBox(0, cards);
                contenedorTarjetas.setAlignment(Pos.CENTER);
                
                contenedor.add(contenedorTarjetas, columna, fila);
                
                columna++;
                if(columna == columnas){
                   columna = 0;
                   fila++;
                }
            }
        }else{
            contenedor.setAlignment(Pos.CENTER);
            Label label = new Label("Necesitas agregar al menos\nuna tarjeta para comprar.");
            contenedor.add(label, columna, fila);
        }
        
    }
     
    //<<<<<<<<<xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>>>>>>>>>
    
                
    //<<<<<<<<<================ carga de juegos desde PaginaDeJuego///Carrito ================>>>>>>>>>
    private void mostrarJuegos(List<Juego> juegos, GridPane contenedor){       
        contenedor.getChildren().clear();       
        contenedor.setAlignment(Pos.TOP_LEFT);
        
        int columnas = 1;
        int fila = 0;
        int columna = 0;
        
        for(Juego juego : juegos){
            // Crear ImageView, una por cada juego
            ImageView imageView = new ImageView();
            imageView.setFitHeight(50);
            imageView.setPreserveRatio(true);
            
            String ruta = juego.getImagenes()[0]; //cargar la imagen Portada
            try {
                Image imagen = new Image(getClass().getResource(ruta).toExternalForm());
                imageView.setImage(imagen);
            } catch (Exception e) {
                System.out.println("No se pudo cargar la imagen: " + ruta);
            }
            
            // Crear etiquetas para cada juego
            Label nombre = new Label(juego.getNombreJuego());
            Label precio = new Label(String.format("$" + "%.2f", juego.getPrecio()));
            nombre.setTextFill(Color.BLACK);
            precio.setTextFill(Color.BLACK);
            
            HBox contenedorJuego = new HBox(15, imageView, nombre, precio);
            contenedorJuego.setAlignment(Pos.CENTER);
            
            contenedor.add(contenedorJuego, columna, fila);
            
            columna++;
            if (columna == columnas) {
                columna = 0;
                fila++;
            }    
        }
    }
    
    private Juego juegoSeleccionado;
    
    public void cargarJuegoDesdePagina(Juego juego) {
        this.juegoSeleccionado = juego;
        List<Juego> juegos = new ArrayList<>();
        juegos.add(juego);
        mostrarJuegos(juegos, gridPane_Juegos);
    }
    
    //<<<<<<<<<===============================================================================>>>>>>>>>
    
    //comprar juego
    
    private void pagarJuego(){
        Usuario usuario = Sesion.getUsuario();
        if(juegoSeleccionado == null || usuario == null){
            System.out.println("No hay juego seleccionado o usuario no logueado.");
            return;
        }
        
        boolean exito = usuarioDAO.asignarJuegoUsuario(usuario.getId(), juegoSeleccionado.getIdJuego());
        
        if(exito){
            System.out.println("Juego asignado correctamente al usuario");
        }else{
            System.out.println("No se pudo asignar el juego");
        }
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            this.usuarioDAO = new UsuarioDAO();
        } catch (SQLException ex) {
            throw new RuntimeException("Error al inicializar UsuarioDAO", ex);
        }
        
        pagar_bttn.setDisable(true);
        
        List<Tarjeta> tarjetasActualizadas = Sesion.getUsuario().getTarjetasGuardadas();
        mostrarTarjetas(tarjetasActualizadas, gridPane_Tarjetas);
        
        total_lbl.setText("Selecciona un metodo de pago.");
        
        pago_selection.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            pagar_bttn.setDisable(false);
            
            if(pago_selection.getSelectedToggle() == axoloCoins_toggle){
                total_lbl.setText("Total:                         " + juegoSeleccionado.getPrecioAjoloCoins() + "Ax");
                pagar_bttn.setOnAction(eh ->{
                    if(u.getAjoloCoins() < juegoSeleccionado.getPrecioAjoloCoins()){
                        total_lbl.setText("No tienes suficientes AxoloCoins\nPuedes recargar en la pagina de recarga.");
                    }else{
                        pagarJuego();
                    }
                });
            }else{
                total_lbl.setText("Total:                         " + "$" + juegoSeleccionado.getPrecio());
                pagar_bttn.setOnAction(eh ->{
                    pagarJuego();
                });
            }
               
        });
        
        cancelar_bttn.setOnAction(eh -> {
            Stage stage = (Stage) ((Node) eh.getSource()).getScene().getWindow();
            stage.close();         
        });
    }    
    
}
