package com.pi.Plataforma.Integral.service.implement;


import com.pi.Plataforma.Integral.dao.IEstadoDao;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IEstadoService;
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
public class EstadoServiceImpl implements IEstadoService {
    @Autowired
    private IEstadoDao estadoDao;

    public EstadoServiceImpl(){}

    @Override
    public Estado save(Estado estado) {
        Estado estado1 = new Estado();
        estado1.setNombre_estado(estado.getNombre_estado());

        return estadoDao.getById(estado1.getId());
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
    public List<Estado> getAll() {
        return null;
    }
}
