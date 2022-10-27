package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IDireccionDao extends JpaRepository<Direccion,Long> {
    @Modifying
    @Query("update direccion p set p.colonia.id = ?2, p.municipio.id = ?3,p.estado.id = ?4 where p.id = ?1")
    void updateAllRelations(Long id_direccion, Long id_colonia, Long id_municipio, Long id_estado);

}
