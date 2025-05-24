package com.sigein.sisitema_gestion_informes.actividades_contractuales.model;

import com.sigein.sisitema_gestion_informes.actividades_contractuales.dto.CrearActDto;
import jakarta.persistence.*;

@Entity
@Table(name="ACTIVIDADES")
public class ActividadesContractuales {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name= "ID_ACTIVIDADES_CONTRACTUALES")
    private Long idActividadesContractuales;
@Column(name="CODIGO_ACTIVIDAD")
    private String codigoActividad;
@Column(name = "DESCRIPCION_ACTIVIDAD")
    private String descripcionActividad;
@Column(name="ESTADO")
    private Boolean estado;

    public ActividadesContractuales(Long idActividadesContractuales, String codigoActividad, String descripcionActividad, Boolean estado) {
        this.idActividadesContractuales = idActividadesContractuales;
        this.codigoActividad = codigoActividad;
        this.descripcionActividad = descripcionActividad;
        this.estado = estado;
    }

    public ActividadesContractuales(CrearActDto crearActDto) {
        this.descripcionActividad= crearActDto.descripcionActividad();
        this.codigoActividad = crearActDto.codigoActividad();
        this.estado = crearActDto.estado();

    }

    public ActividadesContractuales() {

    }

    public Long getIdActividadesContractuales() {
        return idActividadesContractuales;
    }



    public String getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(String codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
