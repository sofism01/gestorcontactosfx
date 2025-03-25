package co.edu.uniquindio.controladores;

import co.edu.uniquindio.modelo.Contacto;
import co.edu.uniquindio.modelo.GestorContactos;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    private TableView<Contacto> tablaContactos;

    @FXML
    private TableColumn<Contacto, String> colApellido;

    @FXML
    private TableColumn<Contacto, String> colCumple;

    @FXML
    private TableColumn<Contacto, String> colEmail;

    @FXML
    private TableColumn<Contacto, String> colNombre;

    @FXML
    private TableColumn<Contacto, String> colTelefono;

    @FXML
    private ImageView imageView;


    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCumple;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private Button btnFileChooser;

    @FXML
    void filechooser(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivo", "*.jpg", "*.png"));
        File file = fc.showOpenDialog(null); // Cambié a showOpenDialog para seleccionar UNA imagen
        if (file != null) {
            Image image = new Image(file.toURI().toString()); // Cargar imagen desde la ruta seleccionada
            imageView.setImage(image); // Mostrar imagen en el ImageView
        }

    }



        @FXML
        void initialize() {

        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<File> f = new ArrayList<>();
        f.add(new File("*.jpg"));
        f.add(new File("*.png"));

        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        colTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        colCumple.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaCumpleanios().toString()));
        colEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));

    }

    public PrincipalController() {

        gestorContactos = new GestorContactos();
    }

    @FXML
    void eliminarContacto(ActionEvent event) throws Exception {
        if(contacto != null){
            try{
                gestorContactos.eliminarContacto(contacto.getNombre());

                limpiarCampos();
                gestorContactos.actualizarContactos();
                mostrarAlerta("Contacto eliminado correctamente", Alert.AlertType.INFORMATION);
            }
            catch (Exception exception) {
                mostrarAlerta(exception.getMessage(), Alert.AlertType.ERROR);
            }

            }
        else{
            mostrarAlerta("Debe seleccionar un contacto de la tabla", Alert.AlertType.WARNING);
        }
    }

    private void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtTelefono.clear();
        txtCumple.clear();
        txtEmail.clear();
    }


    @FXML
    void guardarContacto(ActionEvent event) {

    }
}
