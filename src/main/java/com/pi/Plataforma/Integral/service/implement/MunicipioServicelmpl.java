package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IColoniaDao;
import com.pi.Plataforma.Integral.dao.IMunicipioDao;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Municipio;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IMunicipioService;
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
public class MunicipioServicelmpl implements IMunicipioService {
    @Autowired
    private IMunicipioDao municipioDao;


    public MunicipioServicelmpl(){}
    @Override
    public Municipio save(Municipio municipio) {
        Municipio municipio1=new Municipio();
        municipio1.setNombre_municipio(municipio.getNombre_municipio());
        municipioDao.updateAllRelations(
                municipio.getId(),municipio.getEstado().getId()
        );
        return municipioDao.getById(municipio1.getId());
    }

    @Override
    public Municipio update(Municipio municipio) {
        return null;
    }

    @Override
    public void delete(Long id) {
        municipioDao.deleteMunicipio(id);

    }

    @Override
    public List<Municipio> getAll() {
        return municipioDao.findAll();
    }
}
