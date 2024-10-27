package com.sigein.sisitema_gestion_informes.pagos;

public class Pagos {

    private Long idPagos;
    private double valorPago;

    public Pagos(Long idPagos, double valorPago) {
        this.idPagos = idPagos;
        this.valorPago = valorPago;
    }

    public Long getIdPagos() {
        return idPagos;
    }

    public void setIdPagos(Long idPagos) {
        this.idPagos = idPagos;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
