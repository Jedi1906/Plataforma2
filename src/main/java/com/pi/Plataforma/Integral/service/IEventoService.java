package com.pi.Plataforma.Integral.service;


import com.pi.Plataforma.Integral.models.Evento;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;
import java.util.Optional;

public interface IEventoService {

    Evento save(Evento evento);
    Evento update(Evento evento);
    public void delete(Long id);


    List<Evento> get();
    List<Evento> getAll();

    List<Evento> getUssurio(Long id_usuario);


    Evento getById(Long id);

    Optional<Evento> findById(Long id);


}