package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Direccion;
import com.pi.Plataforma.Integral.models.Ussurioooo;


import java.util.List;

public interface IDireccionService {

    Direccion save(Direccion direccion);
    Direccion update(Direccion direccion);
    public void delete(Long id);


    List<Direccion> getAll();

}
