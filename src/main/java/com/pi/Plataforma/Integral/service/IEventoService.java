package com.pi.Plataforma.Integral.service;


import com.pi.Plataforma.Integral.models.Evento;

import java.util.List;

public interface IEventoService {
    Evento findByAll();

    Evento getById(Long id_evento);

    List<Evento> getBrokers();
}