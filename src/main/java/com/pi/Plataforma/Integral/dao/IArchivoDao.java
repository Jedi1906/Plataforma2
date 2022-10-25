package com.pi.Plataforma.Integral.dao;

import com.pi.Plataforma.Integral.models.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArchivoDao extends JpaRepository <Archivo, Long> {
}
