package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Estado;

import java.util.List;

public interface IEstadoService {
    Estado findByAll();

    Estado getById(Long id_estado);

    List<Estado> getBrokers();
}
