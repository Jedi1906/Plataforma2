package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IEstadoDao;
import com.pi.Plataforma.Integral.dao.IInstructorDao;
import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Donante;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Instructor;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IIntructorService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InstructorService implements IIntructorService {

    private final IInstructorDao instructorDao;

    private final IEstadoDao estadoDao;

    private final IUssuriooooDao ussuriooooDao;

    public InstructorService(IInstructorDao instructorDao, IEstadoDao estadoDao, IUssuriooooDao ussuriooooDao)
    {
        this.instructorDao=instructorDao;
        this.estadoDao=estadoDao;
        this.ussuriooooDao=ussuriooooDao;
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor){
        Long id_usuario = instructor.getUssurioooo().getId();
        instructor.setUssurioooo(null);

        Long id_estado = instructor.getEstado().getId();
        instructor.setEstado(null);

        Instructor intructorSave = instructorDao.save(instructor);

        instructorDao.updateAllRelations(intructorSave.getId(), id_estado, id_usuario);

        return  instructorDao.getById(instructor.getId());

    }

    @Override
    public Instructor save(Donante donante) {
        return null;
    }

    @Override
    public List<Instructor> getAll() {return instructorDao.findAll();}

    @Override
    public Instructor getById(Long id) {
        return instructorDao.getById(id);
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
