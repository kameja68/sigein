package com.sigein.sisitema_gestion_informes.actividades_contractuales;

public class ActividadesContractuales {
    private Long idActividadesContractuales;
    private Integer codigoActividad;
    private String descripcionActividad;

    public ActividadesContractuales(Long idActividadesContractuales, Integer codigoActividad, String descripcionActividad) {
        this.idActividadesContractuales = idActividadesContractuales;
        this.codigoActividad = codigoActividad;
        this.descripcionActividad = descripcionActividad;
    }

    public Long getIdActividadesContractuales() {
        return idActividadesContractuales;
    }

    public void setIdActividadesContractuales(Long idActividadesContractuales) {
        this.idActividadesContractuales = idActividadesContractuales;
    }

    public Integer getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(Integer codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }
}
