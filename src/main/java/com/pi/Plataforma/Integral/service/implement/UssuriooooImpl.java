package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.*;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UssuriooooImpl implements IUssuriooooService {
    @Autowired
    private final IUssuriooooDao ussuriooooDao;

    public UssuriooooImpl(IUssuriooooDao ussuriooooDao) {
        this.ussuriooooDao = ussuriooooDao;
    }


    @Override
    @Transactional
    public Ussurioooo save(Ussurioooo ussurioooo) {
        return ussuriooooDao.save(ussurioooo);
    }

    @Override
    @Transactional
    public Ussurioooo update(Ussurioooo ussurioooo) {
        return ussuriooooDao.save(ussurioooo);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        ussuriooooDao.deleteUsuario(id);
    }

    @Override
    public List<Ussurioooo> get() {
        System.out.println(ussuriooooDao.findAll());
        return ussuriooooDao.findAll();
    }

    @Override
    public List<Ussurioooo> getAll() {
        return ussuriooooDao.findAll();
    }

    @Override
    public Ussurioooo getById(Long idussurioooo) {
        return ussuriooooDao.findAllById(idussurioooo);
    }

    @Override
    public Ussurioooo findByEmail(String correo) {
        return ussuriooooDao.findByCorreo(correo);
    }

    @Override
    public Optional<Ussurioooo> findById(Long id) {
        return ussuriooooDao.findById(id);
    }


}
