package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.lang.Long;
import java.util.List;

public interface IArchivoDao extends JpaRepository <Archivo,Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "update archivo p set t.ussurioooo.id =?2, p.nombre_archivo =?3, p.ruta =?4 where p.id = ?1", nativeQuery = true)
    void updateAllRelations(Long id, Long id_usuario);



    @Modifying
    @Query("delete from Archivo p where p.id = ?1")
    void deleteArchivo(Long id);


}
