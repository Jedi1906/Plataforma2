package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IActividadDao extends JpaRepository<Actividad,Long> {

    @Modifying
    @Query("update Actividad p set p.nombre = ?2, p.cupo = ?3, p.horario = ?4  where p.id = ?1")
    void updateAllRelations(Long id, String nombre, String cupo, String horario);


    /*@Modifying
    @Query("select p from Actividad p order by p.id desc")
    List<Actividad> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Actividad p where p.id = ?1")
    void deleteActividad(Long id);

    Actividad findAllById(Long id);
}
