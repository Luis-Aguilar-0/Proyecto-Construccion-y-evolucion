package uacm;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.Usuario;
import persistencia.Sesion;
import persistencia.UsuarioDAO;

public class Perfil2Controller implements Initializable {
    @FXML
    private ImageView imgPerfil3;

    @FXML
    private VBox contenImage1;
    @FXML private Button btnEditarUsuario;
    @FXML private Button btnEditarCorreo;
    @FXML private Button btnEditarContrasenha;
    @FXML private Button btnElegirImagen;

    @FXML private ImageView imgBiblioteca;
    @FXML private ImageView imgBilletera;
    @FXML private ImageView imgCarrito;
    @FXML private ImageView imgFondoPerfil;
    @FXML private ImageView imgPerfil;
    @FXML private ImageView imgPerfil2;
    @FXML private ImageView imgSalir;
    @FXML private ImageView irInicio;

    @FXML private Pane panBusquedaPerfil;
    @FXML private Pane panBusquedaPerfil1;
    @FXML private Pane panIconosBibliotecaPerfil;
    @FXML private AnchorPane panPrincipalPerfil;

    @FXML private TextField txtUsuario;
    @FXML private TextField txtCorreo;
    @FXML private PasswordField txtContrasenha;

    private final UsuarioDAO usuarioDAO; // DAO para operaciones en BD

    // Guarda los nodos hijos originales del panel principal para restablecer la vista
    private List<javafx.scene.Node> nodosOriginalesPerfil;

    // Raíces para los paneles de Biblioteca y Billetera
    private Parent panBiblioteca;
    private Parent panBilletera;

    // Referencia al Stage de perfil para poder cerrarlo desde aquí
    private Stage perfilStage;

    
     // Constructor inicializa DAO
     
    public Perfil2Controller() {
        try {
            this.usuarioDAO = new UsuarioDAO(); // Carga la conexión y prepara statements
        } catch (SQLException e) {
            throw new RuntimeException("Error al inicializar UsuarioDAO", e);
        }
    }

