package com.sigein.sisitema_gestion_informes.actividades_contractuales.Service.Impl;

import com.sigein.sisitema_gestion_informes.actividades_contractuales.model.ActividadesContractuales;
import com.sigein.sisitema_gestion_informes.actividades_contractuales.Repository.ActividadesRepository;
import com.sigein.sisitema_gestion_informes.actividades_contractuales.Service.IActividadesService;
import com.sigein.sisitema_gestion_informes.actividades_contractuales.dto.CrearActDto;
import com.sigein.sisitema_gestion_informes.actividades_contractuales.dto.EditarActDto;
import com.sigein.sisitema_gestion_informes.actividades_contractuales.dto.MostrarActDto;
import com.sigein.sisitema_gestion_informes.util.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ActividadImplService implements IActividadesService {

    private final Logger LOGGER = LoggerFactory.getLogger(ActividadImplService.class);
    private final ActividadesRepository actividadesRepository;

    public ActividadImplService(ActividadesRepository actividadesRepository) {
        this.actividadesRepository = actividadesRepository;
    }
    public void  GuardarActividad(ActividadesContractuales actividadesContractuales) {
        actividadesRepository.save(actividadesContractuales);
    }

    @Override
    public ResponseEntity<?> CrearActividad(CrearActDto crearActDto) {

        try {
            if (crearActDto.codigoActividad().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingrese codigo de la actividad"), HttpStatus.INTERNAL_SERVER_ERROR);

            }

            if (crearActDto.descripcionActividad().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingrese descripcion de la actividad"), HttpStatus.INTERNAL_SERVER_ERROR);
            }

            ActividadesContractuales nuevaactividad= new ActividadesContractuales(crearActDto);
            GuardarActividad(nuevaactividad);
            return new ResponseEntity<>(new MostrarActDto(nuevaactividad), HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @Override
    public ResponseEntity<?> ActualizarActividad(Long idActividad, EditarActDto editarActDto) {

        try{
            ActividadesContractuales actEditada= actividadesRepository.findById(idActividad).orElse(null);
            if (editarActDto.codigoActividad() !=null) {
                actEditada.setCodigoActividad(editarActDto.codigoActividad());
            }
            if (editarActDto.descripcionActividad() !=null) {
                actEditada.setDescripcionActividad(editarActDto.descripcionActividad());
            }
            GuardarActividad(actEditada);
            return new ResponseEntity<>(new MostrarActDto(actEditada), HttpStatus.ACCEPTED);


        }catch (Exception exception){
            return new ResponseEntity<>(new ErrorDto(exception.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @Override
    public ResponseEntity<?> EliminarActividad(Long idActividad) {
try{
ActividadesContractuales actEliminada= actividadesRepository.findById(idActividad).orElse(null);
actEliminada.setEstado(false);
GuardarActividad(actEliminada);

return  new ResponseEntity<>(new MostrarActDto(actEliminada), HttpStatus.OK);
} catch (Exception e) {
LOGGER.error(e.getMessage());
return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
}
    }



    @Override
    public ResponseEntity<?> BuscarActividadPorId(Long idActividad) {
        ActividadesContractuales act = null;
        try {
            act = this.actividadesRepository.findById(idActividad).orElse(null);
            if (Objects.isNull(act)) {

                return new ResponseEntity<>("Actividad no encontrada", HttpStatus.NOT_FOUND);
            }
MostrarActDto mostrarActDto = new MostrarActDto(act);
            return new ResponseEntity<>(mostrarActDto, HttpStatus.OK);


        } catch (DataAccessException e) {
return new ResponseEntity<>( "Ha sucedido un error en la consulta" +e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);


        }
    }




}
