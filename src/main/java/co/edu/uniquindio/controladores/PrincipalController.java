package co.edu.uniquindio.controladores;

import co.edu.uniquindio.modelo.Contacto;
import co.edu.uniquindio.modelo.GestorContactos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;


public class PrincipalController implements Initializable {
private final GestorContactos gestorContactos;
private Contacto contacto;

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        void initialize() {

        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public PrincipalController() {

        gestorContactos = new GestorContactos();
    }
}
