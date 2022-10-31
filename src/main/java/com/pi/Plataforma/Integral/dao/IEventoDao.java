package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IEventoDao extends JpaRepository<Evento,Long> {

    @Modifying
    @Query("update evento p set p.ussurioooo.id = ?2 where p.id = ?1")
    void updateAllRelations(Long id_asistencia, Long id_ussurioooo);

    /* @Modifying
    @Query("select p from Evento p order by p.id desc")
    List<Evento> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Evento p where p.id = ?1")
    void deleteEvento(Long id);
}
