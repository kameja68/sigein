package com.sigein.sisitema_gestion_informes.regimen;

public class Regimen {

    private Long idRegimen;
    private String descripcionReg;

    public Regimen(Long idRegimen, String descripcionReg) {
        this.idRegimen = idRegimen;
        this.descripcionReg = descripcionReg;
    }

    public Long getIdRegimen() {
        return idRegimen;
    }

    public void setIdRegimen(Long idRegimen) {
        this.idRegimen = idRegimen;
    }

    public String getDescripcionReg() {
        return descripcionReg;
    }

    public void setDescripcionReg(String descripcionReg) {
        this.descripcionReg = descripcionReg;
    }
}
