package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Donacion;

import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDonacionDao extends JpaRepository<Donacion, Long> {

    @Modifying
    @Query("update donacion p set p.ussurioooo.id = ?2, where p.id_donacion = ?1")
    void updateAllRelations(Long id, Long id_usuario);

    /* @Modifying
    @Query("select p from Donacion p order by p.id desc")
    List<Donacion> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Donacion p where p.id = ?1")
    void deleteDonacion(Long id);



}
