package com.pi.Plataforma.Integral.service.implement;


import com.pi.Plataforma.Integral.dao.IArchivoDao;
import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class ArchivoServiceImpl implements IArchivoService {

    @Autowired
    private final IArchivoDao archivoDao;

    @Autowired
    private final IUssuriooooDao iUsuario;

    public ArchivoServiceImpl(IArchivoDao archivoDao, IUssuriooooDao iUsuario) {
        this.archivoDao = archivoDao;
        this.iUsuario = iUsuario;
    }

    @Override
    @Transactional
    public Archivo save(Archivo archivo) {
        Ussurioooo ussuriooooSave = iUsuario.save(archivo.getUssurioooo());

        Archivo archivoSave = archivoDao.save(archivo);
        archivoSave.setNombre_archivo(archivo.getNombre_archivo());
        archivoSave.setRuta(archivo.getRuta());

        archivoDao.updateAllRelations(archivoSave.getId(), archivo.getUssurioooo().getId());

        return archivoDao.getById(archivoSave.getId());

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

    @Override
    public List<Ussurioooo> getUssurioooo() {
        return archivoDao.getUssurioooo();
    }

}


