package com.sigein.sisitema_gestion_informes.crp.repository;

import com.sigein.sisitema_gestion_informes.crp.model.Crp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CrpRepository extends JpaRepository<Crp, Long>  {



}
