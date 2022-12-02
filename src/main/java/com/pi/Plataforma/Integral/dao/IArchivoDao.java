package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface IArchivoDao extends JpaRepository <Archivo,Long> {

    @Modifying(clearAutomatically = true)
    @Query("update Archivo p set p.ussurioooo.id = ?2 where p.id = ?1")
    void updateAllRelations(Long id, Long id_ussurioooo);

    @Query("select p from Ussurioooo p ")
    List<Ussurioooo> getUssurioooo();


    /* @Modifying
    @Query("select p from Archivo p order by p.id desc")
    List<Archivo> getAllPage(Long id);*/


    @Modifying
    @Query("delete from Archivo p where p.id = ?1")
    void deleteArchivo(Long id);


}
