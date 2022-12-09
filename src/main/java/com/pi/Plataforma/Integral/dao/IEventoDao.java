package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface IEventoDao extends JpaRepository<Evento,Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "update Evento p set p.ussurioooo.id = ?2 where p.id = ?1")
    void updateAllRelations(Long id_asistencia, Long id_usuario);

    @Modifying
    @Query("select u from Evento u where u.ussurioooo.id=?1")
    List<Evento> getUssurio(Long id_usuario);

    /* @Modifying
    @Query("select p from Evento p order by p.id desc")
    List<Evento> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Evento p where p.id = ?1")
    void deleteEvento(Long id);

    Evento findAllById(Long id);
}
