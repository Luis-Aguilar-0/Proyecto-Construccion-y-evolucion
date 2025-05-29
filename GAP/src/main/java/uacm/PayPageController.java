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
import javafx.scene.control.Alert;
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
import logic.GestorCarrito;
import logic.Juego;
import logic.Tarjeta;
import logic.Usuario;
import persistencia.Sesion;
import persistencia.TarjetaDAO;
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
    private TarjetaDAO tarjetaDAO;
    private final Usuario u = Sesion.getUsuario();
    
    private List<Juego> juegosDesdeCarrito = new ArrayList<>();
    
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
            contenedorJuego.setAlignment(Pos.CENTER_LEFT);
            
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
    
    public void cargarJuegosDesdeCarrito() {
        List<Juego> juegos = new ArrayList<>(GestorCarrito.getObjetosEnCarrito());
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
            
            Stage stage = (Stage) pagar_bttn.getScene().getWindow();
            stage.close();
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Compra Realizada");
            alerta.setHeaderText(null);
            alerta.setContentText("Tu juego ya se encuentra en tu biblioteca");
            alerta.showAndWait();
        }else{
            System.out.println("No se pudo asignar el juego");
        }
        
    }
    
    private void pagarJuegosDesdeCarrito() {
        Usuario usuario = Sesion.getUsuario();
        if (usuario == null) {
            System.out.println("Usuario no logueado.");
            return;
        }

        boolean huboError = false;

        for (Juego j : juegosDesdeCarrito) {
            boolean exito = usuarioDAO.asignarJuegoUsuario(usuario.getId(), j.getIdJuego());
            
            if (exito) {
                System.out.println("Juego asignado: " + j.getNombreJuego());
            } else {
                System.out.println("Error al asignar el juego: " + j.getNombreJuego());
                huboError = true;
            }
        }
        
        
        

        if (!huboError) {
            System.out.println("Todos los juegos fueron asignados correctamente al usuario.");

            Stage stage = (Stage) pagar_bttn.getScene().getWindow();
            stage.close();
            
            GestorCarrito.limpiar();
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Compra Realizada");
            alerta.setHeaderText(null);
            alerta.setContentText("Tus juegos ya se encuentran en la biblioteca");
            alerta.showAndWait();
        } else {
            System.out.println("Hubo errores al asignar algunos juegos. No se vaciará el carrito.");
        }
    }

    
    int totalAx = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            this.usuarioDAO = new UsuarioDAO();
            this.tarjetaDAO = new TarjetaDAO();
        } catch (SQLException ex) {
            throw new RuntimeException("Error al inicializar UsuarioDAO", ex);
        }
        
        pagar_bttn.setDisable(true);
        
        Usuario usuarioActual = Sesion.getUsuario();

        if (usuarioActual != null) {
            // Verificar si las tarjetas ya estan cargadas en la sesión del usuario
            // O si la lista es null 
            if (usuarioActual.getTarjetasGuardadas() == null || usuarioActual.getTarjetasGuardadas().isEmpty()) {
                try {
                    System.out.println("PayPageController: cargando tarjetas de la BD");
                    List<Tarjeta> tarjetasDelUsuario = tarjetaDAO.obtenerTarjetasPorUsuario(usuarioActual.getId());
                    // Actualizar el objeto Usuario en Sesion con las tarjetas cargadas
                    usuarioActual.setTarjetasGuardadas(tarjetasDelUsuario != null ? tarjetasDelUsuario : new ArrayList<>());
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Considerar mostrar un mensaje de error al usuario si la carga falla
                    total_lbl.setText("Error al cargar metodos de pago.");
                }
            }
            // mostrar las tarjetas 
            mostrarTarjetas(usuarioActual.getTarjetasGuardadas(), gridPane_Tarjetas);
        } else {
            total_lbl.setText("Usuario no identificado.");
        }
        
        total_lbl.setText("Selecciona un metodo de pago.");
        
        // Si el juegoSeleccionado está vacío, asumimos que vienen del carrito
        if (juegoSeleccionado == null || juegoSeleccionado.getNombreJuego() == null) {
            juegosDesdeCarrito = new ArrayList<>(GestorCarrito.getObjetosEnCarrito());
        }

        pago_selection.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            pagar_bttn.setDisable(false);

            if (pago_selection.getSelectedToggle() == axoloCoins_toggle) {
                if (juegoSeleccionado != null) {
                    int precio = juegoSeleccionado.getPrecioAjoloCoins();
                    total_lbl.setText("Total:                         " + precio + "Ax");

                    pagar_bttn.setOnAction(eh -> {
                        if (u.getAjoloCoins() < precio) {
                            total_lbl.setText("No tienes suficientes AxoloCoins\nPuedes recargar en la página de recarga.");
                        } else {
                            u.setAjoloCoins(u.getAjoloCoins() - precio); // RESTAR al usuario
                            usuarioDAO.setAjolocoins(u.getId(), u.getAjoloCoins());
                            
                            pagarJuego();
                            Sesion.getUsuario().getJuegos().add(juegoSeleccionado);
                        }
                    });
                } else {
                    totalAx = 0;
                    for (Juego j : juegosDesdeCarrito) {
                        if (j.getPrecioAjoloCoins() != null) {
                            totalAx += j.getPrecioAjoloCoins();
                        }
                    }
                    total_lbl.setText("Total:                         " + totalAx + "Ax");

                    pagar_bttn.setOnAction(eh -> {
                        if (u.getAjoloCoins() < totalAx) {
                            total_lbl.setText("No tienes suficientes AxoloCoins\nPuedes recargar en la página de recarga.");
                        } else {
                            u.setAjoloCoins(u.getAjoloCoins() - totalAx); // RESTAR al usuario
                            usuarioDAO.setAjolocoins(u.getId(), u.getAjoloCoins());
                            
                            pagarJuegosDesdeCarrito();
                        }
                    });
                }

            } else {
                if (juegoSeleccionado != null) {
                    total_lbl.setText("Total:                         $" + juegoSeleccionado.getPrecio());

                    pagar_bttn.setOnAction(eh -> {
                        pagarJuego(); // Aquí puedes agregar lógica de pago con dinero si lo implementas
                    });
                } else {
                    double totalMXN = 0;
                    for (Juego j : juegosDesdeCarrito) {
                        totalMXN += j.getPrecio();
                    }
                    total_lbl.setText("Total:                         $" + totalMXN);

                    pagar_bttn.setOnAction(eh -> {
                        pagarJuegosDesdeCarrito(); // Lógica de pago en pesos
                    });
                }
            }
        });
        
        cancelar_bttn.setOnAction(eh -> {
            Stage stage = (Stage) ((Node) eh.getSource()).getScene().getWindow();
            stage.close();         
        });
    }    
    
}
