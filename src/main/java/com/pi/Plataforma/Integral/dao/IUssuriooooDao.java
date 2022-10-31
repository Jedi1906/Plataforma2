package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IUssuriooooDao extends JpaRepository<Ussurioooo, Long> {

    @Modifying
    @Query("update ussurioooo p set p.nombre.id = ?2, p.apellido.id = ?3, p.fecha_creaci.id = ?4, p.correo.id = ?5, p.contraseña.id = ?6, p.status.id = ?7, p.telefono.id = ?8, p.fecha_actual.id = ?9, p.genero.id = ?10 where p.id = ?1")
    void updateAllRelations(Long id, String nombre, String apellido, String fecha_creaci, String correo, String contraseña, String status, String telefono, Date fecha_actual, String genero);


   /* @Modifying
    @Query("select p from Ussurioooo p order by p.id desc")
    List<Ussurioooo> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Ussurioooo p where p.id = ?1")
    void deleteUsuario(Long id);

}
