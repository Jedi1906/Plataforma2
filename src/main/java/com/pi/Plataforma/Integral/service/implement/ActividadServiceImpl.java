package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IActividadDao;
import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IActividadService;
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
public class ActividadServiceImpl implements IActividadService {

    @Autowired
    private IActividadDao actividadDao;

    public ActividadServiceImpl(){};

    @Override
    public Actividad save(Actividad actividad) {
        Actividad actividad1=new Actividad();
        actividad1.setNombre(actividad.getNombre());
        actividad1.setCupo(actividad.getCupo());
        actividad1.setHorario(actividad.getHorario());
        return actividadDao.getById(actividad1.getId());
    }

    @Override
    public Actividad update(Actividad actividad) {
        return null;
    }

    @Override
    public void delete(Long id) {

        actividadDao.deleteActividad(id);
    }

    @Override
    public List<Actividad> get() {

        System.out.println(actividadDao.findAll());
        return actividadDao.findAll();
    }

    @Override
    public List<Actividad> getAll() {
        return actividadDao.findAll();
    }
}
