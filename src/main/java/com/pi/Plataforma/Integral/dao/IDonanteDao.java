package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Donante;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDonanteDao extends JpaRepository<Donante, Long> {

    @Query("select t from Estado t")
    List<Estado> getEstado();

    @Query("select t from Ussurioooo t")
    List<Ussurioooo> getUssurioooo();

    @Modifying
    @Query("update Donante p set p.estado.id = ?2, p.ussurioooo.id = ?3 where p.id = ?1")
    void updateAllRelations(Long id, Long id_estado, Long id_ussurioooo);

}
