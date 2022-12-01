package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AsistenciaDao extends JpaRepository<Asistencia, Long> {


    @Modifying(clearAutomatically = true)
    @Query(value = "update asistencia p set p.instructor.id = ?2, p.ussurioooo.id = ?3,p.actividad.id = ?4 where p.id = ?1", nativeQuery = true)
    void updateAllRelations(Long id, Long id_instructor, Long id_usuario, Long id_actividad);

    @Modifying
    @Query("select u from Asistencia u where u.ussurioooo.id=?1")
    List<Asistencia> getUssurioooo(Long id_usuario);

    @Modifying
    @Query("select u from Asistencia u where u.actividad.id=?1")
    List<Asistencia> getActividad(Long id_actividad);

    @Modifying
    @Query("select u from Asistencia u where u.instructor.id=?1")
    List<Asistencia> getInstructor(Long id_instructor);

   /* @Modifying
    @Query("select p from Asistencia p order by p.id desc")
    List<Asistencia> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Asistencia p where p.id = ?1")
    void deleteAsistencia(Long id);





}
