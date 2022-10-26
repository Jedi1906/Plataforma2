package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Direccion;
import com.pi.Plataforma.Integral.models.Ussurioooo;


import java.util.List;

public interface IDireccionService {
    Direccion findByAll();

    Direccion getById(Long id_direccion);

    List<Direccion> getBrokers();

    public boolean registrar(Direccion direccion);
    public List<Direccion> obtener();
    public boolean actualizar(Direccion direccion);
    public boolean eliminar(Direccion direccion);

}
