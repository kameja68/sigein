package com.sigein.sisitema_gestion_informes.crp.dto;

import com.sigein.sisitema_gestion_informes.crp.model.Crp;

public record MostrarCrpDto(
        Long idCrp,
        Integer codigoCrp,
        String fechaCrp,
        Double valorCrp

) {
    public MostrarCrpDto(Crp crp) {
        this(crp.getIdCrp(),
                crp.getCodigoCrp(),
                crp.getFechaCrp(),
                crp.getValorCrp()
        );


    }
}
