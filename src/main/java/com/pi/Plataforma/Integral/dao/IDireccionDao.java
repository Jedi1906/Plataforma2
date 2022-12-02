package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.models.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface IDireccionDao extends JpaRepository<Direccion,Long> {
    @Modifying(clearAutomatically = true)
    @Query(value = "update Direccion p set p.colonia.id = ?2, p.municipio.id = ?3,p.estado.id = ?4 where p.id = ?1", nativeQuery = true)
    void updateAllRelations(Long id_direccion, Long id_colonia, Long id_municipio, Long id_estado);

    @Modifying
    @Query("select u from Direccion u where u.colonia.id=?1")
    List<Direccion> getColonia(Long id_colonia);

    @Modifying
    @Query("select u from Direccion u where u.municipio.id=?1")
    List<Direccion> getMunicipio(Long id_municipio);

    @Modifying
    @Query("select u from Direccion u where u.estado.id=?1")
    List<Direccion> getEstado(Long id_estado);


    /* @Modifying
    @Query("select p from Direccion p order by p.id desc")
    List<Direccion> getAllPage(Long id);*/

    @Modifying
    @Query("delete from Direccion p where p.id = ?1")
    void deleteDireccion(Long id);
}
