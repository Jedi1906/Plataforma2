package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Ussurioooo;


import java.util.List;

public interface IActividadService {

    List<Actividad> getAll();

    public boolean registrar(Actividad actividad);
    public List<Actividad> obtener();
    public boolean actualizar(Actividad actividad);
    public boolean eliminar(Actividad actividad);
}
