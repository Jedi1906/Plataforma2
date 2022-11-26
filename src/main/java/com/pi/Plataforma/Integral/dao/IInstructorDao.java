package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Instructor;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IInstructorDao extends JpaRepository<Instructor, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "update Instructor p set p.estado.id = ?2, p.ussurioooo.id = ?3 where p.id = ?1")
    void updateAllRelations(Long id, Long id_estado, Long id_usuario);

    @Modifying
    @Query("select u from Instructor u where u.ussurioooo.id=?1")
    List<Instructor> getUssurioooo(Long id_usuario);

    @Modifying
    @Query(value = "select u from Instructor u where u.estado.id=?1")
    List<Instructor> getEstado(Long id_estado);

    /* @Modifying
    @Query("select p from Instructor p order by p.id desc")
    List<Instructor> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Instructor p where p.id = ?1")
    void deleteInstructor(Long id);
}