    /**
     * Se ejecuta tras cargar el FXML:
     * 1. Captura los nodos originales de panPrincipalPerfil para volver a mostrarlos.
     * 2. Carga las vistas secundarias (Biblioteca y Billetera) sin mostrarlas.
     * 3. Muestra el panel de perfil y carga datos de sesión.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // .getChildren() devuelve ObservableList de nodos
        nodosOriginalesPerfil = new ArrayList<>(panPrincipalPerfil.getChildren());

        cargarPanes();       // Prepara las vistas de Biblioteca y Billetera
        muestraPerfil();     // Pone de nuevo los nodos originales
        cargarDatosSesion();  // llena campos con datos del usuario en Sesión

    }
      private void cargarPanes() {
        try {
            // ---- Biblioteca ----
            FXMLLoader loaderBiblio = new FXMLLoader(
                getClass().getResource("/fxmls/BibliotecaPerfilDos.fxml")
            );
            panBiblioteca = loaderBiblio.load(); 
            BibliotecaPerfilDosController ctrlB = loaderBiblio.getController();
            ctrlB.setPerfil2Controller(this); 

            // ---- Billetera ----
            FXMLLoader loaderBill = new FXMLLoader(
                getClass().getResource("/fxmls/BilleteraPerfil.fxml")
            );
            panBilletera = loaderBill.load();
            BilleteraPerfilController ctrlW = loaderBill.getController();
            ctrlW.setPerfil2Controller(this);

        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    //Guarda la referencia al Stage de perfil para que pueda cerrarse desde aqui
    public void setPerfilStage(Stage perfilStage) {
        this.perfilStage = perfilStage;
    }

     // Restaura la vista guardada en nodosOriginalesPerfil
     
    public void muestraPerfil() {
        panPrincipalPerfil.getChildren().setAll(nodosOriginalesPerfil);
    }

    // Muestra el panel de Biblioteca sobre el panel principal
    public void muestraPanBiblioteca() {
        panPrincipalPerfil.getChildren().setAll(panBiblioteca);
    }

    public void muestraPanBilletera() {
        panPrincipalPerfil.getChildren().setAll(panBilletera);
    }

    @FXML private void mostrarPerfil(MouseEvent event) {
        muestraPerfil();      // Restablece nodos originales
        cargarDatosSesion();   // Actualiza campos con datos actuales
    }

    @FXML private void mostrarBiblioteca(MouseEvent event) {
        muestraPanBiblioteca();
    }

    @FXML private void mostrarBilletera(MouseEvent event) {
        muestraPanBilletera();
    }
    @FXML
    private void elegirImagen(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecciona una imagen de perfil");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File archivo = fileChooser.showOpenDialog(btnElegirImagen.getScene().getWindow());

        if (archivo != null) {
            try {
                byte[] bytes = Files.readAllBytes(archivo.toPath());
                Usuario u = Sesion.getUsuario();
                if (bytes.length > 5_000_000) {
                    mostrarAlerta("La imagen es demasiado grande (máximo 5MB)");
                    return;
                }

                if (usuarioDAO.updateFotoPerfil(u.getId(), bytes)) {
                    u.setImagenPerfil(bytes);
                    Image nuevaImg = new Image(new ByteArrayInputStream(bytes));
                    imgPerfil2.setImage(nuevaImg);
                    imgPerfil3.setImage(nuevaImg);
                    mostrarAlerta("¡Foto de perfil actualizada!");
                } else {
                    mostrarAlerta("No se pudo guardar la imagen en la base de datos.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                mostrarAlerta("Error al leer la imagen seleccionada.");
            }
        }
    }
    

    @FXML private void mostrarCerrarSesion(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxmls/CerrarSesion.fxml")
            );
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cerrar Sesión");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();

            CerrarSesionController cerrarCtrl = loader.getController();
            cerrarCtrl.setPerfil2Controller(this);
            cerrarCtrl.setPerfilStage((Stage) imgSalir.getScene().getWindow());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML private void irInicio(MouseEvent event) {
        // Cierra la ventana de perfil si está abierta
        if (perfilStage != null) perfilStage.close();

        try {
            Parent root = FXMLLoader.load(
                getClass().getResource("/fxmls/InicioGap.fxml")
            );
            Stage inicio = new Stage();
            inicio.setTitle("Inicio GAP");
            inicio.setScene(new Scene(root));
            inicio.show();

            // Cierra ventana actual directamente
            ((Stage) irInicio.getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene el usuario desde la clase Sesion y coloca sus datos en los campos.
     * Sesion.isLoggedUsuario() verifica si hay un usuario en memoria.
     */
    private void cargarDatosSesion() {
        if (Sesion.isLoggedUsuario()) {
            Usuario u = Sesion.getUsuario(); // Devuelve objeto Usuario de Sesion

            txtUsuario.setText(u.getUsuario());
            txtCorreo.setText(u.getEmail());         
            txtContrasenha.setText(u.getPasword()); 
            if (u.getImagenPerfil() != null) {
                Image nuevaImg = new Image(new ByteArrayInputStream(u.getImagenPerfil()));
                imgPerfil2.setImage(nuevaImg);
                imgPerfil3.setImage(nuevaImg);
            }
        }

    }


    @FXML private void editarUsuario(MouseEvent event) {
        Usuario u = Sesion.getUsuario();
        String nuevo = txtUsuario.getText().trim();
        if (nuevo.isEmpty()) return; 

        boolean exito = usuarioDAO.updateNombre(u.getId(), nuevo);
        if (exito) {
            abrirExito();        
        } else {
            mostrarAlerta("No se pudo actualizar el campo.");
        }
}

    @FXML private void editarCorreo(MouseEvent event) {
        Usuario u = Sesion.getUsuario();
        String nuevo = txtCorreo.getText().trim();
        if (nuevo.isEmpty()) return;

        boolean exito = usuarioDAO.updateEmail(u.getId(), nuevo);
        if (exito) {
            abrirExito();
        } else {
            mostrarAlerta("No se pudo actualizar el campo.");
        }
}

    @FXML private void editarContrasenha(MouseEvent event) {
        Usuario u = Sesion.getUsuario();
        String nuevo = txtContrasenha.getText().trim();
        if (nuevo.isEmpty()) return;

        boolean exito = usuarioDAO.updatePasword(u.getId(), nuevo);
        if (exito) {
                abrirExito();
            } else {
                mostrarAlerta("No se pudo actualizar el campo.");
            }
    }

private void abrirExito() {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("/fxmls/Exito.fxml"));
        Stage stage = new Stage();
        stage.setTitle("¡Éxito!");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(e -> stage.close());
        delay.play();
    } catch (IOException e) {
        e.printStackTrace();
        mostrarAlerta("Operación completada, pero no se pudo abrir la ventana de éxito.");
    }
}

    private void mostrarAlerta(String msg) {
        System.out.println(msg);
    }
}
