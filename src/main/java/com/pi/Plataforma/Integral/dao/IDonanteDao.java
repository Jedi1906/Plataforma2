package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Donante;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDonanteDao extends JpaRepository<Donante, Long> {

    @Modifying
    @Query("update Donante p set p.estado.id = ?2, p.ussurioooo.id = ?3 where p.id = ?1")
    void updateAllRelations(Long id, Long id_estado, Long id_ussurioooo);


    /* @Modifying
    @Query("select p from Donante p order by p.id desc")
    List<Donante> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Donante p where p.id = ?1")
    void deleteDonante(Long id);
}
