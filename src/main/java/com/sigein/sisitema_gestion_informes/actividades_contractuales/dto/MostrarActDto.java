package com.sigein.sisitema_gestion_informes.actividades_contractuales.dto;

import com.sigein.sisitema_gestion_informes.actividades_contractuales.model.ActividadesContractuales;

public record MostrarActDto(

        String codigoActividad,
        String descripcionActividad,
        boolean estado
) {
    public MostrarActDto(ActividadesContractuales actividadesContractuales) {
        this(
                actividadesContractuales.getCodigoActividad(),
                actividadesContractuales.getDescripcionActividad(),
                actividadesContractuales.getEstado()
        );
    }
}
