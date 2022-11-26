package com.pi.Plataforma.Integral.service;


import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Donante;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IDonanteService {

    Donante save(Donante donante);
    Donante update(Donante donante);
    public void delete(Long id);


    List<Donante> get();
    List<Donante> getAll();

    List<Donante> getUssurioooo(Long id_usuario);
    List<Donante> getEstado(Long id_estado);
}
