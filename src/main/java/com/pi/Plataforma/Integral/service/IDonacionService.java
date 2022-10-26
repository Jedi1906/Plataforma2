package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Donacion;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IDonacionService {

    Donacion save(Donacion donacion);

    List<Donacion> getAll();

    Donacion getById(Long id);

    List<Ussurioooo> getUssurioooo();


    List<Donacion> getBrokers();


    public boolean registrar(Donacion donacion);
    public List<Donacion> obtener();
    public boolean actualizar(Donacion donacion);
    public boolean eliminar(Donacion donacion);

}