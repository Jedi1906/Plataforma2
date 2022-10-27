package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Colonia;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;


public interface IColoniaService {

    Colonia save(Colonia colonia);
    Colonia update(Colonia colonia);
    public void delete(Long id);


    List<Colonia> getAll();

}
