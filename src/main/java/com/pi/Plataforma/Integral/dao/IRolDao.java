package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolDao extends JpaRepository<Rol,Long> {
    /*@Transactional(propagation = Propagation.REQUIRES_NEW)
    @Query("select r from Rol r where r.id =?1")
    Rol getRolById(Long idRol);*/
}
