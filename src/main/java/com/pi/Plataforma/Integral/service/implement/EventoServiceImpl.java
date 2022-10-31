package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IEventoDao;
import com.pi.Plataforma.Integral.models.Evento;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventoServiceImpl implements IEventoService {
    @Autowired
    private IEventoDao eventoDao;

    public EventoServiceImpl(){}

    @Override
    public Evento save(Evento evento) {
        Evento evento1=new Evento();
        evento1.setDescripcion(evento.getDescripcion());
        evento1.setFecha(evento.getFecha());
        evento1.setUbicacion(evento.getUbicacion());
        evento1.setUrl(evento.getUrl());
        evento1.setImagen(evento.getImagen());
        evento1.setInstrucciones(evento.getInstrucciones());
        eventoDao.updateAllRelations(
                evento.getId(),evento.getUssurioooo().getId());
        return eventoDao.getById(evento1.getId());
    }

    @Override
    public Evento update(Evento evento) {
        return null;
    }

    @Override
    public void delete(Long id) {
        eventoDao.deleteEvento(id);

    }

    @Override
    public List<Evento> getAll() {
        return eventoDao.findAll();
    }
}
