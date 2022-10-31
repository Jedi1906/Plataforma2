package com.pi.Plataforma.Integral.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pi.Plataforma.Integral.models.Estado;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IEstadoDao extends JpaRepository<Estado, Long> {

    @Modifying
    @Query("update Estado p set p.nombre_estado = ?2  where p.id = ?1")
    void updateAllRelations(Long id, String nombre_estado);


    /*@Modifying
    @Query("select p from Estado p order by p.id desc")
    List<Estado> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Rol p where p.id = ?1")
    void deleteEstado(Long id);

}
