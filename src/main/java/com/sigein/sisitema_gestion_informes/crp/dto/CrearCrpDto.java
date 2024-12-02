package com.sigein.sisitema_gestion_informes.crp.dto;

import com.sigein.sisitema_gestion_informes.crp.model.Crp;

public record CrearCrpDto( Integer codigoCrp,
                          String fechaCrp,
                          Double valorCrp) {

public CrearCrpDto(Crp crp){
    this(
            crp.getCodigoCrp(),
            crp.getFechaCrp(),
            crp.getValorCrp()
    );

}
}
