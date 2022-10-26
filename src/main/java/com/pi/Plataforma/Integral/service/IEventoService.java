package com.pi.Plataforma.Integral.service;


import com.pi.Plataforma.Integral.models.Evento;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IEventoService {
    Evento findByAll();

    Evento getById(Long id_evento);

    List<Evento> getBrokers();

    public boolean registrar(Evento evento);
    public List<Evento> obtener();
    public boolean actualizar(Evento evento);
    public boolean eliminar(Evento evento);

}