package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IArchivoDao extends JpaRepository <Archivo, Long> {

    @Modifying
    @Query("update archivo p set p.ussurioooo.id = ?3 where p.id = ?1")
    void updateAllRelations(Long id_archivo, Long id_usuario);

    /* @Modifying
    @Query("select p from Archivo p order by p.id desc")
    List<Archivo> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Archivo p where p.id = ?1")
    void deleteArchivo(Long id);

}
