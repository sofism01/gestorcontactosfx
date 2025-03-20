package co.edu.uniquindio.gestorcontactos.modelo;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor

public class GestorContactos {
    private final List<Contacto> contactos;

    public void agregarContacto(String nombre, String apellido, String telefono,
                                LocalDate fechaCumpleanios, String email) throws Exception {

        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            throw new Exception("Todos los campos son necesarios");
        }
        if (fechaCumpleanios.isAfter(LocalDate.now())) {
            throw new Exception("La fecha de cumpleaños no puede ser en el futuro");
        }

        Contacto contacto = Contacto.builder()

                .nombre(nombre)
                .apellido(apellido)
                .telefono(telefono)
                .fechaCumpleanios(fechaCumpleanios)
                .email(email).build();
        contactos.add(contacto);

    }

    public void eliminarContacto(String nombre, String telefono) throws Exception {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equals(nombre) || contactos.get(i).getTelefono().equals(telefono)) {
                contactos.remove(i);
            }
        }
        throw new Exception("No se encontro un contacto con ese nombre o telefono");
    }

    public void editarContacto(String nombre, String apellido, String telefono,
                               LocalDate fechaCumpleanios, String email) throws Exception {
        for (int i = 0; i < contactos.size(); i++) {
            if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
                throw new Exception("Todos los campos son necesarios");
            }
            if (fechaCumpleanios.isAfter(LocalDate.now())) {
                throw new Exception("La fecha de cumpleaños no puede ser en el futuro");
            }

            Contacto contactoGuardado = contactos.get(i);
            contactoGuardado.setNombre(nombre);
            contactoGuardado.setApellido(apellido);
            contactoGuardado.setTelefono(telefono);
            contactoGuardado.setFechaCumpleanios(fechaCumpleanios);

            //Actualiza el contacto en la lista de contactos
            contactos.set(i, contactoGuardado);
        }
    }
}