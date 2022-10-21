package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IDireccionDao;
import com.pi.Plataforma.Integral.models.Direccion;
import com.pi.Plataforma.Integral.service.IDireccionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionServiceImpl implements IDireccionService {
    private final IDireccionDao direccionDao;

    public DireccionServiceImpl(IDireccionDao direccionDao) {
        this.direccionDao = direccionDao;
    }

    @Override
    public List<Direccion> getAll() {
        return direccionDao.findAll();
    }
}
