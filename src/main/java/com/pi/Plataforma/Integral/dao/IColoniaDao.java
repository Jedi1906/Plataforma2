package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Colonia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IColoniaDao extends JpaRepository <Colonia, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "update Colonia p set p.municipio.id = ?2 where p.id = ?1")
    void updateAllRelations(Long id_colonia, Long id_municipio);

    @Modifying
    @Query("select u from Colonia u where u.municipio.id=?1")
    List<Colonia> getMunicipio(Long id_municipio);

    /* @Modifying
    @Query("select p from Colonia p order by p.id desc")
    List<Colonia> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Colonia p where p.id = ?1")
    void deleteColonia(Long id);
}
