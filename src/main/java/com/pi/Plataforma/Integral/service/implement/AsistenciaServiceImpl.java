package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.AsistenciaDao;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.service.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
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
        asistencia1 = asistenciaDao.save(asistencia1);
        /*
        asistencia1.setActividad(null);
        asistencia1.setInstructor(null);
        asistencia1.setUssurioooo(null);
        */
        try {
            asistenciaDao.updateAllRelations(
                    asistencia1.getId(), asistencia.getInstructor().getId()
                    , asistencia.getUssurioooo().getId(),
                    asistencia.getActividad().getId()
            );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return asistenciaDao.getById(asistencia1.getId());
    }
    @Override
    public Asistencia update(Asistencia asistencia) {
    return null;}
    @Override
    public void delete(Long id){asistenciaDao.deleteAsistencia(id);}

    @Override
    public List<Asistencia> get() {
        System.out.println(asistenciaDao.findAll());
        return asistenciaDao.findAll();
    }

    @Override
    public List<Asistencia> getAll() {
        return asistenciaDao.findAll();
    }

    @Override
    public List<Asistencia> getActividad( Long id_actividad) {
        return asistenciaDao.getActividad(id_actividad);
    }

    @Override
    public List<Asistencia> getUssurioooo(Long id_usuario) {
        return asistenciaDao.getUssurioooo(id_usuario);
    }

    @Override
    public List<Asistencia> getInstructor(Long id_instructor) {
        return asistenciaDao.getInstructor(id_instructor);
    }

}


