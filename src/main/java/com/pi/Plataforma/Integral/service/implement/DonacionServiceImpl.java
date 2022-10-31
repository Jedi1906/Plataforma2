package com.pi.Plataforma.Integral.service.implement;


import com.pi.Plataforma.Integral.dao.IDonacionDao;
import com.pi.Plataforma.Integral.dao.IDonanteDao;
import com.pi.Plataforma.Integral.dao.IEventoDao;
import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Donacion;
import com.pi.Plataforma.Integral.models.Evento;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDonacionService;
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
public class DonacionServiceImpl implements IDonacionService {

    @Autowired
    private IDonacionDao donacionDao;

    public DonacionServiceImpl(){}

    @Override
    public Donacion save(Donacion donacion) {
        Donacion donacion1=new Donacion();
        donacion1.setTipo_donacion(donacion.getTipo_donacion());
        donacion1.setFecha_registro(donacion.getFecha_registro());
        donacion1.setStock(donacion.getStock());
        donacion1.setFecha_act(donacion.getFecha_act());
        donacion1.setValidado(donacion.isValidado());
        donacion1.setStatus(donacion.isStatus());
        donacionDao.updateAllRelations(donacion.getId(),donacion.getUssurioooo().getId());
        return donacionDao.getById(donacion1.getId());
    }

    @Override
    public Donacion update(Donacion donacion) {
        return null;
    }

    @Override
    public void delete(Long id) {
        donacionDao.deleteDonacion(id);

    }

    @Override
    public List<Donacion> getAll() {
        return donacionDao.findAll();
    }
}
