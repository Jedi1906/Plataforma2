package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActividadDao extends JpaRepository<Actividad,Long> {
}
