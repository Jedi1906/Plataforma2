package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Colonia;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;


public interface IColoniaService {

    Colonia findByAll();

    Colonia getById(Long id_colonia);

    List<Colonia> getBrokers();


    public boolean registrar(Colonia colonia);
    public List<Colonia> obtener();
    public boolean actualizar(Colonia colonia);
    public boolean eliminar(Colonia colonia);


}
