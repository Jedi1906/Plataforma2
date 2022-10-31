package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IMunicipioDao extends JpaRepository<Municipio, Long> {

    @Modifying
    @Query("update municipio p set p.estado.id = ?2, where p.id_municipio = ?1")
    void updateAllRelations(Long id, Long id_estado);

    /* @Modifying
    @Query("select p from Municipio p order by p.id desc")
    List<Municipio> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Municipio p where p.id = ?1")
    void deleteMunicipio(Long id);
}
