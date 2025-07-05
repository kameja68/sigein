package com.sigein.sisitema_gestion_informes.cdp.dto;

import com.sigein.sisitema_gestion_informes.cdp.Cdp;

public record CrearCdpDto(Long idCdp,
                          Integer codigoCdp,
                          String fechaCdp,
                          String valorCdp

) {
    public CrearCdpDto(Cdp cdp) {
        this(
                cdp.getIdCdp(),
                cdp.getCodigoCdp(),
                cdp.getFechaCdp(),
                cdp.getValorCdp()
        );

    }
}
