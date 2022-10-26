package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Instructor;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AsistenciaDao extends JpaRepository<Asistencia, Long> {

    @Query("select t from Instructor t")
    List<Instructor> getInstructor();

    @Query(value = "select t from Actividad t")
    List<Actividad> getActividad();

    @Query("select t from Ussurioooo  t")
    List<Ussurioooo> getUssurioooo();

    @Modifying
    @Query("update Asistencia p set p.instructor.id = ?2, p.ussurioooo.id = ?3,p.actividad.id = ?4 where p.id = ?1")
    void updateAllRelations(Long id, Long id_instructor, Long id_ussurioooo, Long id_actividad);
}
