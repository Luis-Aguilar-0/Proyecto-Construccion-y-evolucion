package uacm;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.Tarjeta;
import logic.Usuario;
import persistencia.Sesion;
import persistencia.TarjetaDAO;

public class BilleteraPerfilController {
    @FXML
    private AnchorPane anchorPaneRaizBilletera;
    @FXML
    private Label lbSaldo;
    @FXML
    private VBox vBoxTarjetas;
    @FXML
    private Label lbTarjetas;
    @FXML
    private ScrollPane scrollPaneHistorial;
    @FXML
    private VBox vboxHistorial;
    @FXML
    private Button btnAgregarSaldo;
    @FXML
    private Button btnAgregarTarjeta;
    @FXML
    private Label lbSaldoCuenta;
    @FXML
    private VBox vboxTarjetas;
    @FXML
    private ScrollPane scrollPaneTarjetas;

    private Perfil2Controller perfil2Controller;
    private TarjetaDAO tarjetaDAO;

    public void setPerfil2Controller(Perfil2Controller controller) {
        this.perfil2Controller = controller;
    }

    @FXML
    public void initialize() {
        try {
            tarjetaDAO = new TarjetaDAO();
        } catch (SQLException e) {
            e.printStackTrace();
            if (btnAgregarTarjeta != null)
                btnAgregarTarjeta.setDisable(true);
        }
        cargarSaldoUsuario();
        cargarYMostrarTarjetasGuardadas();
    }

    // Actualizar el saldo en la etiqueta lbSaldo
    private void cargarSaldoUsuario() {
        Usuario usuarioActual = Sesion.getUsuario();
        if (usuarioActual != null && lbSaldoCuenta != null) {
            lbSaldoCuenta.setText(String.valueOf(usuarioActual.getAjoloCoins()) + " AC");
        } else if (lbSaldoCuenta != null) {
            lbSaldoCuenta.setText("0 AC");
        }
    }

