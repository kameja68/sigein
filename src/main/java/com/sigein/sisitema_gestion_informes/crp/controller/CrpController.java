package com.sigein.sisitema_gestion_informes.crp.controller;

import com.sigein.sisitema_gestion_informes.contratista.dto.CrearContDto;
import com.sigein.sisitema_gestion_informes.crp.dto.CrearCrpDto;
import com.sigein.sisitema_gestion_informes.crp.dto.EditarCrp;
import com.sigein.sisitema_gestion_informes.crp.dto.MostrarCrpDto;
import com.sigein.sisitema_gestion_informes.crp.service.IServiceCrp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/crp")
/*@CrossOrigin("http://localhost:3000/")*/
public class CrpController {

    private final IServiceCrp iServiceCrp;


    public CrpController(IServiceCrp iServiceCrp) {
        this.iServiceCrp = iServiceCrp;
    }

@PostMapping("/crear")
public ResponseEntity<?> crearCrp(@RequestBody CrearCrpDto crearContDto){
        return iServiceCrp.crearCrp(crearContDto);
}

@PutMapping("/editar/{idCrp}")
    public  ResponseEntity<?> editarCrp(@RequestBody EditarCrp editarCrp, @PathVariable("idCrp")Long idCrp){
return iServiceCrp.editarCrp(editarCrp,idCrp);
}

@GetMapping("/motrar/crps")
    public  ResponseEntity<?> mostrarCrps(){ return iServiceCrp.MostrarTodosLosCrp();}


    @GetMapping("buecarCrp/{idCrp}")
    public  ResponseEntity<?> buscarPorId(@RequestBody  @PathVariable("idCrp") Long idCrp){
        return  iServiceCrp.buscarPorId(idCrp);
    }
}
