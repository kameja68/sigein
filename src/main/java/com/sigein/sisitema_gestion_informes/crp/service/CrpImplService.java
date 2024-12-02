package com.sigein.sisitema_gestion_informes.crp.service;

import com.sigein.sisitema_gestion_informes.crp.dto.CrearCrpDto;
import com.sigein.sisitema_gestion_informes.crp.dto.EditarCrp;
import com.sigein.sisitema_gestion_informes.crp.dto.MostrarCrpDto;
import com.sigein.sisitema_gestion_informes.crp.model.Crp;
import com.sigein.sisitema_gestion_informes.crp.repository.CrpRepository;
import com.sigein.sisitema_gestion_informes.util.ErrorDto;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CrpImplService implements IServiceCrp {


    private static final Logger LOGGER = LoggerFactory.getLogger(IServiceCrp.class);

    private final CrpRepository crpRepository;

    public CrpImplService(CrpRepository crpRepository) {
        this.crpRepository = crpRepository;
    }


    @Override
    public ResponseEntity<?> crearCrp(CrearCrpDto crearCrpDto) {


        try {

            if (crearCrpDto.codigoCrp() == null) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingrese el numero del Crp"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            if (crearCrpDto.fechaCrp().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingresa la fecha del Crp"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            if (crearCrpDto.valorCrp() == null) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingrese el valor del Crp"), HttpStatus.BAD_REQUEST);


            }
            Crp nuevoCrp = new Crp(crearCrpDto);
            guardarEnBaseDeDatos(nuevoCrp);
            return new ResponseEntity<>(new MostrarCrpDto(nuevoCrp), HttpStatus.OK);


        } catch (Exception e) {

            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


    @Override
    public ResponseEntity<?> editarCrp(EditarCrp editarCrp, Long idCrp) {

        try {
            Crp crpEditado = crpRepository.findById(idCrp).orElse(null);
            if (editarCrp.codigoCrp() != null) {
                crpEditado.setCodigoCrp(editarCrp.codigoCrp());
            }
            if (editarCrp.fechaCrp() != null) {
                crpEditado.setFechaCrp(editarCrp.fechaCrp());


            }
            if (editarCrp.valorCrp() != null) {
                crpEditado.setValorCrp(editarCrp.valorCrp());

            }
            guardarEnBaseDeDatos(crpEditado);
            return new ResponseEntity<>(new MostrarCrpDto(crpEditado), HttpStatus.ACCEPTED);
        } catch (Exception exception) {

            return new ResponseEntity<>(new ErrorDto(exception.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @Override
    public ResponseEntity<?> buscarPorId(Long idCrp) {

        Crp crp = null;
        try {
            crp = this.crpRepository.findById(idCrp).orElse(null);
            if (Objects.isNull(crp)) {
                return new ResponseEntity<>("No se encontro el crp buscado", HttpStatus.NOT_FOUND);
            }
            MostrarCrpDto mostrarCrpDto = new MostrarCrpDto(crp);
            return new ResponseEntity<>(mostrarCrpDto, HttpStatus.OK);

        } catch (DataAccessException e){
            return new ResponseEntity<>("Ha sucedido un error en la consulta  "+ e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> MostrarTodosLosCrp() {
        List<Crp> crps = null;
        List<MostrarCrpDto> mostrarCrpDtos = null;

        try {
            crps = this.crpRepository.findAll();
            if (crps.isEmpty()) {
                return new ResponseEntity<>("La lista de crp esta vacia", HttpStatus.NOT_FOUND);
            }

            mostrarCrpDtos = crps.stream().map(MostrarCrpDto::new).toList();
            return new ResponseEntity<>(mostrarCrpDtos, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>("Ha sucedido un error en la consulta" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public void guardarEnBaseDeDatos(Crp crp) {
        crpRepository.save(crp);
    }
}
