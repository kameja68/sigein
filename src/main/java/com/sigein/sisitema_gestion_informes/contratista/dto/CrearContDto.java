package com.sigein.sisitema_gestion_informes.contratista.dto;

import com.sigein.sisitema_gestion_informes.contratista.model.Contratista;

public record CrearContDto(
        Integer identificacion,
        String nombre1,
        String nombre2,
        String apellido1,
        String apellido2,
        String direccion,
        String telefono,
        String email,
        String numeroCtaBancaria,
        String userName,
        String contrasena) {

    public CrearContDto(Contratista contratista) {
        this(
                contratista.getIdentificacion(),
                contratista.getNombre1(),
                contratista.getNombre2(),
                contratista.getApellido1(),
                contratista.getApellido2(),
                contratista.getDireccion(),
                contratista.getTelefono(),
                contratista.getEmail(),
                contratista.getNumeroCtaBancaria(),
                contratista.getUserName(),
                contratista.getConstrasena()
        );

    }
}
