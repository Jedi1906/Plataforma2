package com.pi.Plataforma.Integral.service;


import com.pi.Plataforma.Integral.models.Donante;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IDonanteService {

    Donante save(Donante donante);

    List<Donante> getAll();

    Donante getById(Long id);

    List<Ussurioooo> getUssurioooo();

    List<Estado> getEstado();
}
