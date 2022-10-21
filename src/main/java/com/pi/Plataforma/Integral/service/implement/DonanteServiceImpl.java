package com.pi.Plataforma.Integral.service.implement;


import com.pi.Plataforma.Integral.dao.IDonanteDao;
import com.pi.Plataforma.Integral.dao.IEstadoDao;
import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Donante;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDonanteService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DonanteServiceImpl implements IDonanteService {

    private final IDonanteDao donanteDao;

    private final IEstadoDao estadoDao;

    private final IUssuriooooDao ussuriooooDao;

    public DonanteServiceImpl(IDonanteDao donanteDao, IEstadoDao estadoDao, IUssuriooooDao ussuriooooDao)
    {
        this.donanteDao=donanteDao;
        this.estadoDao=estadoDao;
        this.ussuriooooDao=ussuriooooDao;
    }

    @Override
    @Transactional
    public Donante save(Donante donante){
        Long id_usuario = donante.getUssurioooo().getId();
        donante.setUssurioooo(null);

        Long id_estado = donante.getEstado().getId();
        donante.setEstado(null);

        Donante donanteSave = donanteDao.save(donante);

        donanteDao.updateAllRelations(donanteSave.getId(), id_estado, id_usuario);


        return  donanteDao.getById(donante.getId());

    }

    @Override
    public List<Donante> getAll() {return donanteDao.findAll();}

    @Override
    public Donante getById(Long id) {
        return donanteDao.getById(id);
    }

    @Override
    public List<Ussurioooo> getUssurioooo() {
        return null;
    }

    @Override
    public List<Estado> getEstado() {
        return null;
    }

}