    @FXML
    public void abrirVentanaAgregarTarjeta(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/AgregarTarjeta.fxml"));
            Parent root = loader.load();
            Stage stageAgregarTarjeta = new Stage();
            stageAgregarTarjeta.initModality(Modality.APPLICATION_MODAL);
            stageAgregarTarjeta.setScene(new Scene(root));
            stageAgregarTarjeta.setTitle("Agregar Tarjeta de Crédito");
            stageAgregarTarjeta.showAndWait();
            cargarYMostrarTarjetasGuardadas();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirVentanaRecargarAxolocoins(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/RecargaAxolotl.fxml"));
            Parent root = loader.load();
            Stage stageRecarga = new Stage();
            stageRecarga.setTitle("Recargar Axolocoins");
            stageRecarga.setScene(new Scene(root));
            stageRecarga.show();
            Node origen = (Node) event.getSource();
            Stage ventanaActual = (Stage) origen.getScene().getWindow();
            ventanaActual.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarYMostrarTarjetasGuardadas() {
        if (vboxTarjetas == null)
            return;
        vboxTarjetas.getChildren().clear();
        Usuario usuarioActual = Sesion.getUsuario();
        if (usuarioActual == null) {
            mostrarMensajeEnVBox("Error: No hay usuario en sesion.");
            return;
        }
        if (tarjetaDAO == null) {
            mostrarMensajeEnVBox("Error: Servicio de tarjetas no disponible.");
            return;
        }
        try {
            // obtener id de la tarjeta del usuario actual
            List<Tarjeta> tarjetasDelUsuario = tarjetaDAO.obtenerTarjetasPorUsuario(usuarioActual.getId());
            // se actualiza la lista de tarjetas guardadas del usuario actual
            usuarioActual.setTarjetasGuardadas(tarjetasDelUsuario != null ? tarjetasDelUsuario : new ArrayList<>());
            if (!usuarioActual.getTarjetasGuardadas().isEmpty()) {
                for (Tarjeta tarjeta : usuarioActual.getTarjetasGuardadas()) {
                    HBox tarjetaUI = crearTarjetaUI(tarjeta, usuarioActual.getId());
                    vboxTarjetas.getChildren().add(tarjetaUI);
                }
                vboxTarjetas.setAlignment(Pos.TOP_CENTER);
            } else {
                mostrarMensajeEnVBox("No tienes métodos de pago guardados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarMensajeEnVBox("Error al cargar tus métodos de pago.");
        }
    }

    private HBox crearTarjetaUI(Tarjeta tarjeta, int idUsuario) {
        HBox hbox = new HBox(15);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.getStyleClass().add("tarjeta-item");
        hbox.setPadding(new Insets(12, 15, 12, 15));

        ImageView imgIcono = new ImageView();
        imgIcono.setFitHeight(30.0);
        imgIcono.setFitWidth(45.0);
        imgIcono.setPreserveRatio(true);
        String iconoPath = determinarTipoTarjeta(tarjeta.getNumTarjeta());
        try (InputStream stream = getClass().getResourceAsStream(iconoPath)) {
            if (stream != null) {
                Image cardImage = new Image(stream);
                if (!cardImage.isError()) {
                    imgIcono.setImage(cardImage);
                }
            } else {
                System.out.println("No se pudo cargar el icono para: " + tarjeta.getNumTarjeta());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String numTarjetaStr = String.valueOf(tarjeta.getNumTarjeta());
        String numTarjetaOfuscado = "**** **** **** "
                + (numTarjetaStr.length() > 4 ? numTarjetaStr.substring(numTarjetaStr.length() - 4) : numTarjetaStr);
        Label lblNumTarjeta = new Label(numTarjetaOfuscado);
        lblNumTarjeta.getStyleClass().add("label-texto-normal");
        HBox.setHgrow(lblNumTarjeta, javafx.scene.layout.Priority.ALWAYS);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        String fechaExpStr = (tarjeta.getFechaExpiracion() != null)
                ? tarjeta.getFechaExpiracion().toLocalDate().format(formatter)
                : "N/A";
        Label lblExp = new Label("Exp: " + fechaExpStr);
        lblExp.getStyleClass().add("label-texto-secundario-tarjeta");
        lblExp.setMinWidth(Label.USE_PREF_SIZE);

        Button btnEliminar = new Button("X");
        btnEliminar.getStyleClass().add("boton-eliminar-tarjeta-pequeno");
        btnEliminar.setOnAction(e -> {
            try {
                if (tarjetaDAO != null) {
                    boolean eliminado = tarjetaDAO.eliminarAsociacionTarjeta(idUsuario, tarjeta.getIdTarjeta());
                    if (eliminado) {
                        Usuario u = Sesion.getUsuario();
                        if (u != null) {
                            u.removerTarjetaGuardada(tarjeta.getIdTarjeta());
                        }
                        cargarYMostrarTarjetasGuardadas();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        hbox.getChildren().addAll(imgIcono, lblNumTarjeta, lblExp, btnEliminar);
        return hbox;
    }

    private String determinarTipoTarjeta(long numeroTarjeta) {
        String numStr = String.valueOf(numeroTarjeta);
        if (numStr.startsWith("4")) {
            return "/imagenes/imagesPerfil/visa-icon.png";
        } else if (numStr.startsWith("5")) {
            int primerosDos = Integer.parseInt(numStr.substring(0, 2));
            if (primerosDos >= 51 && primerosDos <= 55) {
                return "/imagenes/imagesPerfil/mastercard-icon.png";
            }
        }
        return "/imagenes/imagesPerfil/creditcard_default_icon.png";
    }

    private void mostrarMensajeEnVBox(String mensaje) {
        if (vboxTarjetas == null)
            return;
        vboxTarjetas.getChildren().clear();
        Label lblMensaje = new Label(mensaje);
        lblMensaje.getStyleClass().add("label-texto-normal");
        vboxTarjetas.getChildren().add(lblMensaje);
        vboxTarjetas.setAlignment(Pos.CENTER);
    }
}
