package uacm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.GestorCarrito;
import logic.Juego;

public class CarritoController implements Initializable {

    @FXML private Button btnVolver;
    @FXML private Button btnIrCategorias;
    @FXML private VBox vboxCartItems;
    @FXML private Label lblTotalJuegos;
    @FXML private Label lblPrecioTotalMXN;
    @FXML private Label lblPrecioTotalAxolocoins; // Nueva etiqueta para el total de Axolocoins
    @FXML
    private ScrollPane scrollPaneCartItems;
    @FXML
    private VBox summaryPane;
    @FXML
    private Button btnIrPago;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnIrCategorias.setText("Seguir Comprando"); // Texto cambiado para claridad

        GestorCarrito.getObjetosEnCarrito().addListener((ListChangeListener.Change<? extends Juego> c) -> { //
            System.out.println("CarritoController: detectado cambio en GestorCarrito, refrescando vista.");
            refrescarVistaCarrito();
        });
        
        refrescarVistaCarrito();
        
        btnIrPago.setOnAction(eh -> {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/PayPage.fxml"));
            Parent root = loader.load();

            Stage nuevaVentana = new Stage();
            nuevaVentana.setScene(new Scene(root));
            
            PayPageController controller = loader.getController();
            controller.cargarJuegosDesdeCarrito();
            
            nuevaVentana.show();

            } catch (IOException e) {
                e.printStackTrace();
            } 
        });
    }

    private void refrescarVistaCarrito() {
        vboxCartItems.getChildren().clear();

        if (GestorCarrito.getObjetosEnCarrito().isEmpty()) { //
            System.out.println("CarritoController: Carrito vacío, no hay items que mostrar.");
            // Opcionalmente, mostrar un mensaje en la UI como "Tu carrito está vacío."
            Label emptyCartLabel = new Label("Tu carrito está vacío.");
            emptyCartLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #888888;"); // Estilo de ejemplo
            vboxCartItems.getChildren().add(emptyCartLabel);
        } else {
            System.out.println("CarritoController: Refrescando vista con " + GestorCarrito.getNumeroTotalDeJuegos() + " juego(s)."); //
            for (Juego juego : GestorCarrito.getObjetosEnCarrito()) { //
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/ObjetoCarrito.fxml"));
                    AnchorPane itemNode = loader.load(); 
                    
                    ObjetoCarritoController itemController = loader.getController();
                    // Pasar 'this' (instancia de CarritoController) a ObjetoCarritoController
                    itemController.setData(juego, this); 
                    
                    vboxCartItems.getChildren().add(itemNode);
                } catch (IOException e) {
                    System.err.println("Error al cargar plantilla ObjetoCarrito.fxml para el juego: " + (juego != null ? juego.getNombreJuego() : "Juego NULO"));
                    e.printStackTrace();
                }  catch (NullPointerException e) {
                     System.err.println("Error (NullPointer) al procesar item para el carrito, posible FXML no encontrado o controlador nulo: " + (juego != null ? juego.getNombreJuego() : "Juego NULO"));
                    e.printStackTrace();
                }
            }
        }
        
        // Actualizar totales
        lblTotalJuegos.setText(String.valueOf(GestorCarrito.getNumeroTotalDeJuegos())); //
        lblPrecioTotalMXN.setText(String.format("$%.2f MXN", GestorCarrito.getPrecioTotalMXN())); //
        
        // Calcular y mostrar total de Axolocoins
        int totalAxolocoins = 0;
        for (Juego juego : GestorCarrito.getObjetosEnCarrito()) { //
            if (juego.getPrecioAjoloCoins() != null) { //
                totalAxolocoins += juego.getPrecioAjoloCoins(); //
            }
        }
        if (lblPrecioTotalAxolocoins != null) { // Verificar si la etiqueta FXML existe
             lblPrecioTotalAxolocoins.setText(String.format("%d AC", totalAxolocoins));
        }
    }

    // Método para ser llamado por ObjetoCarritoController para eliminar un artículo
    public void removerJuegoDelCarrito(Juego juego, Node itemNode) {
        GestorCarrito.removerJuego(juego); //
        // El listener en GestorCarrito.getObjetosEnCarrito() activará refrescarVistaCarrito()
        // por lo que eliminar explícitamente itemNode de vboxCartItems aquí podría ser redundante,
        // pero se puede mantener si se prefiere.
        // vboxCartItems.getChildren().remove(itemNode);
        // refrescarVistaCarrito(); // Esto será llamado por el listener de todas formas
    }

    @FXML
    private void handleVolverALaTienda(ActionEvent event) {
        navegarPara(event, "/fxmls/InicioGap.fxml", "Inicio GAP");
    }

    @FXML
    private void handleSeguirComprando(ActionEvent event) {
        navegarPara(event, "/fxmls/Categorias.fxml", "Categorías de Juegos");
    }

    private void handleProcederAlPago(ActionEvent event) {
        System.out.println("Botón 'Proceder al Pago' presionado.");
        // Lógica para el pago
        // Por ejemplo, navegar a PayPage.fxml
        // Asegúrate de que PayPageController pueda manejar una lista de juegos o el total.
        try {
            if (GestorCarrito.getObjetosEnCarrito().isEmpty()) { //
                // Mostrar una alerta o mensaje de que el carrito está vacío
                System.out.println("El carrito está vacío. No se puede proceder al pago.");
                return;
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/PayPage.fxml"));
            Parent root = loader.load();

            //PayPageController payPageController = loader.getController();
            // Podrías querer pasar los artículos del carrito o el total al PayPageController
            // payPageController.initializeConDatosDelCarrito(GestorCarrito.getObjetosEnCarrito(), GestorCarrito.getPrecioTotalMXN());

            Stage stage = new Stage();
            stage.setTitle("Realizar Pago");
            Scene scene = new Scene(root);
            stage.setScene(scene);

            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

            stage.show();
        } catch (IOException e) {
            System.err.println("Error al cargar el FXML: /fxmls/PayPage.fxml - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void vaciarCarrito() {
        GestorCarrito.limpiar();  // Llama al método de limpieza del carrito
        refrescarVistaCarrito();  // Actualiza la UI para reflejar el cambio
    }
    
    private void navegarPara(ActionEvent event, String fxmlFile, String stageTitle) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = new Stage(); 
            stage.setTitle(stageTitle);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();
            
            stage.show();
        } catch (IOException e) {
            System.err.println("Error al cargar el FXML: " + fxmlFile + " - " + e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Error: No se pudo encontrar el archivo FXML: " + fxmlFile + ". Verifica la ruta.");
            e.printStackTrace();
        }
    }
}