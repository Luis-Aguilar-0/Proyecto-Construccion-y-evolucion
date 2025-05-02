package uacm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Perfil2Controller implements Initializable {
    @FXML
    private ImageView imgPerfil2;
    @FXML
    private Button btnEditar1;
    @FXML
    private Button btnEditar2;
    @FXML
    private Button btnEditar3;
    @FXML
    private Button btnEditar4;
    @FXML
    private ImageView imgFondoPerfil;

    @FXML
    private ImageView imgPerfil;
    @FXML
    private ImageView imgBiblioteca;
    @FXML
    private ImageView imgBilletera;
    @FXML
    private ImageView imgSalir;
   
    @FXML
    private ImageView imgCarrito;
    @FXML
    private ImageView imgInicio;

    @FXML
    private VBox vboxPerfil;
    @FXML
    private StackPane panPrincipalPerfil;
    @FXML
    private javafx.scene.layout.Pane panBusquedaPerfil;
    @FXML
    private javafx.scene.layout.Pane panBusquedaPerfil1;
    @FXML
    private javafx.scene.layout.Pane panIconosBibliotecaPerfil;

    private Parent panBiblioteca;
    private Parent panBilletera;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarPanes();
        muestraPerfil();
    }

    private void cargarPanes() {
        try {
            FXMLLoader loaderBiblio = new FXMLLoader(getClass().getResource("/fxmls/BibliotecaPerfil.fxml"));
            panBiblioteca = loaderBiblio.load();
            BilbliotecaPerfilController ctrlBiblio = loaderBiblio.getController();
            ctrlBiblio.setPerfil2Controller(this);

            FXMLLoader loaderBill = new FXMLLoader(getClass().getResource("/fxmls/BilleteraPerfil.fxml"));
            panBilletera = loaderBill.load();
            BilleteraPerfilController ctrlBill = loaderBill.getController();
            ctrlBill.setPerfil2Controller(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void muestraPerfil() {
        panPrincipalPerfil.getChildren().setAll(imgFondoPerfil, vboxPerfil);
    }

    public void muestraPanBiblioteca() {
        panPrincipalPerfil.getChildren().setAll(panBiblioteca);
    }

    public void muestraPanBilletera() {
        panPrincipalPerfil.getChildren().setAll(panBilletera);
    }

    @FXML
    private void mostrarPerfil(MouseEvent event) {
        muestraPerfil();
    }

    @FXML
    private void mostrarBiblioteca(MouseEvent event) {
        muestraPanBiblioteca();
    }

    @FXML
    private void mostrarBilletera(MouseEvent event) {
        muestraPanBilletera();
    }

    @FXML
    private void mostrarCerrarSesion(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/CerrarSesion.fxml"));
            Parent root = loader.load();

            Stage cerrarSesionStage = new Stage();
            cerrarSesionStage.setTitle("Cerrar Sesión");
            cerrarSesionStage.setScene(new Scene(root));
            cerrarSesionStage.setResizable(false);
            cerrarSesionStage.show();

            CerrarSesionController cerrarSesionController = loader.getController();
            cerrarSesionController.setPerfil2Controller(this);
            cerrarSesionController.setPerfilStage((Stage) imgSalir.getScene().getWindow());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
