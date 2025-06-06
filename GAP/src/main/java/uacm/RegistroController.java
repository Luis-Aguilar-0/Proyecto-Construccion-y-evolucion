package uacm;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.Usuario;
import persistencia.UsuarioDAO;

/**
 * FXML Controller class
 *
 * @author Frncs.Fox
 */
public class RegistroController implements Initializable {

    private UsuarioDAO usuarioDAO; // ceacion del objeto para la conexion a la base de datos

    @FXML
    private AnchorPane main_anchor;
    @FXML
    private VBox Vbox_controller;
    @FXML
    private HBox fecha_box;
    @FXML
    private HBox usuario_box;
    @FXML
    private HBox correo_box;
    @FXML
    private HBox contra_box;
    @FXML
    private ComboBox<String> dia_box;
    @FXML
    private ComboBox<String> mes_box;
    @FXML
    private ComboBox<String> anio_box;
    @FXML
    private TextField usuario_Tfield;
    @FXML
    private TextField correo_Tfield;
    @FXML
    private TextField contrasena_Tfield;
    @FXML
    private Button registrar_bttn;
    @FXML
    private Label mensaje_label;

    private int DiasDelMes(int mes, int anio) {
        switch (mes) {
            case 2: // febrero
                if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
                    return 29; // año bisiesto
                } else {
                    return 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private void actualizarDias() {
        String mesStr = mes_box.getValue();
        String anioStr = anio_box.getValue();

        if (mesStr != null && anioStr != null) {
            int mes = Integer.parseInt(mesStr); // convertir cadenas en enteros
            int anio = Integer.parseInt(anioStr);
            int dia = DiasDelMes(mes, anio);

            dia_box.getItems().clear();
            for (int i = 1; i <= dia; i++) {
                dia_box.getItems().add(String.valueOf(i)); // convertir enteros en cadena
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dia_box.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");

        mes_box.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");

        anio_box.getItems().addAll("2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998",
                "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990",
                "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977",
                "1976", "1975", "1974", "1973", "1972", "1971", "1970",
                "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960");

        mes_box.setOnAction(event -> actualizarDias());
        anio_box.setOnAction(event -> actualizarDias());

        /*
         * Este es la alternativa a usar hover en css
         * dia_box.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
         * dia_box.setStyle("-fx-background-color: #00ffd5;");
         * });
         * 
         * dia_box.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
         * dia_box.setStyle("-fx-background-color: #cc74f9;");
         * });
         */

        registrar_bttn.setOnAction(event -> {
            String dia = dia_box.getValue();
            String mes = mes_box.getValue();
            String anio = anio_box.getValue();
            String nombre = usuario_Tfield.getText();
            String correo = correo_Tfield.getText();
            String contrasena = contrasena_Tfield.getText();

            if (nombre.isBlank() || correo.isBlank() || contrasena.isBlank() || dia.isBlank() || mes.isBlank() || anio.isBlank()) {
                mensaje_label.setText("Por favor llena todos los campos.");
                mensaje_label.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            } else {

                try {
                    // conexion a la base de datos
                    usuarioDAO = new UsuarioDAO();
                    //verificando si ya existe el usuario en la base de datos
                    if (usuarioDAO.buscaUsuario(nombre) == null && usuarioDAO.buscaUsuario(correo) == null) {//el usuario no esta en la base de datos

                        int day = Integer.parseInt(dia_box.getValue());// se cambio a tipo int
                        int month = Integer.parseInt(mes_box.getValue());// se cambio a tipo int
                        int year = Integer.parseInt(anio_box.getValue());// se cambio a tipo int

                        // prueba agergar nuevo usuario a la base
                        Date fecha = java.sql.Date.valueOf(LocalDate.of(year, month, day)); // dando formato a la fecha
                        Usuario userNew = new Usuario(usuario_Tfield.getText(), correo_Tfield.getText(), contrasena_Tfield.getText(), fecha);
                        usuarioDAO.agregarUsuarioBD(userNew);// registro de un nuevo usuario en la base
                        mensaje_label.setText("Registro exitoso.");
                        mensaje_label.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                        
                    } else {
                        if (usuarioDAO.buscaUsuario(nombre) != null) {
                            mensaje_label.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
                            mensaje_label.setText("Ya existe un usuario con ese nombre, cambialo porfavor");
                        } else if (usuarioDAO.buscaUsuario(correo) != null) {
                            mensaje_label.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
                            mensaje_label.setText("Ya existe un usuario con ese correo, cambialo porfavor");
                        }

                    }

                } catch (SQLException e) {
                    throw new RuntimeException();
                } catch (IOException ex) {
                    Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println(dia + "/" + mes + "/" + anio);
                System.out.println("Nombre de usuario: " + nombre);
                System.out.println("Correo: " + correo);
                System.out.println("Contrasena: " + contrasena);
            }
        });

        // usando listeners son mecanismos que permiten reaccionar a cambios en las
        // propiedades de los componentes de JavaFX
        // Limpiar el mensaje si el usuario escribe algo
        usuario_Tfield.textProperty().addListener((obs, oldText, newText) -> {
            mensaje_label.setText("");
        });
        correo_Tfield.textProperty().addListener((obs, oldText, newText) -> {
            mensaje_label.setText("");
        });
        contrasena_Tfield.textProperty().addListener((obs, oldText, newText) -> {
            mensaje_label.setText("");
        });

        // Limpiar si cambia la fecha
        dia_box.valueProperty().addListener((obs, oldVal, newVal) -> {
            mensaje_label.setText("");
        });
        mes_box.valueProperty().addListener((obs, oldVal, newVal) -> {
            mensaje_label.setText("");
        });
        anio_box.valueProperty().addListener((obs, oldVal, newVal) -> {
            mensaje_label.setText("");
        });

        // Configuración responsive adicional
        // configurarTam();
    }
    /* 
    // Hacer que los ComboBox crezcan
    dia_box.setMaxWidth(Double.MAX_VALUE);
    mes_box.setMaxWidth(Double.MAX_VALUE);
    anio_box.setMaxWidth(Double.MAX_VALUE);

    // Configurar el botón
    registrar_bttn.setMaxWidth(Double.MAX_VALUE);

    // Configurar el VBox principal
    Vbox_controller.setAlignment(Pos.CENTER);Vbox_controller.setFillWidth(true);

    // Opcional: Escuchar cambios de tamaño
    main_anchor.widthProperty().addListener((obs,oldVal,newVal)->{
        ajustarTamañosElementos(newVal.doubleValue());
    });
    

    private void ajustarTamañosElementos(double nuevoAncho) {
        // Puedes ajustar tamaños proporcionales aquí si es necesario
        double anchoPref = Math.min(nuevoAncho * 0.7, 600); // 70% del ancho pero máximo 600px
        usuario_Tfield.setPrefWidth(anchoPref);
        correo_Tfield.setPrefWidth(anchoPref);
        contrasena_Tfield.setPrefWidth(anchoPref);
    }*/
}
