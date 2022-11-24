package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IRolDao;
import com.pi.Plataforma.Integral.models.Rol;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IRolService;
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
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolDao rolDao;


    public RolServiceImpl(){};

    @Override
    @Transactional
    public Rol save(Rol rol) {return rolDao.save(rol);
    }

    @Override
    public Rol update(Rol rol) {
        return null;
    }

    @Override
    public void delete(Long id) {

        rolDao.deleteRol(id);

    }

    @Override
    public List<Rol> get() {
        System.out.println(rolDao.findAll());
        return rolDao.findAll();
    }

    @Override
    public List<Rol> getAll()
    {
        return rolDao.findAll();
    }



}