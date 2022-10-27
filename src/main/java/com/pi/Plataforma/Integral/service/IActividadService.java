package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Ussurioooo;


import java.util.List;

public interface IActividadService {

    Actividad save(Actividad actividad);
    Actividad update(Actividad actividad);
    public void delete(Long id);



    List<Actividad> getAll();

}
