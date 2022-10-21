package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UssuriooooImpl implements IUssuriooooService {
    @Autowired
    private IUssuriooooDao ussuriooooDao;


    @Override
    @Transactional(readOnly = true)
    public Ussurioooo findByEmail(String mail) {
        return null;
        //return ussuriooooDao.findByCorreo(mail);
    }

    @Override
    public Ussurioooo getById(Long idussurioooo) {
        return null;
        //return ussuriooooDao.getById(idussurioooo);
    }

    //Método para insertar gerente /broker
    @Override
    @Transactional
    public void saveBroker(Ussurioooo ussurioooo) {
    /*List<Rol> role = new ArrayList<>();
    role.add(rolDao.getRolById(ussurioooo.getRolList().get(0).getId()));
    persona.setRolList(role);
    String passwordBcrypt = passwordEncoder.encode(persona.getContraseña());
    ussurioooo.setContraseña(passwordBcrypt);
    ussurioooo.setGerente(null);
    ussuriooooDao.save(ussurioooo);*/
    }

    //Devuelve Gerentes
    @Override
    public List<Ussurioooo> getBrokers() {
        return null;
        //return ussuriooooDao.getByRolList(2L,1L);
    }

    @Override
    public void updateBroker(Ussurioooo ussurioooo) {

    }

    @Override
    @Transactional
    public void updatepassword(Ussurioooo ussurioooo) {
    /*String passwordBcrypt = passwordEncoder.encode(ussurioooo.getContraseña());
    ussuriooooDao.updatePassword(ussurioooo.getId(), passwordBcrypt);*/
    }

    @Override
    public void sendRecoverPassword(Ussurioooo ussurioooo) {

    }
}
