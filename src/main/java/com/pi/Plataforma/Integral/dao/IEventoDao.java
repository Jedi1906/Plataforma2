package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventoDao extends JpaRepository<Evento,Long> {
}
