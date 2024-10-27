package com.sigein.sisitema_gestion_informes.banco.model;

public class TipoCuenta {

    private Long idTipoCuenta;
    private String descripcion;

    public TipoCuenta(Long idTipoCuenta, String descripcion) {
        this.idTipoCuenta = idTipoCuenta;
        this.descripcion = descripcion;
    }

    public Long getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(Long idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
