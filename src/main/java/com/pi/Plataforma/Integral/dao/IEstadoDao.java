package com.pi.Plataforma.Integral.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pi.Plataforma.Integral.models.Estado;

public interface IEstadoDao extends JpaRepository<Estado, Long> {
}
