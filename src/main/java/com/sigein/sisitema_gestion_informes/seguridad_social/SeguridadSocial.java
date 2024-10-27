package com.sigein.sisitema_gestion_informes.seguridad_social;

public class SeguridadSocial {
    private Long idSeguridadSocial;
    private String descipcionSeg;

    public SeguridadSocial(Long idSeguridadSocial, String descipcionSeg) {
        this.idSeguridadSocial = idSeguridadSocial;
        this.descipcionSeg = descipcionSeg;
    }

    public Long getIdSeguridadSocial() {
        return idSeguridadSocial;
    }

    public void setIdSeguridadSocial(Long idSeguridadSocial) {
        this.idSeguridadSocial = idSeguridadSocial;
    }

    public String getDescipcionSeg() {
        return descipcionSeg;
    }

    public void setDescipcionSeg(String descipcionSeg) {
        this.descipcionSeg = descipcionSeg;
    }
}
