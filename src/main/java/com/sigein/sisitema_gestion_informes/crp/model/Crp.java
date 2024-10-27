package com.sigein.sisitema_gestion_informes.crp.model;

public class Crp {
    private Long idCrp;
    private String fechaCrp;
    private  double valorCrp;
    private   Integer codigoCrp;

    public Crp(Long idCrp, String fechaCrp, double valorCrp, Integer codigoCrp) {
        this.idCrp = idCrp;
        this.fechaCrp = fechaCrp;
        this.valorCrp = valorCrp;
        this.codigoCrp = codigoCrp;
    }

    public Long getIdCrp() {
        return idCrp;
    }

    public void setIdCrp(Long idCrp) {
        this.idCrp = idCrp;
    }

    public String getFechaCrp() {
        return fechaCrp;
    }

    public void setFechaCrp(String fechaCrp) {
        this.fechaCrp = fechaCrp;
    }

    public double getValorCrp() {
        return valorCrp;
    }

    public void setValorCrp(double valorCrp) {
        this.valorCrp = valorCrp;
    }

    public Integer getCodigoCrp() {
        return codigoCrp;
    }

    public void setCodigoCrp(Integer codigoCrp) {
        this.codigoCrp = codigoCrp;
    }
}
