package com.sigein.sisitema_gestion_informes.crp.dto;

import com.sigein.sisitema_gestion_informes.crp.model.Crp;

public record EditarCrp(Integer codigoCrp,
                        String fechaCrp,
                        Double valorCrp) {
}
