package uacm;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import logic.Tarjeta;
import logic.Usuario;
import persistencia.Sesion;
import persistencia.TarjetaDAO;

public class AgregarTarjetaController {

    @FXML private Button btnGuardarTarjeta;
    @FXML private Button btnSalir;
    @FXML private TextField txtCVV;
    @FXML private TextField txtExpiracion; // Formato esperado "MM/AA"
    @FXML private TextField txtNombreTarjeta; // Este campo no se guarda en BD
    @FXML private TextField txtNumeroTarjeta;
    @FXML private Label lbMensaje;

    private TarjetaDAO tarjetaDAO;

    @FXML
    public void initialize() {
        try {
            tarjetaDAO = new TarjetaDAO();
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarAlertaEnLabel("Error crítico: No se pudo conectar al servicio de tarjetas.");
            if (btnGuardarTarjeta != null) btnGuardarTarjeta.setDisable(true);
        }
    }

    @FXML
    void GuardarTarjeta(ActionEvent event) {
        String numeroTarjetaStr = txtNumeroTarjeta.getText().trim();
        String expiracionStr = txtExpiracion.getText().trim();
        String cvvStr = txtCVV.getText().trim();

        if (numeroTarjetaStr.isEmpty() || expiracionStr.isEmpty() || cvvStr.isEmpty()) {
            mostrarAlertaEnLabel("Error: Todos los campos son obligatorios.");
            return;
        }
        if (!numeroTarjetaStr.matches("\\d{16}")) {
            mostrarAlertaEnLabel("Error: El número de tarjeta debe contener 16 dígitos.");
            return;
        }
        if (!cvvStr.matches("\\d{3,4}")) {
            mostrarAlertaEnLabel("Error: El CVV debe contener 3 o 4 dígitos.");
            return;
        }

        YearMonth ymExp;
        try {
            if (!expiracionStr.matches("(0[1-9]|1[0-2])\\/([0-9]{2})")) {
                mostrarAlertaEnLabel("Error: Formato de fecha debe ser MM/AA (ej. 12/27).");
                return;
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            ymExp = YearMonth.parse(expiracionStr, formatter);
            if (ymExp.isBefore(YearMonth.now())) {
                mostrarAlertaEnLabel("Error: La tarjeta ha expirado.");
                return;
            }
        } catch (DateTimeParseException e) {
            mostrarAlertaEnLabel("Error: Fecha de expiración inválida (use MM/AA).");
            return;
        }

        long numeroTarjeta;
        int cvv;
        try {
            numeroTarjeta = Long.parseLong(numeroTarjetaStr);
            cvv = Integer.parseInt(cvvStr);
        } catch (NumberFormatException e) {
            mostrarAlertaEnLabel("Error: Número de tarjeta o CVV tienen formato numérico incorrecto.");
            return;
        }

        Date fechaExpiracionSql = Date.valueOf(ymExp.atEndOfMonth());

        Tarjeta nuevaTarjeta = new Tarjeta();
        nuevaTarjeta.setNumTarjeta(numeroTarjeta);
        nuevaTarjeta.setTipoTarjeta("Crédito/Débito");
        nuevaTarjeta.setFechaExpiracion(fechaExpiracionSql);
        nuevaTarjeta.setCodSeguridad(cvv);

        if (tarjetaDAO == null) {
            mostrarAlertaEnLabel("Error de sistema: Servicio de tarjetas no disponible.");
            return;
        }
        try {
            int idNuevaTarjeta = tarjetaDAO.agregarTarjeta(nuevaTarjeta);
            if (idNuevaTarjeta != -1) {
                Usuario usuarioActual = Sesion.getUsuario();
                if (usuarioActual != null) {
                    boolean asociacionExitosa = tarjetaDAO.asociarTarjetaAUsuario(usuarioActual.getId(), idNuevaTarjeta);
                    if (asociacionExitosa) {
                        nuevaTarjeta.setIdTarjeta(idNuevaTarjeta);
                        usuarioActual.agregarTarjetaGuardada(nuevaTarjeta);
                        mostrarVentanaExitoYSalir();
                    } else {
                        mostrarAlertaEnLabel("Error: No se pudo asociar la tarjeta al perfil.");
                    }
                } else {
                    mostrarAlertaEnLabel("Error: No hay usuario en sesión.");
                }
            } else {
                mostrarAlertaEnLabel("Error: No se pudo guardar la tarjeta en la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getMessage().contains("Violation of PRIMARY KEY constraint") &&
                e.getMessage().contains("PK_usuario_tarjetas_guardadas")) {
                mostrarAlertaEnLabel("Error: Esta tarjeta ya está registrada en tu perfil.");
            } else {
                mostrarAlertaEnLabel("Error de base de datos al intentar guardar la tarjeta.");
            }
        }
    }

    private void mostrarAlertaEnLabel(String mensaje) {
        if (lbMensaje != null) {
            lbMensaje.setText(mensaje);
            lbMensaje.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        } else {
            Alert fallbackAlert = new Alert(Alert.AlertType.INFORMATION);
            fallbackAlert.setTitle("Información");
            fallbackAlert.setHeaderText(null);
            fallbackAlert.setContentText(mensaje);
            fallbackAlert.showAndWait();
        }
    }

    private void mostrarVentanaExitoYSalir() {
        try {
            if (lbMensaje != null) lbMensaje.setText("");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/Exito.fxml"));
            Parent root = loader.load();

            Stage exitoStage = new Stage();
            exitoStage.initStyle(StageStyle.UNDECORATED);
            exitoStage.setScene(new Scene(root));
            exitoStage.show();

            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(e -> {
                exitoStage.close();
                Stage stageActual = (Stage) btnGuardarTarjeta.getScene().getWindow();
                if (stageActual != null) {
                    stageActual.close();
                }
            });
            delay.play();
        } catch (IOException e) {
            e.printStackTrace();
            Stage stageActual = (Stage) btnGuardarTarjeta.getScene().getWindow();
            if (stageActual != null) {
                stageActual.close();
            }
        }
    }

    @FXML
    void Salir(ActionEvent event) {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }
}
