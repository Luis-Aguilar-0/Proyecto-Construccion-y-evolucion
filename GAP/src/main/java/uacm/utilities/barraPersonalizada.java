package uacm.utilities;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class barraPersonalizada {

   

    public static HBox crearBarra(Stage stage){

        //bonones
        Button btnCerrar = new Button("X");
        Button btnMinimizar = new Button("—");
        Button btnMaximizar = new Button("▢");
        
        //eventos de cada boton
        btnCerrar.setOnAction(event -> stage.close()); //cierra la ventana
        btnMinimizar.setOnAction(event -> stage.setIconified(true)); //minimiza la venta
        btnMaximizar.setOnAction(event -> stage.setMaximized(!stage.isMaximized())); //el !stage.isMaxi me permite maximizar y des-maximizar con el mismo boton

        //difiniendo el estilo de los botones 
        estiloBoton(btnMaximizar);
        estiloBoton(btnCerrar);
        estiloBoton(btnMinimizar);

        //se da formato a los botnes
        HBox botones = new HBox(btnCerrar,btnMinimizar,btnMaximizar); //se usa un Hbox para trabajar en bloque los bonoes
        botones.setAlignment(Pos.CENTER_RIGHT); //mueve los botones a la derecha
        botones.setSpacing(5);//coloca un espacio de cinco px entre cada boton
        botones.setPadding(new Insets(5, 10, 5, 5)); //centra a la deracha


         //cracion de la barra 
         HBox barra = new HBox();
         //barra.setStyle("-fx-background-color: #3B2A5E"); //Color.web("#3B2A5E")
         barra.setBackground(new Background(new BackgroundFill(Color.web("#3B2A5E"), new CornerRadii(15),Insets.EMPTY )));
         
         barra.setPrefHeight(30);//altura de la barra
         HBox.setHgrow(botones, Priority.ALWAYS); // hace que "botones" se estire en la barra
         barra.getChildren().addAll(botones);

        //movimiento de la barra
        final Pocicion pocicion = new Pocicion();

        barra.setOnMousePressed(event ->{//cuando se preciona la barra
            pocicion.x = event.getScreenX() - stage.getX(); 
            pocicion.y = event.getScreenY() - stage.getY();
        });
        
        barra.setOnMouseDragged(event -> { //cuando se arrasta la barra
            if(!stage.isMaximized()){//si la ventana no esta maximizada
                stage.setX(event.getScreenX() - pocicion.x);
                stage.setY(event.getScreenY() - pocicion.y);
            }

        });

        return barra;
    }

    private static class Pocicion{//se usa para poder modificar la pocicion dentro de la exprecion lamda

        double x,y; //es la pocicion de la barra
    }

    public static void estiloBoton(Button boton){

        boton.setStyle("-fx-background-color: #3B2A5E; -fx-text-fill: #ffadf4; -fx-font-size: 14;"); //estilo a los botones
        boton.setPrefWidth(30); //el ancho del boton en 30 px

    }
    //se carga la barra para cualquier fxml
    public static VBox cargaBarra(Stage stage,Parent root){

        HBox barra = barraPersonalizada.crearBarra(stage);//se carga la barra personalizada
        VBox contenedor = new VBox(barra,root);//VBox donde se pondra la barra y el fxml
        VBox.setVgrow(root, Priority.ALWAYS);//ase que el contenido se ajuste al tamaño de la pantalla cuando se maximiza la interfaz
     

        return contenedor;

    }
    
}
