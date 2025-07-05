package com.sigein.sisitema_gestion_informes.cdp;

public class Cdp {
    private Long idCdp;
    private Integer codigoCdp;
    private  String fechaCdp;
    private String valorCdp;

    public Cdp(Long idCdp, Integer codigoCdp, String fechaCdp, String valorCdp) {
        this.idCdp = idCdp;
        this.codigoCdp = codigoCdp;
        this.fechaCdp = fechaCdp;
        this.valorCdp = valorCdp;
    }

    public Cdp() {

    }

    public Long getIdCdp() {
        return idCdp;
    }

    public void setIdCdp(Long idCdp) {
        this.idCdp = idCdp;
    }

    public Integer getCodigoCdp() {
        return codigoCdp;
    }

    public void setCodigoCdp(Integer codigoCdp) {
        this.codigoCdp = codigoCdp;
    }

    public String getFechaCdp() {
        return fechaCdp;
    }

    public void setFechaCdp(String fechaCdp) {
        this.fechaCdp = fechaCdp;
    }

    public String getValorCdp() {
        return valorCdp;
    }

    public void setValorCdp(String valorCdp) {
        this.valorCdp = valorCdp;
    }
}
