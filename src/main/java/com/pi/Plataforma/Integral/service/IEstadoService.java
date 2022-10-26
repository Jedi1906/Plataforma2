package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IEstadoService {
    Estado findByAll();

    Estado getById(Long id_estado);

    List<Estado> getBrokers();

    public boolean registrar(Estado estado);
    public List<Estado> obtener();
    public boolean actualizar(Estado estado);
    public boolean eliminar(Estado estado);

}
