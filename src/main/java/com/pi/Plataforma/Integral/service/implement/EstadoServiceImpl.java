package com.pi.Plataforma.Integral.service.implement;


import com.pi.Plataforma.Integral.dao.IEstadoDao;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.service.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstadoServiceImpl implements IEstadoService {
    @Autowired
    private IEstadoDao estadoDao;

    public EstadoServiceImpl(){}

    @Override
    public Estado save(Estado estado) { return estadoDao.save(estado);
    }

    @Override
    public Estado update(Estado estado) {
        return null;
    }

    @Override
    public void delete(Long id) {
        estadoDao.deleteEstado(id);

    }

    @Override
    public List<Estado> get() {
        System.out.println(estadoDao.findAll());
        return estadoDao.findAll();
    }

    @Override
    public List<Estado> getAll() {
        return estadoDao.findAll();
    }
}
