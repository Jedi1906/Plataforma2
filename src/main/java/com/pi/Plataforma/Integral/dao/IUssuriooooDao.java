package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface IUssuriooooDao extends JpaRepository<Ussurioooo, Long> {

    @Modifying
    @Query("update Ussurioooo p set p.nombre = ?2, p.apellido = ?3, p.fecha_creaci = ?4, p.correo = ?5, p.contraseña = ?6, p.status = ?7, p.telefono = ?8, p.fecha_actual = ?9, p.genero = ?10 where p.id = ?1")
    void updateAllRelations(Long id, String nombre, String apellido, Date fecha_creaci, String correo, String contraseña, String staus, String telefono, Date fecha_actual, String genero);


    @Modifying
    @Query("update Ussurioooo p set p.nombre = ?2, p.apellido = ?3, p.fecha_creaci = ?4, p.correo = ?5, p.contraseña = ?6, p.status = ?7, p.telefono = ?8, p.fecha_actual = ?9, p.genero = ?10 where p.id = ?1")
    void update(Long id, String nombre, String apellido, Date fecha_creaci, String correo, String contraseña, String staus, String telefono, Date fecha_actual, String genero);


    Ussurioooo findByCorreo(String correo);


    /*@Modifying
    @Query("select p from Ussurioooo p order by p.id desc")
    List<Ussurioooo> getAllPage(Long id);*/


    @Modifying
    @Query("delete from Ussurioooo p where p.id = ?1")
    void deleteUsuario(Long id);


    Ussurioooo findAllById(Long idussurioooo);
}
