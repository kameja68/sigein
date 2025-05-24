package com.sigein.sisitema_gestion_informes.contrato.dto;

import com.sigein.sisitema_gestion_informes.contrato.model.Contrato;

public record CrearContratoDto(
        String objeto,
        String fechaInicio,
        String fechaFin,
        Integer valorContrato,
        Integer numeroPagos
) {
    public CrearContratoDto(Contrato contrato){
this(
        contrato.getObjeto(),
        contrato.getFechaInicio(),
        contrato.getFechaFin(),
        contrato.getValorContrato(),
        contrato.getNumeroPagos()
);
    }



}
