package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.*;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UssuriooooImpl implements IUssuriooooService {
    @Autowired
    private IUssuriooooDao ussuriooooDao;

    @Override
    @Transactional
    public Ussurioooo save(Ussurioooo ussurioooo) {
        Ussurioooo ussurioooo1=new Ussurioooo();
        ussurioooo1.setNombre(ussurioooo.getNombre());
        ussurioooo1.setApellido(ussurioooo.getApellido());
        ussurioooo1.setFecha_creaci(ussurioooo.getFecha_creaci());
        ussurioooo1.setCorreo(ussurioooo.getCorreo());
        ussurioooo1.setContraseña(ussurioooo.getContraseña());
        ussurioooo1.setStatus(ussurioooo.getStatus());
        ussurioooo1.setTelefono(ussurioooo.getTelefono());
        ussurioooo1.setFecha_actual(ussurioooo.getFecha_actual());
        ussurioooo1.setGenero(ussurioooo.getGenero());

        return ussuriooooDao.getById(ussurioooo1.getId());
    }

    @Override
    public Ussurioooo update(Ussurioooo ussurioooo) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Ussurioooo> getAll() {
        return ussuriooooDao.findAll();
    }



    @Override
    public Ussurioooo getById(Long idussurioooo) {
        return null;
        //return ussuriooooDao.getById(idussurioooo);
    }

    @Override
    @Transactional
    public void updatepassword(Ussurioooo ussurioooo) {
    /*String passwordBcrypt = passwordEncoder.encode(ussurioooo.getContraseña());
    ussuriooooDao.updatePassword(ussurioooo.getId(), passwordBcrypt);*/
    }

}
