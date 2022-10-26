package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Municipio;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IMunicipioService {
    Municipio FindByAll();

    Municipio getById(Long id_municipio);

    List<Municipio> getBrokers();

    public boolean registrar(Municipio municipio);
    public List<Municipio> obtener();
    public boolean actualizar(Municipio municipio);
    public boolean eliminar(Municipio municipio);

}
