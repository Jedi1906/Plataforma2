package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IActividadDao;
import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.service.IActividadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadServiceImpl implements IActividadService {

    private final IActividadDao actividadDao;

    public ActividadServiceImpl(IActividadDao actividadDao) {
        this.actividadDao = actividadDao;
    }

    @Override
    public List<Actividad> getAll() {
        return actividadDao.findAll();
    }
}
