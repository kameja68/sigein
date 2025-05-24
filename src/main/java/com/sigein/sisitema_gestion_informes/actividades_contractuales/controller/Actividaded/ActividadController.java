package com.sigein.sisitema_gestion_informes.actividades_contractuales.controller.Actividaded;

import com.sigein.sisitema_gestion_informes.actividades_contractuales.Service.IActividadesService;
import com.sigein.sisitema_gestion_informes.actividades_contractuales.dto.CrearActDto;
import com.sigein.sisitema_gestion_informes.actividades_contractuales.dto.EditarActDto;
import com.sigein.sisitema_gestion_informes.actividades_contractuales.model.ActividadesContractuales;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/actividad")
@CrossOrigin("http://localhost:3000")

public class ActividadController {

    private final IActividadesService iActividadesService;

    public ActividadController(IActividadesService iActividadesService) {
        this.iActividadesService = iActividadesService;
    }
    @PostMapping("/crear")

    public ResponseEntity<?>crearActividad(@RequestBody CrearActDto crearActDto ) {
        return iActividadesService.CrearActividad(crearActDto);

    }

@PostMapping("/editar/{idActividad}")
    public ResponseEntity<?>ActualizarActividad(
        @RequestBody EditarActDto editarActDto,
        @PathVariable("idActividad") Long idActividad) {

        return iActividadesService.ActualizarActividad(idActividad ,editarActDto);

}

@GetMapping("/buscarPorId{idActividad}")
    public ResponseEntity<?> buscarPorId(@PathVariable("idActividad") Long idActividad) {

        return iActividadesService.BuscarActividadPorId(idActividad);


}

/*http://localhost:8080/swagger-ui/index.html#/actividad-controller/buscarPorId_1*/
}
