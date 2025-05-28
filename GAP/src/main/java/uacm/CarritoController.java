package uacm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.Juego; // Importa tu clase Juego

public class CarritoController implements Initializable {

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnContinueShopping; 

    @FXML
    private Button btnProceedToPayment;

    @FXML
    private VBox vboxCartItems;

    @FXML
    private Label lblTotalItems;

    @FXML
    private Label lblTotalPriceMXN; // Cambiado para reflejar "PAGO TOTAL EN MXN"

    // private Label lblTotalPriceAxolocoins; // Ignoraremos esto por ahora

    private List<Juego> juegosEnCarrito = new ArrayList<>();
    
    // Necesitarás una instancia de CarritoController para que otras partes de tu app puedan llamar a agregarJuego()
    // Esto a menudo se maneja a través de un singleton o pasando la instancia del controlador.
    // Por simplicidad, este ejemplo no muestra cómo se obtiene esta instancia desde fuera.
    // Una forma podría ser hacer el carrito un singleton o que la clase App lo gestione.
    // O que el FXMLLoader que carga Carrito.fxml te devuelva el controlador y lo guardes.

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Configurar el texto del botón según la imagen
        btnContinueShopping.setText("Ir a Categorías");
        // Renombrar el label para el total en MXN si es diferente en tu FXML
        // Si tu fx:id en FXML para "PAGO TOTAL EN MXN: $0.00" es lblTotalPrice, entonces está bien.
        // Si es otro, actualiza el @FXML y el nombre aquí.
        // Por ahora, asumiré que tienes un Label con fx:id="lblTotalPriceMXN"
        // En tu FXML actual, el fx:id es "lblTotalPrice". Lo adaptaremos.
        
        // Cargar juegos existentes en el carrito si la sesión persiste de alguna forma (ej. desde Sesion.java si guardas el carrito ahí)
        // O si se pasan datos a este controlador al cargarlo.
        // Por ahora, el carrito empieza vacío.
        refrescarVistaCarrito();
    }

    /**
     * Método público para añadir un juego al carrito desde otras partes de la aplicación.
     * @param juego El juego a añadir.
     */
    public void agregarJuegoAlCarrito(Juego juego) {
        if (juego != null && !juegosEnCarrito.contains(juego)) { // Evitar duplicados
            juegosEnCarrito.add(juego);
            System.out.println("Juego añadido: " + juego.getNombreJuego());
            refrescarVistaCarrito();
        } else if (juego != null && juegosEnCarrito.contains(juego)) {
            System.out.println("El juego " + juego.getNombreJuego() + " ya está en el carrito.");
            // Opcional: Mostrar una alerta al usuario
        }
    }

    /**
     * Método llamado por CartItemController para remover un juego.
     * @param juego El juego a remover.
     * @param itemNode El nodo UI que representa el juego en la lista.
     */
    public void removerJuegoDelCarrito(Juego juego, Node itemNode) {
        if (juego != null && itemNode != null) {
            juegosEnCarrito.remove(juego);
            vboxCartItems.getChildren().remove(itemNode); // Remueve el nodo visual directamente
            System.out.println("Juego removido: " + juego.getNombreJuego());
            refrescarVistaCarrito(); // Actualiza totales
        }
    }


    private void refrescarVistaCarrito() {
        vboxCartItems.getChildren().clear(); // Limpia la vista actual
        double precioTotalMXN = 0.0;

        for (Juego juego : juegosEnCarrito) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/CartItem.fxml"));
                AnchorPane itemNode = loader.load();
                
                CartItemController itemController = loader.getController();
                itemController.setData(juego, this); // Pasa el juego y la referencia a este CarritoController
                
                vboxCartItems.getChildren().add(itemNode);
                precioTotalMXN += juego.getPrecio();
            } catch (IOException e) {
                System.err.println("Error al cargar plantilla CartItem.fxml para el juego: " + juego.getNombreJuego());
                e.printStackTrace();
            }
        }
        
        lblTotalItems.setText(String.valueOf(juegosEnCarrito.size()));
        // Asumiendo que el fx:id de "PAGO TOTAL EN MXN" es lblTotalPrice en tu FXML
        // Si el fx:id en tu FXML es lblTotalPriceMXN, usa ese nombre.
        // Basado en el FXML anterior, el fx:id es lblTotalPrice.
        lblTotalPriceMXN.setText(String.format("$%.2f", precioTotalMXN)); 
        // Si tienes un label separado para axolocoins, lo actualizarías aquí también si fuera necesario.
    }


    @FXML
    private void handleVolverALaTienda(ActionEvent event) {
        navegarPara(event, "/fxmls/InicioGap.fxml", "Inicio GAP");
    }

    @FXML
    private void handleSeguirComprando(ActionEvent event) { // Este es "Ir a Categorías"
        navegarPara(event, "/fxmls/Categorias.fxml", "Categorías de Juegos");
    }

    @FXML
    private void handleProcederAlPago(ActionEvent event) {
        // Esta funcionalidad está ignorada por ahora, según tu petición.
        System.out.println("Botón 'Proceder al Pago' presionado (funcionalidad pendiente).");
    }

    private void navegarPara(ActionEvent event, String fxmlFile, String stageTitle) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = new Stage();
            stage.setTitle(stageTitle);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            System.err.println("Error al cargar el FXML: " + fxmlFile + " - " + e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Error: No se pudo encontrar el archivo FXML: " + fxmlFile + ". Verifica la ruta.");
            e.printStackTrace();
        }
    }
}