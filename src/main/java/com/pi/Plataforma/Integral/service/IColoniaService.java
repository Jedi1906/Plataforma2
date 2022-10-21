package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Colonia;

import java.util.List;


public interface IColoniaService {

    Colonia findByAll();

    Colonia getById(Long id_colonia);

    List<Colonia> getBrokers();
}
