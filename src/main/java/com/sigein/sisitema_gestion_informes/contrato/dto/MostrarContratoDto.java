package com.sigein.sisitema_gestion_informes.contrato.dto;

import com.sigein.sisitema_gestion_informes.contrato.model.Contrato;

public record MostrarContratoDto(Long idContrato,
                                 String objeto,
                                 String fechaInicio,
                                 String fechaFin,
                                 Integer valorContrato,
                                 Integer numeroPagos) {
    public MostrarContratoDto (Contrato contrato){
        this(
                contrato.getIdContrato(),
                contrato.getObjeto(),
                contrato.getFechaInicio(),
                contrato.getFechaFin(),
                contrato.getValorContrato(),
                contrato.getNumeroPagos()
        );
    }


}
