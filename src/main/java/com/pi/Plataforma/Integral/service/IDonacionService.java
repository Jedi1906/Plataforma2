package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Donacion;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IDonacionService {
    Donacion save(Donacion donacion);
    Donacion update(Donacion donacion);
    public void delete(Long id);


    List<Donacion> get();
    List<Donacion> getAll();


    List<Donacion> getUssurioooo(Long id_usuario);


}