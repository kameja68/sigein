package com.sigein.sisitema_gestion_informes.contratista.controller;


import com.sigein.sisitema_gestion_informes.contratista.dto.CrearContDto;
import com.sigein.sisitema_gestion_informes.contratista.dto.EditarContratistaDto;
import com.sigein.sisitema_gestion_informes.contratista.service.IContratistaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/v1/contratista")

public class ContratistaController {

private final IContratistaService iContratistaService;


    public ContratistaController(IContratistaService iContratistaService) {
        this.iContratistaService = iContratistaService;
    }
    


    @PostMapping("/crear")
public ResponseEntity<?> crearContratista(@RequestBody CrearContDto crearContDto){
return iContratistaService.crearContratista(crearContDto);
    }

@PutMapping("/editar/{idContratista}")
    public ResponseEntity<?> editarContratista(@RequestBody EditarContratistaDto editarContratistaDto,
                                               @PathVariable("idContratista") Long idContratista){

        return iContratistaService.editarContratista(editarContratistaDto,idContratista);
}


@DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarContratista(@PathVariable ("id") Long id){

        return  iContratistaService.eliminarContratista(id);
}

@GetMapping("/buscarCont/{id}")
    public ResponseEntity<?> buscarCont(@PathVariable("id") Long id){

        return iContratistaService.buscarPorId(id);
}

@GetMapping("/todosCont")
public  ResponseEntity<?> todosCont(){
        return iContratistaService.mostrarTodosLosContratistas();
}









}
