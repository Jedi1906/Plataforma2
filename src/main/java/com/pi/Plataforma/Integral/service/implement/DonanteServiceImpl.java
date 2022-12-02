package com.pi.Plataforma.Integral.service.implement;


import com.pi.Plataforma.Integral.dao.IDonanteDao;
import com.pi.Plataforma.Integral.dao.IEstadoDao;
import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Donante;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDonanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class DonanteServiceImpl implements IDonanteService {

    @Autowired
    private  IDonanteDao donanteDao;


    public DonanteServiceImpl(){}

    @Override
    public Donante save(Donante donante) {
        Donante donante1=new Donante();
        donante1.setTipo_donacion(donante.getTipo_donacion());
        donante1.setValidacion(donante.getValidacion());
        donante1.setTelefono_contacto(donante.getTelefono_contacto());
        donante1.setProviene_de(donante.getProviene_de());
        donante1.setObservaciones(donante.getObservaciones());
        donante1 = donanteDao.save(donante1);
        try {
            donanteDao.updateAllRelations(donante1.getId(), donante1.getUssurioooo().getId(), donante1.getEstado().getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return donanteDao.getById(donante1.getId());
    }

    @Override
    public Donante update(Donante donante) {
        return null;
    }

    @Override
    public void delete(Long id) {

        donanteDao.deleteDonante(id);
    }

    @Override
    public List<Donante> get() {
        System.out.println(donanteDao.findAll());
        return donanteDao.findAll();
    }

    @Override
    public List<Donante> getAll() {
        return donanteDao.findAll();
    }

    @Override
    public List<Donante> getUssurioooo(Long id_usuario) {
        return donanteDao.getUssurioooo(id_usuario);
    }

    @Override
    public List<Donante> getEstado(Long id_estado) {
        return donanteDao.getEstado(id_estado);
    }
}
