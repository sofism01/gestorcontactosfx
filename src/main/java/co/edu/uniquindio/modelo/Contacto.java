package co.edu.uniquindio.modelo;

import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.time.LocalDate;
@AllArgsConstructor
@Setter
@Getter
@Builder

public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;
    private LocalDate fechaCumpleanios;
    private String email;
    private Image fotoPerfil;
}
