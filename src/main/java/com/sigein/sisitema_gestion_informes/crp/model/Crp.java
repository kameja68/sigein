package com.sigein.sisitema_gestion_informes.crp.model;

import com.sigein.sisitema_gestion_informes.contrato.model.Contrato;
import com.sigein.sisitema_gestion_informes.crp.dto.CrearCrpDto;
import jakarta.persistence.*;
import org.hibernate.annotations.IdGeneratorType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CRP")

public class Crp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Crp")
    private Long idCrp;
    @Column(name = "codigo_crp")
    private Integer codigoCrp;
    @Column(name = "fecha_crp")
    private String fechaCrp;
    @Column(name = "valor_crp")
    private Double valorCrp;


    public Crp(Long idCrp, Integer codigoCrp, String fechaCrp, Double valorCrp) {
        this.idCrp = idCrp;
        this.codigoCrp = codigoCrp;
        this.fechaCrp = fechaCrp;
        this.valorCrp = valorCrp;
    }

    public Crp(CrearCrpDto crearCrpDto) {
        this.codigoCrp = crearCrpDto.codigoCrp();
        this.fechaCrp = crearCrpDto.fechaCrp();
        this.valorCrp = crearCrpDto.valorCrp();

    }

    public Crp() {

    }

    public Long getIdCrp() {
        return idCrp;
    }



    public Integer getCodigoCrp() {
        return codigoCrp;
    }

    public void setCodigoCrp(Integer codigoCrp) {
        this.codigoCrp = codigoCrp;
    }

    public String getFechaCrp() {
        return fechaCrp;
    }

    public void setFechaCrp(String fechaCrp) {
        this.fechaCrp = fechaCrp;
    }

    public Double getValorCrp() {
        return valorCrp;
    }

    public void setValorCrp(Double valorCrp) {
        this.valorCrp = valorCrp;
    }
}
