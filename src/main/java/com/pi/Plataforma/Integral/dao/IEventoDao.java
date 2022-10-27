package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IEventoDao extends JpaRepository<Evento,Long> {

    @Modifying
    @Query("update evento p set p.ussurioooo.id = ?2 where p.id = ?1")
    void updateAllRelations(Long id_asistencia, Long id_ussurioooo);

}
