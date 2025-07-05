package com.sigein.sisitema_gestion_informes.excel;


import com.sigein.sisitema_gestion_informes.contratista.model.Contratista;
import com.sigein.sisitema_gestion_informes.contratista.repository.ContratistaRepository;
import com.sigein.sisitema_gestion_informes.contrato.model.Contrato;
import com.sigein.sisitema_gestion_informes.contrato.repository.ContratoRepository;
import com.sigein.sisitema_gestion_informes.crp.model.Crp;
import com.sigein.sisitema_gestion_informes.crp.repository.CrpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;
    @Autowired
    ContratoRepository contratoRepository;
    @Autowired
    CrpRepository crpRepository;
    @Autowired
    ContratistaRepository contratistaRepository;



    @GetMapping("/generar/{idContrato}/{idContratista}/{idCrp}")
    public ResponseEntity<byte[]> generarExcel(@PathVariable Long idContrato, @PathVariable Long idContratista, @PathVariable Long idCrp  ) throws IOException {
        Contratista contratista = this.contratistaRepository.findById(idContratista).orElse(null);


        /*contratista.setNombre1("Carlos López");
        contratista.setIdentificacion(12345678);*/

        Contrato contrato =  this.contratoRepository.findById(idContrato).orElse(null);


        /*contrato.setNumeroPagos(12);
        contrato.setObjeto("Mantenimiento de infraestructura");
        contrato.setFechaInicio("2025-01-01");
        contrato.setFechaFin("2025-12-31");*/

        Crp crp =  this.crpRepository.findById(idCrp).orElse(null);
        /*crp.setCodigoCrp(202509);
        crp.setValorCrp(15000000.00);*/

        byte[] excel = excelService.generarExcel(contratista, contrato, crp);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.attachment().filename("certificado.xlsm").build());

        return new ResponseEntity<>(excel, headers, HttpStatus.OK);
    }
}

