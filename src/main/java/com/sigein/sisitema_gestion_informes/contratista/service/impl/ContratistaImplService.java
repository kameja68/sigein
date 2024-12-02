package com.sigein.sisitema_gestion_informes.contratista.service.impl;

import com.sigein.sisitema_gestion_informes.contratista.dto.CrearContDto;
import com.sigein.sisitema_gestion_informes.contratista.dto.EditarContratistaDto;
import com.sigein.sisitema_gestion_informes.contratista.dto.MostrarContDto;
import com.sigein.sisitema_gestion_informes.contratista.model.Contratista;
import com.sigein.sisitema_gestion_informes.contratista.repository.ContratistaRepository;
import com.sigein.sisitema_gestion_informes.contratista.service.IContratistaService;
import com.sigein.sisitema_gestion_informes.util.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ContratistaImplService implements IContratistaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContratistaImplService.class);

    private final ContratistaRepository contratistaRepository;


    public ContratistaImplService(ContratistaRepository contratistaRepository) {
        this.contratistaRepository = contratistaRepository;
    }

    @Override
    public ResponseEntity<?> crearContratista(CrearContDto crearContDto) {
        try {


            if (crearContDto.nombre1().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingrese su nombre"), HttpStatus.INTERNAL_SERVER_ERROR);

            }
            if (crearContDto.apellido1().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingrese su primer apellido"), HttpStatus.INTERNAL_SERVER_ERROR);

            }

            if (crearContDto.apellido2().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingrese su segundo apellido"), HttpStatus.INTERNAL_SERVER_ERROR);

            }


            if (crearContDto.direccion().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingrese su direccion"), HttpStatus.INTERNAL_SERVER_ERROR);

            }

            if (crearContDto.telefono().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingrese su telefono"), HttpStatus.INTERNAL_SERVER_ERROR);

            }


            if (crearContDto.email().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingrese su correo electronico"), HttpStatus.INTERNAL_SERVER_ERROR);

            }


            if (crearContDto.numeroCtaBancaria().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingrese su numero de cuenta bancaria"), HttpStatus.INTERNAL_SERVER_ERROR);

            }


            if (crearContDto.userName().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingrese su usuario"), HttpStatus.INTERNAL_SERVER_ERROR);

            }

            if (crearContDto.contrasena().isEmpty()) {
                return new ResponseEntity<>(
                        new ErrorDto("Por favor ingrese su usuario"), HttpStatus.INTERNAL_SERVER_ERROR);

            }

            Contratista nuevocontratista = new Contratista(crearContDto);
            guardarEnBaseDeDatos(nuevocontratista);
            return new ResponseEntity<>(new MostrarContDto(nuevocontratista), HttpStatus.OK);


        } catch (Exception e) {

            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @Override
    public ResponseEntity<?> editarContratista(EditarContratistaDto editarContratistaDto,Long idContratista) {
        try {
            Contratista contratEditado = contratistaRepository.findById(idContratista).orElse(null);
            if (editarContratistaDto.identificacion() != null) {
                contratEditado.setIdentificacion(editarContratistaDto.identificacion());
            }
            if (contratEditado.getNombre1() != null) {
                contratEditado.setNombre1(editarContratistaDto.nombre1());

            }
            if (contratEditado.getApellido1() != null) {
                contratEditado.setApellido1(editarContratistaDto.apellido1());
            }
            if (contratEditado.getNombre2() != null) {
                contratEditado.setApellido2(editarContratistaDto.apellido2());
            }
            if (contratEditado.getDireccion() != null) {
                contratEditado.setDireccion(editarContratistaDto.direccion());
            }
            if (contratEditado.getDireccion() != null) {
                contratEditado.setDireccion(editarContratistaDto.direccion());
            }
            if (contratEditado.getTelefono() != null) {
                contratEditado.setTelefono(editarContratistaDto.telefono());

            }
            if (contratEditado.getEmail() != null) {
                contratEditado.setEmail(editarContratistaDto.email());
            }

            if (contratEditado.getNumeroCtaBancaria() != null) {
                contratEditado.setNumeroCtaBancaria(editarContratistaDto.numeroCtaBancaria());
            }

            if (contratEditado.getUserName() != null) {
                contratEditado.setUserName(editarContratistaDto.userName());
            }

            if (contratEditado.getConstrasena() != null) {
                contratEditado.setUserName(editarContratistaDto.contrasena());
            }
            guardarEnBaseDeDatos(contratEditado);

            return new ResponseEntity<>(new MostrarContDto(contratEditado), HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ErrorDto(exception.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @Override
    public ResponseEntity<?> eliminarContratista(Long idContratista) {
        try {
            Contratista contratEliminado = contratistaRepository.findById(idContratista).orElse(null);
            contratEliminado.setEstado(false);
            guardarEnBaseDeDatos(contratEliminado);

            return new ResponseEntity<>(new MostrarContDto(contratEliminado), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public ResponseEntity<?> buscarPorId(Long idContratista) {
        Contratista contratista = null;
        try {
            contratista = this.contratistaRepository.findById(idContratista).orElse(null);
            if (Objects.isNull(contratista)) {
                return new ResponseEntity<>("No se encontro el contratista buscado", HttpStatus.NOT_FOUND);
            }

            MostrarContDto mostrarContDto = new MostrarContDto(contratista);
            return new ResponseEntity<>(mostrarContDto, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>("Ha sucedido un error en la consulta" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> mostrarTodosLosContratistas() {
        List<Contratista> contratistas = null;
        List<MostrarContDto> mostrarContDtos = null;
        try {
            contratistas = contratistaRepository.findAll();
            if (contratistas.isEmpty()) {
                return new ResponseEntity<>("La lista se encutra vacia", HttpStatus.NOT_FOUND);
            }
            mostrarContDtos = contratistas.stream().map(MostrarContDto::new).toList();
            return new ResponseEntity<>(mostrarContDtos, HttpStatus.OK);

        } catch (DataAccessException e) {
            return new ResponseEntity<>("ha sucedido un error" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    public void guardarEnBaseDeDatos(Contratista contratista) {
        contratistaRepository.save(contratista);
    }


}
