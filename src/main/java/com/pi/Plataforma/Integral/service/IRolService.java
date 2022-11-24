package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Rol;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IRolService {

    Rol save(Rol rol);
    Rol update(Rol rol);
    public void delete(Long id);
    List<Rol> get();

    List<Rol> getAll();




}
