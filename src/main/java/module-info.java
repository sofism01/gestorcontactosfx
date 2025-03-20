module co.edu.uniquindio.gestorcontactos {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens co.edu.uniquindio.gestorcontactos.controladores to javafx.fxml;
    opens co.edu.uniquindio.gestorcontactos to javafx.fxml;
    exports co.edu.uniquindio.gestorcontactos.modelo;
    opens co.edu.uniquindio.gestorcontactos.modelo to javafx.fxml;
}