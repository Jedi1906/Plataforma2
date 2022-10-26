package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Rol;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IRolService {

    List<Rol> getAll();

    public boolean registrar(Rol rol);
    public List<Rol> obtener();
    public boolean actualizar(Rol rol);
    public boolean eliminar(Rol rol);



}
