package com.sigein.sisitema_gestion_informes.contrato.model;

import org.springframework.core.SpringVersion;

public class Contrato {

    private Long idCurso;
    private String objeto;
    private String fechaInicio;
    private String fechaFin;
    private  double valorContrato;
    private Integer numeroPagos;



    public Contrato(long idCurso, String objeto, String fechaInicio, String fechaFin, double valorContrato, Integer numeroPagos) {
        this.idCurso = idCurso;
        this.objeto = objeto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.valorContrato = valorContrato;
        this.numeroPagos = numeroPagos;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(double valorContrato) {
        this.valorContrato = valorContrato;
    }

    public Integer getNumeroPagos() {
        return numeroPagos;
    }

    public void setNumeroPagos(Integer numeroPagos) {
        this.numeroPagos = numeroPagos;
    }


}












