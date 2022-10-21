package com.pi.Plataforma.Integral.service.implement;


import com.pi.Plataforma.Integral.dao.IEstadoDao;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.service.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EstadoServiceImpl implements IEstadoService {
    @Autowired
    private IEstadoDao estadoDao;



    @Transactional(readOnly = true)
    public Estado findByAll() {
        return null;
        //return estadoDao.findByAll();
    }


    public Estado getById(Long id_estado) {
        return null;
        //return estadoDao.getById(id_estado);
    }

    @Override
    public List<Estado> getBrokers() {
        return null;
    }
}
