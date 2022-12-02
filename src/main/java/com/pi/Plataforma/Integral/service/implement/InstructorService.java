package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IInstructorDao;
import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Donante;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Instructor;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IIntructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class InstructorService implements IIntructorService {

    @Autowired
    private IInstructorDao instructorDao;


    public InstructorService(){}

    @Override
    public Instructor save(Instructor instructor) {
        Instructor instructor1=new Instructor();
        instructor1.setCorreoSec(instructor.getCorreoSec());
        instructor1.setTelefonoPart(instructor.getTelefonoPart());
        instructor1.setFechaNac(instructor.getFechaNac());
        instructor1.setArea(instructor.getArea());
        instructor1.setEspecialidad(instructor.getEspecialidad());
        instructor1 = instructorDao.save(instructor1);
        try {
            instructorDao.updateAllRelations(instructor1.getId(), instructor.getEstado().getId(), instructor.getUssurioooo().getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return instructorDao.getById(instructor1.getId());
    }

    @Override
    public Instructor update(Instructor instructor) {
        return null;
    }

    @Override
    public void delete(Long id) {
        instructorDao.deleteInstructor(id);

    }

    @Override
    public List<Instructor> get() {
        System.out.println(instructorDao.findAll());
        return instructorDao.findAll();
    }

    @Override
    public List<Instructor> getAll() {
        return instructorDao.findAll();
    }

    @Override
    public List<Instructor> getEstado(Long id_estado) {
        return instructorDao.getEstado(id_estado);
    }

    @Override
    public List<Instructor> getUssurioooo(Long id_usuario) {
        return instructorDao.getUssurioooo(id_usuario);
    }
}
