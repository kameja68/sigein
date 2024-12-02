package com.sigein.sisitema_gestion_informes.contratista.model;

import com.sigein.sisitema_gestion_informes.contratista.dto.CrearContDto;
import jakarta.persistence.*;

@Entity
@Table(name = "CONTRATISTA")
public class Contratista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContratista")

    private Long idContratista;
    @Column(name = "identificacion")
    private Integer identificacion;
    @Column(name = "nombre1")
    private String nombre1;
    @Column(name = "nombre2")
    private String nombre2;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "numeroCtaBancaria")
    private String numeroCtaBancaria;
    @Column(name = "userName")
    private String userName;
    @Column(name = "constrasena")
    private String constrasena;
    @Column(name = "estado")
    private boolean estado;


    public Contratista(Long idContratista, Integer identificacion, String nombre1, String nombre2, String apellido1, String apellido2, String direccion, String telefono, String email, String numeroCtaBancaria, String userName, String constrasena, boolean estado) {
        this.idContratista = idContratista;
        this.identificacion = identificacion;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.numeroCtaBancaria = numeroCtaBancaria;
        this.userName = userName;
        this.constrasena = constrasena;
        this.estado = estado;
    }

    public Contratista(CrearContDto crearContDto) {
this.identificacion= crearContDto.identificacion();
this.nombre1= crearContDto.nombre1();
this.nombre2= crearContDto.nombre2();
this.apellido1= crearContDto.apellido1();
this.apellido2= crearContDto.apellido2();
this.direccion= crearContDto.direccion();
this.telefono= crearContDto.telefono();
this.email= crearContDto.email();
this.numeroCtaBancaria= crearContDto.numeroCtaBancaria();
this.userName= crearContDto.userName();
this.constrasena= crearContDto.contrasena();
this.estado= true;


    }

    public Contratista() {this.estado= true;

    }

    public Long getIdContratista() {
        return idContratista;
    }


    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCtaBancaria() {
        return numeroCtaBancaria;
    }

    public void setNumeroCtaBancaria(String numeroCtaBancaria) {
        this.numeroCtaBancaria = numeroCtaBancaria;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getConstrasena() {
        return constrasena;
    }

    public void setConstrasena(String constrasena) {
        this.constrasena = constrasena;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
