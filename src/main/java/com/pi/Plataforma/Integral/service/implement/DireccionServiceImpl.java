package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IDireccionDao;
import com.pi.Plataforma.Integral.models.Direccion;
import com.pi.Plataforma.Integral.service.IDireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class DireccionServiceImpl implements IDireccionService {

    @Autowired
    private  IDireccionDao direccionDao;

    public DireccionServiceImpl(){}

    @Override
    @Transactional
    public Direccion save(Direccion direccion) {
        Direccion direccion1=new Direccion();
        direccion1.setNombre(direccion.getNombre());
        direccion1.setCalle(direccion.getCalle());
        direccion1.setNumero_ext(direccion.getNumero_ext());
        direccion1.setNumero_int(direccion.getNumero_int());
        direccion1.setCp(direccion.getCp());
        direccion1 = direccionDao.save(direccion1);
        try {
            direccionDao.updateAllRelations(
                    direccion1.getId(), direccion.getColonia().getId(),
                    direccion.getMunicipio().getId(), direccion.getEstado().getId()
            );
        }catch ( Exception e){
            System.out.println(e.getMessage());
        }
        return direccionDao.getById(direccion1.getId());
    }

    @Override
    public Direccion update(Direccion direccion) {
        return null;
    }

    @Override
    public void delete(Long id) {
        direccionDao.deleteDireccion(id);

    }

    @Override
    public List<Direccion> get() {
        System.out.println(direccionDao.findAll());
        return direccionDao.findAll();
    }

    @Override
    public List<Direccion> getAll() {
        return direccionDao.findAll();
    }

    @Override
    public List<Direccion> getColonia(Long id_colonia) {
        return direccionDao.getColonia(id_colonia);
    }

    @Override
    public List<Direccion> getMunicipio(Long id_municipio) {
        return direccionDao.getMunicipio(id_municipio);
    }

    @Override
    public List<Direccion> getEstado(Long id_estado) {
        return direccionDao.getEstado(id_estado);
    }
}
