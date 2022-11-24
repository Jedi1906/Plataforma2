package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IArchivoDao extends JpaRepository <Archivo,Long> {

    @Modifying()
    @Query(value = "update archivo p set t.ussurioooo.id =?2, p.nombre_archivo =?3, p.ruta =?4 where p.id = ?1", nativeQuery = true)
    void updateAllRelations(Long id, Long id_usuario);

    @Modifying
    @Query("select u from Archivo u where u.ussurioooo.id=?1")
    List<Archivo> getUssurioooo(Long id_usuario);

    /* @Modifying
    @Query("select p from Archivo p order by p.id desc")
    List<Archivo> getAllPage(Long id);*/


    @Modifying
    @Query("delete from Archivo p where p.id = ?1")
    void deleteArchivo(Long id);


}
