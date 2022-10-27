package com.pi.Plataforma.Integral.service;


import com.pi.Plataforma.Integral.models.Evento;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IEventoService {

    Evento save(Evento evento);
    Evento update(Evento evento);
    public void delete(Long id);

    List<Evento> getAll();



}