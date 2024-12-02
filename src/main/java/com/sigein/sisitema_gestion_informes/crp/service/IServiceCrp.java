package com.sigein.sisitema_gestion_informes.crp.service;

import com.sigein.sisitema_gestion_informes.crp.dto.CrearCrpDto;
import com.sigein.sisitema_gestion_informes.crp.dto.EditarCrp;
import com.sigein.sisitema_gestion_informes.crp.model.Crp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface IServiceCrp {

ResponseEntity<?> crearCrp(CrearCrpDto crearCrpDto);

ResponseEntity<?> editarCrp(EditarCrp editarCrp,Long idCrp);
ResponseEntity<?> buscarPorId(Long idCrp);

ResponseEntity<?> MostrarTodosLosCrp();

void guardarEnBaseDeDatos(Crp crp);

}
