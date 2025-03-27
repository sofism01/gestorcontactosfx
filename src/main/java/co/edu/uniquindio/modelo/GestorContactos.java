package co.edu.uniquindio.modelo;

import javafx.scene.image.Image;
import lombok.AllArgsConstructor;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor

public class GestorContactos {
    private final List<Contacto> contactos;

    public GestorContactos() {
        contactos = new ArrayList<>();
    }

    public void agregarContacto(String nombre, String apellido, String telefono,
                                LocalDate fechaCumpleanios, String email, Image fotoPerfil) throws Exception {

        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            throw new Exception("Todos los campos son necesarios");
        }
        if (fechaCumpleanios.isAfter(LocalDate.now())) {
            throw new Exception("La fecha de cumpleaños no puede ser en el futuro");
        }

        if(fotoPerfil == null){
            throw new Exception("El foto de perfil no puede ser vacía");
        }

        Contacto contacto = Contacto.builder()
                .nombre(nombre)
                .apellido(apellido)
                .telefono(telefono)
                .fotoPerfil(fotoPerfil)
                .fechaCumpleanios(fechaCumpleanios)
                .email(email).build();

        contactos.add(contacto);

    }

    public void eliminarContacto(String nombre){
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equals(nombre)) {
                contactos.remove(i);
            }
        }
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
            contactoGuardado.setEmail(email);


            //Actualiza el contacto en la lista de contactos
            contactos.set(i, contactoGuardado);
        }
    }

    public void buscarContactoPorTelefono(String nombre, String apellido,
                                    String telefono, LocalDate fechaCumpleanios, String email) throws Exception {

        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            throw new Exception("Todos los campos son necesarios");
        }
        if (fechaCumpleanios.isAfter(LocalDate.now())) {
            throw new Exception("La fecha de cumpleaños no puede ser en el futuro");
        }

            int posContacto = obtenerContactoPorTelefono(telefono);
            if(posContacto == -1) {
                throw new Exception("No existe un contacto con ese telefono");
            }
            Contacto contactoGuardado = contactos.get(posContacto);
            contactoGuardado.setNombre(nombre);
            contactoGuardado.setApellido(apellido);
            contactoGuardado.setTelefono(telefono);
            contactoGuardado.setFechaCumpleanios(LocalDate.from(fechaCumpleanios.atStartOfDay()));
            contactoGuardado.setEmail(email);


            contactos.set(posContacto, contactoGuardado);
        }

    public void buscarContactoPorNombre(String nombre, String apellido,
                                          String telefono, LocalDate fechaCumpleanios, String email) throws Exception {

        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            throw new Exception("Todos los campos son necesarios");
        }
        if (fechaCumpleanios.isAfter(LocalDate.now())) {
            throw new Exception("La fecha de cumpleaños no puede ser en el futuro");
        }

        int posContacto = obtenerContactoPorNombre(nombre);
        if(posContacto == -1) {
            throw new Exception("No existe un contacto con ese telefono");
        }
        Contacto contactoGuardado = contactos.get(posContacto);
        contactoGuardado.setNombre(nombre);
        contactoGuardado.setApellido(apellido);
        contactoGuardado.setTelefono(telefono);
        contactoGuardado.setFechaCumpleanios(LocalDate.from(fechaCumpleanios.atStartOfDay()));
        contactoGuardado.setEmail(email);


        contactos.set(posContacto, contactoGuardado);
    }



    private int obtenerContactoPorTelefono (String telefono) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getTelefono().equals(telefono)) {
                return 1;
            }
        }
        return -1;
        }

    private int obtenerContactoPorNombre (String nombre) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equals(nombre)) {
                return 1;
            }
        }
        return -1;
    }


    public List<Contacto> listarContactos() {
        return contactos;

}
    public ArrayList<String> listarCategorias() {
        ArrayList<String> categorias = new ArrayList<>();
        categorias.add("Nombre");
        categorias.add("Telefono");


        return categorias;
    }

}