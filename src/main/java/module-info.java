module co.edu.uniquindio {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens co.edu.uniquindio to javafx.fxml;
    exports co.edu.uniquindio;
    exports co.edu.uniquindio.modelo;

    opens co.edu.uniquindio.controladores to javafx.fxml;
    opens co.edu.uniquindio.modelo to javafx.fxml;
}