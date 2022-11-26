package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IEventoDao;
import com.pi.Plataforma.Integral.models.Evento;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IEventoService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventoServiceImpl implements IEventoService {
    @Autowired
    private IEventoDao eventoDao;


    public EventoServiceImpl(){}

    @Override
    @Transactional
    public Evento save(Evento evento) {
        Evento evento1=new Evento();
        evento1.setDescripcion(evento.getDescripcion());
        evento1.setFecha(evento.getFecha());
        evento1.setUbicacion(evento.getUbicacion());
        evento1.setUrl(evento.getUrl());
        evento1.setImagen(evento.getImagen());
        evento1.setInstrucciones(evento.getInstrucciones());
        evento1 =  eventoDao.save(evento1);
        try{
        eventoDao.updateAllRelations(
                evento1.getId(),evento.getUssurioooo().getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
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
    public List<Evento> get() {
        System.out.println(eventoDao.findAll());
        return eventoDao.findAll();
    }

    @Override
    public List<Evento> getAll() {
        return eventoDao.findAll();
    }

    @Override
    public List<Evento> getUssurio(Long id_usuario) {
        return eventoDao.getUssurio(id_usuario);
    }
}
