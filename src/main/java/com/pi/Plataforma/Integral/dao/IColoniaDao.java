package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Colonia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IColoniaDao extends JpaRepository <Colonia, Long> {

    @Modifying
    @Query("update colonia p set p.municipio.id = ?2 where p.id = ?1")
    void updateAllRelations(Long id_colonia, Long id_municipio);

}
