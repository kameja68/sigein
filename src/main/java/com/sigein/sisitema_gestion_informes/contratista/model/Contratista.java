package com.sigein.sisitema_gestion_informes.contratista.model;

public class Contratista {

    private Long idContratista;
    private String nombre1;
    private  String nombre2;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private String  telefono;
    private String email;
    private String numeroCtaBancaria;
    private String userName;
    private  Integer identificacion;

    public Contratista(Long idContratista, String nombre1, String nombre2, String apellido1, String apellido2, String direccion, String telefono, String email, String numeroCtaBancaria, String userName, Integer identificacion) {
        this.idContratista = idContratista;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.numeroCtaBancaria = numeroCtaBancaria;
        this.userName = userName;
        this.identificacion = identificacion;
    }

    public Long getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(Long idContratista) {
        this.idContratista = idContratista;
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

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }
}
