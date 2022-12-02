package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.models.Donante;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface IDonanteDao extends JpaRepository<Donante, Long> {

    @Modifying(clearAutomatically = true)
    @Query("update Donante p set p.estado.id = ?2, p.ussurioooo.id = ?3 where p.id = ?1")
    void updateAllRelations(Long id, Long id_estado, Long id_ussurioooo);

    @Modifying
    @Query("select u from Donante u where u.ussurioooo.id=?1")
    List<Donante> getUssurioooo(Long id_usuario);


    @Modifying
    @Query("select u from Donante u where u.estado.id=?1")
    List<Donante> getEstado(Long id_estado);


    /* @Modifying
    @Query("select p from Donante p order by p.id desc")
    List<Donante> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Donante p where p.id = ?1")
    void deleteDonante(Long id);
}
