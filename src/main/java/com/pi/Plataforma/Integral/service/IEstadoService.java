package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IEstadoService {
    Estado save(Estado estado);
    Estado update(Estado estado);
    public void delete(Long id);

    List<Estado> getAll();



}
