package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Instructor;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IInstructorDao extends JpaRepository<Instructor, Long> {

    @Modifying
    @Query("update instructor p set p.estado.id = ?2, p.usuario.id = ?3 where p.id = ?1")
    void updateAllRelations(Long id, Long id_estado, Long id_usuario);


    /* @Modifying
    @Query("select p from Instructor p order by p.id desc")
    List<Instructor> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Instructor p where p.id = ?1")
    void deleteInstructor(Long id);
}
