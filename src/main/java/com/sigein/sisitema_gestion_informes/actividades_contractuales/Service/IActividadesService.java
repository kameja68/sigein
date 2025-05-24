package com.sigein.sisitema_gestion_informes.actividades_contractuales.Service;

import com.sigein.sisitema_gestion_informes.actividades_contractuales.model.ActividadesContractuales;
import com.sigein.sisitema_gestion_informes.actividades_contractuales.dto.CrearActDto;
import com.sigein.sisitema_gestion_informes.actividades_contractuales.dto.EditarActDto;
import org.springframework.http.ResponseEntity;

public interface IActividadesService {
ResponseEntity<?> CrearActividad(CrearActDto crearActDto);
ResponseEntity<?> ActualizarActividad(Long idActividad, EditarActDto editarActDto);
ResponseEntity<?> EliminarActividad(Long idActividad);

ResponseEntity<?> BuscarActividadPorId(Long idActividad);
void  GuardarActividad(ActividadesContractuales actividadesContractuales);

}
