package uacm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Perfil2Controller implements Initializable {
   // Botones
@FXML private Button btnEditar1, btnEditar2, btnEditar3, btnElegirImagen;

// ImageViews
@FXML private ImageView imgBiblioteca, imgBilletera, imgCarrito, imgFondoPerfil, 
                        imgPerfil, imgPerfil2, imgSalir, irInicio;

// Panes
@FXML private Pane panBusquedaPerfil, panBusquedaPerfil1, panIconosBibliotecaPerfil;
@FXML private AnchorPane panPrincipalPerfil;

// TextFields
@FXML private TextField txtContrasenha, txtCorreo, txtUsuario;

    private Parent sC_panelBiblioDos;
    private Parent panBilletera;
    private List<javafx.scene.Node> nodosOriginalesPerfil;
    private Stage perfilStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Guardamos la vista original
        nodosOriginalesPerfil = new ArrayList<>(panPrincipalPerfil.getChildren());
        cargarPanes();
        muestraPerfil();
    }

    private void cargarPanes() {
        try {
            // Cargar panel Biblioteca
            FXMLLoader loaderBiblio = new FXMLLoader(getClass().getResource("/fxmls/BibliotecaPerfilDos.fxml"));
            Parent biblioRoot = loaderBiblio.load();
            Object ctrlBiblio = loaderBiblio.getController();
            System.out.println("[DEBUG] Biblioteca controller: " + ctrlBiblio);
            if (ctrlBiblio instanceof BibliotecaPerfilDosController) {
                ((BibliotecaPerfilDosController)ctrlBiblio).setPerfil2Controller(this);
                sC_panelBiblioDos = biblioRoot;
            } else {
                System.err.println("[ERROR] Controlador Biblioteca inválido");
            }

            // Cargar pan Billetera
            FXMLLoader loaderBill = new FXMLLoader(getClass().getResource("/fxmls/BilleteraPerfil.fxml"));
            Parent billRoot = loaderBill.load();
            Object ctrlBill = loaderBill.getController();
            System.out.println("[DEBUG] Billetera controller: " + ctrlBill);
            if (ctrlBill instanceof BilleteraPerfilController) {
                ((BilleteraPerfilController)ctrlBill).setPerfil2Controller(this);
                panBilletera = billRoot;
            } else {
                System.err.println("[ERROR] Controlador Billetera inválido");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void muestraPerfil() {
        panPrincipalPerfil.getChildren().setAll(nodosOriginalesPerfil);
    }

    public void muestraPanBiblioteca() {
        if (sC_panelBiblioDos != null) {
            panPrincipalPerfil.getChildren().setAll(sC_panelBiblioDos);
        }
    }

    public void muestraPanBilletera() {
        if (panBilletera != null) {
            panPrincipalPerfil.getChildren().setAll(panBilletera);
        }
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

            CerrarSesionController cerrarCtrl = loader.getController();
            cerrarCtrl.setPerfil2Controller(this);
            cerrarCtrl.setPerfilStage((Stage) imgSalir.getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPerfilStage(Stage perfilStage) {
        this.perfilStage = perfilStage;
    }

    @FXML
    void irInicio(MouseEvent event) {
        // Cerrar vista actual
       // Stage stageActual = (Stage) irInicio.getScene().getWindow();
        //stageActual.close();

        // Cerrar perfil previo si existe
        if (perfilStage != null) {
            perfilStage.close();
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/InicioGap.fxml"));
            Parent root = loader.load();
            Stage inicioStage = new Stage();
            inicioStage.setTitle("Inicio GAP");
            inicioStage.setScene(new Scene(root));
            inicioStage.show();

              Stage stageActual = (Stage) irInicio.getScene().getWindow();
        stageActual.close();
        } catch (IOException exe) {
            exe.printStackTrace();
        }
    }
}
