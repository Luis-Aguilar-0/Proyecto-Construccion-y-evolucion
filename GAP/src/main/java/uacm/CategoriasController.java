package uacm;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.Juego;
import persistencia.JuegoDAO;
import persistencia.Sesion;

/**
 * FXML Controller class
 *
 * @author Frncs.Fox
 */
public class CategoriasController implements Initializable {

    @FXML
    private Button accion_btn;

    JuegoDAO juegoDAO;
    
    @FXML
    private Button regreso_bttn;
    @FXML
    private TextField busqueda_tf;
    @FXML
    private Button search_bttn;
    @FXML
    private Button estrategia_btn;
    @FXML
    private Button narrativa_btn;
    @FXML
    private Button plataforma_btn;
    @FXML
    private Button puzles_btn;
    @FXML
    private Button terror_btn;
    @FXML
    private GridPane GridPane_j;
    
    public void cambiarVentana(String rutaFXML, MouseEvent event, String tituloVentana) {
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
    
    private void mostrarJuegos(List<Juego> juegos, GridPane contenedor) {
        contenedor.getChildren().clear(); // Limpia los juegos anteriores
        
        contenedor.setHgap(20);  // Espacio horizontal entre columnas
        contenedor.setVgap(20);  // Espacio vertical entre filas
        contenedor.setAlignment(Pos.TOP_CENTER); // Alineación al centro
        
        int columnas = 3;
        int fila = 0;
        int columna = 0;
        
        for (Juego juego : juegos) {
            // Crear ImageView, una por cada juego
            ImageView imageView = new ImageView();
            imageView.setFitWidth(150);
            imageView.setFitHeight(200);
            imageView.setPreserveRatio(true);

            String ruta = juego.getImagenes()[0]; //cargar la imagen Portada
            try {
                Image imagen = new Image(getClass().getResource(ruta).toExternalForm());
                imageView.setImage(imagen);
                imageView.getStyleClass().add("ImageView");
            } catch (Exception e) {
                System.out.println("No se pudo cargar la imagen: " + ruta);
            }
            
            //evento para abrir la pagina de cada juego
            imageView.setOnMouseClicked(eh -> {
                Sesion.setJuegoPagina(juego);//se recupera el juego para cargar su informacion
                cambiarVentana("/fxmls/Pagina_juego.fxml", eh, juego.getNombreJuego());

            });

            // Crear etiquetas para cada juego
            Label nombre = new Label(juego.getNombreJuego());
            Label precio = new Label(String.format("$" + "%.2f", juego.getPrecio()));
            nombre.setTextFill(Color.WHITE);
            precio.setTextFill(Color.WHITE);
            
            // Crear VBox para cada jueego
            VBox contenedorJuego = new VBox(10, imageView, nombre, precio);
            contenedorJuego.setAlignment(Pos.CENTER);
            contenedorJuego.getStyleClass().add("mi-vbox");

            // Márgenes alrededor de cada celda del grid
            GridPane.setMargin(contenedorJuego, new Insets(10));
            
            // Agregar el VBox al GridPane
            contenedor.add(contenedorJuego, columna, fila);

            // Avanzar posición en el grid
            columna++;
            if (columna == columnas) {
                columna = 0;
                fila++;
            }            
        }
    }
    
    private void mostrarPorCategoria(int categoria) {
        try {
            juegoDAO = new JuegoDAO();
            List<Juego> juegos = juegoDAO.cargaJuegos();

            List<Juego> filtrados = juegos.stream()
                    .filter(j -> j.getCategoria() == categoria)
                    .collect(Collectors.toList());

            mostrarJuegos(filtrados, GridPane_j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void mostrarPorCaracter(String busqueda){
        try{
            juegoDAO = new JuegoDAO();
            List<Juego> juegos = juegoDAO.cargaJuegos();
            
            List<Juego> filtrados = juegos.stream()
                    //toLowerCase para convertir la cadena a minusculas y constrains para saber si una cadena contiene una subcadena especifica
                    .filter(j -> j.getNombreJuego().toLowerCase().contains(busqueda.toLowerCase()))
                    .collect(Collectors.toList());
            
            if(filtrados.isEmpty()){
                Label mensaje = new Label("No se encontraron resultados.");
                mensaje.setTextFill(Color.WHITE);
                GridPane_j.getChildren().clear();
                GridPane_j.add(mensaje, 0, 0);
            }else{
                mostrarJuegos(filtrados, GridPane_j);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        regreso_bttn.setOnAction(eh ->{
            try{
                //cargar el archivo FXML de la ventana anterior
                Parent root = FXMLLoader.load(getClass().getResource("/fxmls/InicioGap.fxml"));
                
                //obtener el stage actual desde el boton
                Stage stage = (Stage) ((Node) eh.getSource()).getScene().getWindow();
                
                //remplazar la escena
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch(IOException e){
                e.printStackTrace();
            }
        });
        
        accion_btn.setOnAction(e -> mostrarPorCategoria(0));
        
        estrategia_btn.setOnAction(e -> mostrarPorCategoria(1));
        
        narrativa_btn.setOnAction(e -> mostrarPorCategoria(2));
        
        plataforma_btn.setOnAction(e -> mostrarPorCategoria(3));
        
        puzles_btn.setOnAction(e -> mostrarPorCategoria(4));
        
        terror_btn.setOnAction(e -> mostrarPorCategoria(5));
        
        busqueda_tf.textProperty().addListener(((observable, oldValue, newValue) -> {
            mostrarPorCaracter(newValue);
        }));
    }
}
