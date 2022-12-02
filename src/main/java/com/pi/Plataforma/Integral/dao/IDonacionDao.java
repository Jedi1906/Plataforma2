package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.models.Donacion;

import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface IDonacionDao extends JpaRepository<Donacion, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "update Donacion p set p.ussurioooo.id = ?2 where p.id = ?1")
    void updateAllRelations(Long id, Long id_usuario);

    @Modifying
    @Query("select u from Donacion u where u.ussurioooo.id=?1")
    List<Donacion> getUssurioooo(Long id_usuario);

    /* @Modifying
    @Query("select p from Donacion p order by p.id desc")
    List<Donacion> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Donacion p where p.id = ?1")
    void deleteDonacion(Long id);



}
