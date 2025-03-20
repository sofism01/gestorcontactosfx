package co.edu.uniquindio.gestorcontactos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GestorContactosApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(GestorContactosApp.class.getResource("/inicio2.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent, 1000, 360);
        stage.setScene(scene);
        stage.setTitle("UQ Notas");
        //stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch(GestorContactosApp.class, args);
    }
}
