package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.controller.MunicipioController;
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
    @Transactional
    public Municipio save(Municipio municipio) {
        Municipio municipio1=new Municipio();
        municipio1.setNombre_municipio(municipio.getNombre_municipio());
        municipio1 = municipioDao.save(municipio1);
        try{
        municipioDao.updateAllRelations(
                municipio1.getId(),municipio.getEstado().getId()
        );
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
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
    public List<Municipio> get() {
        System.out.println(municipioDao.findAll());
        return municipioDao.findAll();
    }

    @Override
    public List<Municipio> getAll() {
        return municipioDao.findAll();
    }

    @Override
    public List<Municipio> getEstado(Long id_estado) {
        return municipioDao.getEstado(id_estado);
    }
}
