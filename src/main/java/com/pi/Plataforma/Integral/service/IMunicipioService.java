package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Municipio;

import java.util.List;

public interface IMunicipioService {
    Municipio save(Municipio municipio);
    Municipio update(Municipio municipio);
    public  void delete(Long id);


    List<Municipio> get();
    List<Municipio> getAll();

    List<Municipio> getEstado( Long id_estado);
}
