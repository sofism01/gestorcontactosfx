module co.edu.uniquindio.gestorcontactos {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens co.edu.uniquindio.gestorcontactos to javafx.fxml;
    exports co.edu.uniquindio.gestorcontactos;
}