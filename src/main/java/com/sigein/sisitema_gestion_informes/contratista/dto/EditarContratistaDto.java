package com.sigein.sisitema_gestion_informes.contratista.dto;
import jakarta.persistence.Column;

public record EditarContratistaDto(
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
        String contrasena



) {

}
