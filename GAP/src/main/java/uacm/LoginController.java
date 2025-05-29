package uacm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Juego;
import logic.Usuario;
import logic.ValidadorCorreo;
import persistencia.JuegoDAO;
import persistencia.Sesion;
import persistencia.UsuarioDAO;
import uacm.utilities.PathsImages;

public class LoginController implements Initializable {

    private UsuarioDAO usuarioDAO;
    private JuegoDAO juegoDAO;
    public static List<Juego> juegos;

    @FXML
    private AnchorPane anchoPane;
    @FXML
    private Pane pn_login;
    @FXML
    private TextField txf_correo;
    @FXML
    private Button btn_Olvido_Contra;
    @FXML
    private Button bt_Registrate;
    @FXML
    private PasswordField paswor_fileUno;
    @FXML
    private TextField tx_vistaContra;
    @FXML
    private Button btn_verContra;
    @FXML
    private Button btn_iniciarSecion;
    @FXML
    private Label lb_camposVacios;

    // static Usuario usuarioPrueba = new Usuario("laac", "aguilarCas@gmail.com",
    // "slt-");

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // conexion a la base de datos
        try {
            usuarioDAO = new UsuarioDAO(); // ceacion del objeto para la conexion a la base de datos

            System.out.println("conexion a la tabla juego");
            juegoDAO = new JuegoDAO();

            // obtencion de los juegos
            PathsImages.games = juegoDAO.cargaJuegos(); // carga todos los juegos de la base de datos

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        // carga de la pantalla olvido contaseña
        btn_Olvido_Contra.setOnMouseClicked(e -> {

            cargaIntrefaces("OlvidoContrasena");
        });

        // oculta el tx_vistaContra
        if (paswor_fileUno.getText() != null || paswor_fileUno == null) {// se oculta en cualquier caso
            tx_vistaContra.setVisible(false);
        }

        // funcionalidad del boton mostrar contraseña
        btn_verContra.setOnMouseClicked(event -> {

            Timer timer = new Timer(); // se crea el objeto timer
            TimerTask tareaUno = new TimerTask() {// se crea una nueva tarea cada vez que se pulsa el boton
                public void run() { // la tarea a realizar
                    // oculta la contraaseña
                    tx_vistaContra.setVisible(false);
                    // mostramos la contraseña en formato pasword
                    paswor_fileUno.setVisible(true);
                    //Actualizamos el passworFile
                    paswor_fileUno.setText(tx_vistaContra.getText());
                }
            };

            // obtenemos lo que esta en el paswor file
            tx_vistaContra.setText(paswor_fileUno.getText());
            // ocultamos el paswor file
            paswor_fileUno.setVisible(false);
            // mostramos la contraseña
            tx_vistaContra.setVisible(true);
            System.out.println("la tarea esta echa");

            timer.schedule(tareaUno, 5000);// cuando se pulsa el boton el timer espera cinco segundo y ejecuta la tarea

        });

        // carga pantalla registro nuevos usuarios
        bt_Registrate.setOnMouseClicked(e -> {
            cargaIntrefaces("Registro");
        });

        // ajustando el tamaño de la scena cuando se modifica el tamaño de la scene
        // ajuste en el eje x estos parametros representan en ancho del pane
        anchoPane.widthProperty().addListener((anchoPane, anchoAnterior, nuevoAncho) -> {
            // se resta el nuevo ancho con el ancho del pane que yo define
            pn_login.setLayoutX((nuevoAncho.doubleValue() - pn_login.getPrefWidth()) / 2);// se divide entre dos para
                                                                                          // que este centrado
        });
        // se ajusta en el eje y
        anchoPane.heightProperty().addListener((anchoPane, anchoAnterior, nuevoAncho) -> {
            pn_login.setLayoutY((nuevoAncho.doubleValue() - pn_login.getPrefHeight()) / 2);
        });

        // funcionalidad boton iniciar sesion
        btn_iniciarSecion.setOnMouseClicked(event -> {

            // checamos si los campos estan vacios
            if (txf_correo.getText().isEmpty() || paswor_fileUno.getText().isEmpty()) {

                lb_camposVacios.setText("Llene los campos vacios");
                lb_camposVacios.setVisible(true);

            } else {
                lb_camposVacios.setVisible(false);
                // obtenemos el usuario de la base de datos
                Usuario usuarioLogin = usuarioDAO.buscaUsuario(txf_correo.getText()); 
                                                                                     
                if (usuarioLogin == null) {// si es null el usuario no esta en la base de datos
                    
                    lb_camposVacios.setText("Usuario no registrado. Por favor registrate....");
                    lb_camposVacios.setVisible(true);

                } else {// entra al else si el usuario si esta en la base de datos
                    verificaLogin(usuarioLogin);
                }
            }

        });

    }

