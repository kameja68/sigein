package com.sigein.sisitema_gestion_informes.actividades_contractuales.dto;

import com.sigein.sisitema_gestion_informes.actividades_contractuales.model.ActividadesContractuales;

public record CrearActDto(

        String codigoActividad,
        String descripcionActividad,
        Boolean estado


) {
    public CrearActDto (ActividadesContractuales actividadesContractuales){

        this(
                actividadesContractuales.getCodigoActividad(),
                actividadesContractuales.getDescripcionActividad(),
                actividadesContractuales.getEstado()
                );
    }
}
