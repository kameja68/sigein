package com.sigein.sisitema_gestion_informes.contratista.service;

import com.sigein.sisitema_gestion_informes.contratista.dto.CrearContDto;
import com.sigein.sisitema_gestion_informes.contratista.dto.EditarContratistaDto;
import com.sigein.sisitema_gestion_informes.contratista.model.Contratista;
import org.springframework.http.ResponseEntity;

public interface IContratistaService {
ResponseEntity<?> crearContratista(CrearContDto crearContDto);
ResponseEntity<?> editarContratista(EditarContratistaDto editarContratistaDto,Long idContratista);
ResponseEntity<?>eliminarContratista(Long idContratista);

ResponseEntity<?>buscarPorId(Long idContratista);
ResponseEntity<?> mostrarTodosLosContratistas();
void guardarEnBaseDeDatos(Contratista contratista);


}
