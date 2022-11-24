package com.pi.Plataforma.Integral.service.implement;


import com.pi.Plataforma.Integral.dao.IArchivoDao;
import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;
@Service
public class ArchivoServiceImpl implements IArchivoService {

    @Autowired
    private  IArchivoDao archivoDao;

    @Autowired
    private IUssuriooooDao iUsuario;
    public ArchivoServiceImpl(){}
    @Override
    @Transactional
    public Archivo save(Archivo archivo) {
        Archivo archivo1=new Archivo();
        archivo1.setNombre_archivo(archivo.getNombre_archivo());
        archivo1.setRuta(archivo.getRuta());
        archivo1 = archivoDao.save(archivo1);
        try{
            archivoDao.updateAllRelations(
                    archivo1.getId(),archivo.getUssurioooo().getId()
            );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
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
    public List<Archivo> get() {
        System.out.println(archivoDao.findAll());
        return archivoDao.findAll();
    }

    @Override
    public List<Archivo> getAll() {
        return archivoDao.findAll();
    }

    @Override
    public List<Archivo> getUssurioooo(Long id_usuario) {
        return archivoDao.getUssurioooo(id_usuario);
    }
}