    private void verificaLogin(Usuario us) {
        // obtego los valores de los textFile
        String email = txf_correo.getText();
        String password = paswor_fileUno.getText();
        String user = txf_correo.getText();

        // verifica si ingresaste un email
        if (ValidadorCorreo.validarCorreo(email)) {

            // verifica si el email y el password son correctos
            if (email.equalsIgnoreCase(us.getEmail()) && password.equals(us.getPasword())) {

                Sesion.setUsuario(us);// guardar el usario de la sesion tras comprobar que son correctos
                Sesion.setJuegosUsuario( usuarioDAO.JuegosUsuario(us.getId() ) );//guarda los juegos del usuario
                
                lb_camposVacios.setText("Bienvenido");
                lb_camposVacios.setVisible(true);

                // se cierra la bentana de login
                // obtengo la ventana
                Stage cerrarStage = (Stage) btn_iniciarSecion.getScene().getWindow();
                cerrarStage.close();

                // se carga la pagina principal
                cargaIntrefaces("InicioGap");

            } else {
                lb_camposVacios.setText("La contraseña o el correo son incorrectos");
                lb_camposVacios.setVisible(true);
            }
            // se ejecuta si se ingresa un usuario
        } else {
            // verifica si el usuario y el password son correctos
            if (user.equals(us.getUsuario()) && password.equals(us.getPasword())) {

                Sesion.setUsuario(us);
                Sesion.setJuegosUsuario( usuarioDAO.JuegosUsuario(us.getId() ) );//guarda los juegos del usuario
                lb_camposVacios.setText("Bienvenido");
                lb_camposVacios.setVisible(true);

                // se cierra la bentana de login
                // obtengo la ventana
                Stage cerrarStage = (Stage) btn_iniciarSecion.getScene().getWindow();
                cerrarStage.close();

                // se carga la pagina principal
                cargaIntrefaces("InicioGap");

            } else {
                lb_camposVacios.setText("La contraseña o el usuario son incorrectos");
                lb_camposVacios.setVisible(true);
            }

        }

    }

    private void cargaIntrefaces(String stage) {

        switch (stage) {
            // interfaz pagina principal
            case "InicioGap" -> {

                Stage stagePP = new Stage();
                Parent root;
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/InicioGap.fxml"));
                    root = loader.load();
                    Scene scene = new Scene(root);
                    stagePP.setScene(scene);
                    stagePP.show();

                } catch (IOException exe) {
                    exe.printStackTrace();
                }
            }
            case "Registro" -> {// interfaz registro nuevos usuarios
                Stage stageOlvidoContra = new Stage();
                Parent root;

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/Registro.fxml"));
                    root = loader.load();
                    Scene scene = new Scene(root);
                    stageOlvidoContra.setScene(scene);
                    stageOlvidoContra.show();
                } catch (IOException exe) {
                    exe.printStackTrace();
                }
            }
            case "OlvidoContrasena" -> {// interfaz olvido contraseña
                Stage stageOlvidoContra = new Stage();
                Parent root;
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/OlvidoContrasena.fxml"));
                    root = loader.load();
                    Scene scene = new Scene(root);

                    stageOlvidoContra.setScene(scene);
                    stageOlvidoContra.show();
                } catch (IOException exe) {
                    exe.printStackTrace();
                }

            }
        }
    }
}
