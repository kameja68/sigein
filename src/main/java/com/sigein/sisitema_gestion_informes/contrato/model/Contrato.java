package com.sigein.sisitema_gestion_informes.contrato.model;

import com.sigein.sisitema_gestion_informes.contratista.model.Contratista;
import com.sigein.sisitema_gestion_informes.contrato.dto.CrearContratoDto;
import com.sigein.sisitema_gestion_informes.crp.model.Crp;
import jakarta.persistence.*;
import org.springframework.core.SpringVersion;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="CONTRATO")
public class Contrato {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="ID_CONTRATO")
    private Long idContrato;
@Column(name = "OBJETO")
    private String objeto;
    @Column(name="FECHA_INICIO")
    private String fechaInicio;
    @Column(name="FECHA_FIN")
    private String fechaFin;
    @Column(name="VALOR_VONTRATADO")
    private  Integer valorContrato;
    @Column(name = "NUMERO_PAGOS")
    private Integer numeroPagos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idContratista") // Asumiendo que "id" es la clave primaria de la tabla Contratista
    private Contratista contratista;
    @OneToMany(
            mappedBy = "idCrp",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            targetEntity = Crp.class)
    private List<Crp> crps = new ArrayList<>();



    public Contrato(Long idContrato, String objeto, String fechaInicio, String fechaFin, Integer valorContrato, Integer numeroPagos, Contratista contratista,List<Crp> crps) {
        this.idContrato = idContrato;
        this.objeto = objeto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.valorContrato = valorContrato;
        this.numeroPagos = numeroPagos;
        this.contratista = contratista;
        this.crps = crps;

    }

    public Contrato() {

    }

    public Contrato(CrearContratoDto crearContratoDto) {
        this.objeto= crearContratoDto.objeto();
        this.fechaInicio = crearContratoDto.fechaInicio();
        this.fechaFin = crearContratoDto.fechaFin();
        this.valorContrato = crearContratoDto.valorContrato();
        this.numeroPagos = crearContratoDto.numeroPagos();


    }

    public Long getIdContrato() {
        return idContrato;
    }

    public Contratista getContratista() {
        return contratista;
    }

    public void setContratista(Contratista contratista) {
        this.contratista = contratista;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
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

    public Integer getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(Integer valorContrato) {
        this.valorContrato = valorContrato;
    }

    public Integer getNumeroPagos() {
        return numeroPagos;
    }

    public void setNumeroPagos(Integer numeroPagos) {
        this.numeroPagos = numeroPagos;
    }

    public List<Crp> getCrps() {
        return crps;
    }

    public void setCrps(List<Crp> crps) {
        this.crps = crps;
    }
}












