package com.sigein.sisitema_gestion_informes.cdp.service;

import com.sigein.sisitema_gestion_informes.cdp.dto.CrearCdpDto;
import com.sigein.sisitema_gestion_informes.contratista.model.Contratista;
import org.springframework.http.ResponseEntity;

public interface ICdpService {


    ResponseEntity<?> crearCdp(CrearCdpDto crearCdpDto);

    ResponseEntity<?> buscarPorId(Long idCdp);

    ResponseEntity<?> MostrarCdps();

    void guardarCdp(CrearCdpDto crearCdpDto);


}
