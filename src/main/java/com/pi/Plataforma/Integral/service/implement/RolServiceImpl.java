package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IRolDao;
import com.pi.Plataforma.Integral.models.Rol;
import com.pi.Plataforma.Integral.service.IRolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements IRolService {

    private final IRolDao rolDao;

    public RolServiceImpl(IRolDao rolDao) {
        this.rolDao = rolDao;
    }

    @Override
    public List<Rol> getAll() {
        return rolDao.findAll();
    }
}