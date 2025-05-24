package com.sigein.sisitema_gestion_informes.contrato.controller;


import com.sigein.sisitema_gestion_informes.contrato.dto.CrearContratoDto;
import com.sigein.sisitema_gestion_informes.contrato.model.Contrato;
import com.sigein.sisitema_gestion_informes.contrato.service.IServiceContrato;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/v1/contrato")


public class ContratoController {
    private final IServiceContrato iserviceContrato;


    public ContratoController(IServiceContrato serviceContrato) {
        this.iserviceContrato = serviceContrato;
    }



    @PostMapping( "/crear")
    public ResponseEntity<?> createContrato(@RequestBody CrearContratoDto crearContratoDto) {
        return  iserviceContrato.crearContrato( crearContratoDto);
    }
    @GetMapping( "/buscarContrato{idContrato}")
    public ResponseEntity<?> buscarContrato( @RequestBody  @PathVariable("idContrato") Long idContrato) {
        return  iserviceContrato.buscarContrato( idContrato);
    }
}
