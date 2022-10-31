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

@Service
public class ColoniaServicelmpl implements IColoniaService {

    @Autowired
    private IColoniaDao coloniaDao;

    public ColoniaServicelmpl(){}

    @Override
    @Transactional
    public Colonia save(Colonia colonia) {
        Colonia colonia1=new Colonia();
        colonia1.setNombre_colonia(colonia.getNombre_colonia());
        colonia1.setCp(colonia.getCp());
        colonia1.setCiudad(colonia.getCp());
        colonia1.setAsentamiento(colonia.getAsentamiento());
        coloniaDao.updateAllRelations(
                colonia.getId(),colonia.getMunicipio().getId()
        );
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
    public List<Colonia> getAll() {
        return null;
    }
}
