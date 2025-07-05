package com.sigein.sisitema_gestion_informes.actividades_contractuales.Repository;

import com.sigein.sisitema_gestion_informes.actividades_contractuales.model.ActividadesContractuales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActividadesRepository extends JpaRepository<ActividadesContractuales, Long> {


}
