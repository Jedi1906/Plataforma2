package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.AsistenciaDao;
import com.pi.Plataforma.Integral.dao.IActividadDao;
import com.pi.Plataforma.Integral.dao.IInstructorDao;
import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Instructor;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class AsistenciaServiceImpl implements IAsistenciaService {

    @Autowired
    private  AsistenciaDao asistenciaDao;

    public AsistenciaServiceImpl(){}
    @Override
    @Transactional
    public Asistencia save(Asistencia asistencia){
        Asistencia asistencia1 = new Asistencia();
        asistencia1.setFecha(asistencia.getFecha());
        asistencia1.setUbicacion(asistencia.getUbicacion());
        asistencia1.setValidacion(asistencia.getValidacion());
        /*
        asistencia1.setActividad(null);
        asistencia1.setInstructor(null);
        asistencia1.setUssurioooo(null);
        */
        asistenciaDao.updateAllRelations(
                asistencia.getId(),asistencia.getInstructor().getId()
                ,asistencia.getUssurioooo().getId(),
                asistencia.getActividad().getId()
        );
        return asistenciaDao.getById(asistencia1.getId());
    }
    @Override
    public Asistencia update(Asistencia asistencia) {
        return null;
    }

    @Override
    public void delete(Long id) {}

    @Override
    public List<Asistencia> getAll() {
        return asistenciaDao.findAll();
    }





}
