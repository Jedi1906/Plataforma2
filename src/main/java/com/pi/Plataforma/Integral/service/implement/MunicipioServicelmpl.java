package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IColoniaDao;
import com.pi.Plataforma.Integral.models.Municipio;
import com.pi.Plataforma.Integral.service.IMunicipioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MunicipioServicelmpl implements IMunicipioService {
    @Autowired
    private IColoniaDao coloniaDao;

    @Transactional(readOnly = true)
    public Municipio findByAll(){
        return null;
        //return municipioDao.findByAll();
    }

    @Override
    public Municipio FindByAll() {
        return null;
    }

    public Municipio getById(Long id_municipio){
        return null;

        //return municipioDao.getById(id_municipio);
    }

    @Override
    public List<Municipio> getBrokers() {
        return null;
    }
}
