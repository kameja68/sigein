package com.sigein.sisitema_gestion_informes.banco.model;

public class Banco {
    private Long idBanco;
    private String nombreBanco;

    public Banco(Long idBanco, String nombreBanco) {
        this.idBanco = idBanco;
        this.nombreBanco = nombreBanco;
    }

    public Long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Long idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }
}
