package co.edu.uniquindio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
}
