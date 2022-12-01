package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface IRolDao extends JpaRepository<Rol,Long> {


    @Modifying
    @Query("update Rol p set p.rol_nombre = ?2  where p.id = ?1")
    void updateAllRelations(Long id, String rol_nombre);


    /*@Modifying
    @Query("select p from Rol p order by p.id desc")
    List<Rol> getAllPage(Long id);*/



    @Modifying
    @Query("delete from Rol p where p.id = ?1")
    void deleteRol(Long id);
}
