package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IColoniaDao;
import com.pi.Plataforma.Integral.models.Colonia;
import com.pi.Plataforma.Integral.models.Municipio;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IColoniaService;
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
public class ColoniaServicelmpl implements IColoniaService {

    @Autowired
    private IColoniaDao coloniaDao;

    @Autowired
    private IColoniaDao iColoniaDao;

    public ColoniaServicelmpl(){}

    @Override
    @Transactional
    public Colonia save(Colonia colonia) {
        Colonia colonia1=new Colonia();
        colonia1.setNombre_colonia(colonia.getNombre_colonia());
        colonia1.setCp(colonia.getCp());
        colonia1.setCiudad(colonia.getCp());
        colonia1.setAsentamiento(colonia.getAsentamiento());
        colonia1 = coloniaDao.save(colonia1);
        try {
            coloniaDao.updateAllRelations(
                    colonia1.getId(), colonia.getMunicipio().getId()
            );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return coloniaDao.getById(colonia1.getId());
    }

    @Override
    public Colonia update(Colonia colonia) {
        return null;
    }

    @Override
    public void delete(Long id) {

        coloniaDao.deleteColonia(id);
    }

    @Override
    public List<Colonia> get() {
        System.out.println(coloniaDao.findAll());
        return coloniaDao.findAll();
    }

    @Override
    public List<Colonia> getAll() {
        return null;
    }

    @Override
    public List<Colonia> getMunicipio(Long id_municipio) {
        return coloniaDao.getMunicipio(id_municipio);
    }
}
