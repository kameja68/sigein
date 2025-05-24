package com.sigein.sisitema_gestion_informes.contrato.service;

import com.sigein.sisitema_gestion_informes.contrato.dto.CrearContratoDto;
import com.sigein.sisitema_gestion_informes.contrato.model.Contrato;
import com.sigein.sisitema_gestion_informes.crp.model.Crp;
import org.springframework.http.ResponseEntity;

public interface IServiceContrato {
    void guardarEnBaseDeDatos(Contrato contrato);
    ResponseEntity<?> crearContrato (CrearContratoDto crearContratoDto);
    ResponseEntity<?> buscarContrato(Long idContrato);
    ResponseEntity<?> mostrarTodosLosContratos();


}
