package com.sigein.sisitema_gestion_informes.tipo_documento;

public class TipoDocumento {

    private Long idTipoDocumento;
    private String descripcionTipDoc;

    public TipoDocumento(Long idTipoDocumento, String descripcionTipDoc) {
        this.idTipoDocumento = idTipoDocumento;
        this.descripcionTipDoc = descripcionTipDoc;
    }

    public Long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getDescripcionTipDoc() {
        return descripcionTipDoc;
    }

    public void setDescripcionTipDoc(String descripcionTipDoc) {
        this.descripcionTipDoc = descripcionTipDoc;
    }
}
