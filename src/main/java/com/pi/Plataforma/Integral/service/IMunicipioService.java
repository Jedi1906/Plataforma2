package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Municipio;

import java.util.List;

public interface IMunicipioService {
    Municipio FindByAll();

    Municipio getById(Long id_municipio);

    List<Municipio> getBrokers();
}
