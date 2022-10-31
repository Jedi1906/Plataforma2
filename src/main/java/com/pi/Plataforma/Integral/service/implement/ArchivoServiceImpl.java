package com.pi.Plataforma.Integral.service.implement;


import com.pi.Plataforma.Integral.dao.IArchivoDao;
import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArchivoServiceImpl implements IArchivoService {

    @Autowired
    private  IArchivoDao archivoDao;


    @Override
    public Archivo save(Archivo archivo) {
        Archivo archivo1=new Archivo();
        archivo1.setNombre_archivo(archivo.getNombre_archivo());
        archivo1.setRuta(archivo.getRuta());
        archivoDao.updateAllRelations(
                archivo.getId(),archivo.getUssurioooo().getId());
        return archivoDao.getById(archivo1.getId());

    }

    @Override
    public Archivo update(Archivo archivo) {
        return null;
    }

    @Override
    public void delete(Long id) {

        archivoDao.deleteArchivo(id);
    }

    @Override
    public List<Archivo> getAll() {
        return archivoDao.findAll();
    }
}


