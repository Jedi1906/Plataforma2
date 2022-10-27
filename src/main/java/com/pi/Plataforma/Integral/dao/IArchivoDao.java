package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IArchivoDao extends JpaRepository <Archivo, Long> {

    @Modifying
    @Query("update archivo p set p.ussurioooo.id = ?3 where p.id = ?1")
    void updateAllRelations(Long id_archivo, Long id_usuario);


}
