package com.pi.Plataforma.Integral.service.implement;


import com.pi.Plataforma.Integral.dao.IArchivoDao;
import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.service.IArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.Long;
import java.util.List;
import javax.transaction.Transactional;
@Service
public class ArchivoServiceImpl implements IArchivoService {

    @Autowired
    private  IArchivoDao archivoDao;

    public ArchivoServiceImpl(){}
    @Override
    @Transactional
    public Archivo save(Archivo archivo) {
        Archivo archivo1=new Archivo();
        archivo1.setId(archivo.getId());
        archivo1.setNombre_archivo(archivo.getNombre_archivo());
        archivo1.setRuta(archivo.getRuta());
        archivoDao.updateAllRelations(
                archivo.getId(),archivo.getUssurioooo().getId()
        );
        return archivoDao.getById(archivo.getId());
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
    public List<Archivo> get() {
        System.out.println(archivoDao.findAll());
        return archivoDao.findAll();
    }

    @Override
    public List<Archivo> getAll() {
        return archivoDao.findAll();
    }
}


