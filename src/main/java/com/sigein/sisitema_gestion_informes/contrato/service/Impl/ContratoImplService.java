package com.sigein.sisitema_gestion_informes.contrato.service.Impl;

import com.sigein.sisitema_gestion_informes.contratista.dto.CrearContDto;
import com.sigein.sisitema_gestion_informes.contratista.dto.EditarContratistaDto;
import com.sigein.sisitema_gestion_informes.contratista.model.Contratista;
import com.sigein.sisitema_gestion_informes.contratista.service.IContratistaService;
import com.sigein.sisitema_gestion_informes.contrato.dto.CrearContratoDto;
import com.sigein.sisitema_gestion_informes.contrato.dto.MostrarContratoDto;
import com.sigein.sisitema_gestion_informes.contrato.model.Contrato;
import com.sigein.sisitema_gestion_informes.contrato.repository.ContratoRepository;
import com.sigein.sisitema_gestion_informes.contrato.service.IServiceContrato;

import com.sigein.sisitema_gestion_informes.crp.dto.MostrarCrpDto;
import com.sigein.sisitema_gestion_informes.crp.model.Crp;
import com.sigein.sisitema_gestion_informes.util.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Service

public class ContratoImplService implements IServiceContrato {

    private static final Logger LOGGER = LoggerFactory.getLogger(IServiceContrato.class);

    private final ContratoRepository contratoRepository;

    public ContratoImplService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }


    @Override
     public void guardarEnBaseDeDatos(Contrato contrato) {
        contratoRepository.save(contrato);
    }

    @Override
    public ResponseEntity<?> crearContrato(CrearContratoDto crearContratoDto) {
        try {
            if (crearContratoDto.objeto().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("por favor ingrese el objeto del contreto"), HttpStatus.INTERNAL_SERVER_ERROR);


            }
            if (crearContratoDto.fechaInicio().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("por favor ingerese la fecha inicio"), HttpStatus.INTERNAL_SERVER_ERROR);
            }


            if (crearContratoDto.fechaFin().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("por favor ingrese  fecha  de finalizacion"), HttpStatus.INTERNAL_SERVER_ERROR);


            }

            if (crearContratoDto.numeroPagos() == null) {
                return
                        new ResponseEntity<>(
                                new ErrorDto("Por favor ingrese el numero de pagos"), HttpStatus.INTERNAL_SERVER_ERROR);

            }
            if (crearContratoDto.valorContrato() == null) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingrese el valor del contrato "), HttpStatus.INTERNAL_SERVER_ERROR);


            }
            Contrato nuevoContrato = new Contrato(crearContratoDto);
            guardarEnBaseDeDatos(nuevoContrato);
            return new ResponseEntity<>(new MostrarContratoDto(nuevoContrato), HttpStatus.OK);


        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<?> buscarContrato(Long idContrato) {
        Contrato contrato = null;
        try{
            contrato = this.contratoRepository.findById(idContrato).orElse(null);
            if (Objects.isNull(contrato)) {
                return new ResponseEntity<>("No se encontro el contrato", HttpStatus.NOT_FOUND);

            }
            MostrarContratoDto mostrarContratoDto = new MostrarContratoDto(contrato);
            return new ResponseEntity<>(mostrarContratoDto, HttpStatus.OK);
        }catch(DataAccessException e){
            return new ResponseEntity<>("Ha sucedido un error en la conculta" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @Override
    public ResponseEntity<?> mostrarTodosLosContratos() {
        List<Contrato> contratos = null;
        List <MostrarContratoDto> mostrarContratoDtos = null;
        try{
            contratos = this.contratoRepository.findAll();
            if (contratos.isEmpty()) {
                return new ResponseEntity<>(" La lista esta vacia", HttpStatus.NOT_FOUND);
            }

            mostrarContratoDtos = contratos.stream().map( MostrarContratoDto::new).toList();
            return new ResponseEntity<>(mostrarContratoDtos, HttpStatus.OK);

        }catch(DataAccessException e){
            return new ResponseEntity<>( "Ha sucedido un error en la consulta" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
