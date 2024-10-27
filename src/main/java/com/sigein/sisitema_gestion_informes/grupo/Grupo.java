package com.sigein.sisitema_gestion_informes.grupo;

public class Grupo {
    private Long idGrupo;
    private String nombreCiudad;

    public Grupo(Long idGrupo, String nombreCiudad) {
        this.idGrupo = idGrupo;
        this.nombreCiudad = nombreCiudad;
    }

    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
}
