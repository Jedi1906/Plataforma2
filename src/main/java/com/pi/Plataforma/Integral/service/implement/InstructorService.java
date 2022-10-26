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

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorService implements IIntructorService {

    private  IInstructorDao instructorDao;

    private  IEstadoDao estadoDao;

    private  IUssuriooooDao ussuriooooDao;

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


    @Override
    public boolean registrar(Instructor instructor){

        boolean registrar = false;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO instructor values (NULL,'"+instructor.getCorreoSec()+"','"+instructor.getTelefonoPart()+"','"+instructor.getEstado()+"','"+instructor.getFechaNac()+"','"+instructor.getUssurioooo()+"','"+instructor.getArea()+"','"+instructor.getEspecialidad()+"')'";


        try {
            stm.execute(sql);
            registrar=true;
            stm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error no se pudo registrar");

        }
        return registrar;
    }

    @Override
    public List<Instructor> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM instructor ORDER BY id_instructor";

        List<Instructor> listaInstructor= new ArrayList<Instructor>();

        try {

            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Instructor c=new Instructor();
                c.setId(rs.getLong(1));
                c.setCorreoSec(rs.getString(2));
                c.setTelefonoPart(rs.getString(3));
                //c.setEstado();
                c.setFechaNac(rs.getDate(5));
                //c.setUssurioooo(););
                c.setArea(rs.getString(7));
                c.setEspecialidad(rs.getString(8));
                listaInstructor.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la tabla");
            e.printStackTrace();
        }

        return listaInstructor;
    }


    @Override
    public boolean actualizar(Instructor instructor) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE instructor SET id_instructor='"+instructor.getId()+"', correoSec='"+instructor.getCorreoSec()+"', telefonoPart='"+instructor.getTelefonoPart()+"', id_estado='"+instructor.getEstado()+"', fechaNac='"+instructor.getFechaNac()+"', id_usuario='"+instructor.getUssurioooo()+"', area='"+instructor.getArea()+"',especialidad='"+instructor.getEspecialidad()+"','" +" WHERE id_instrutor="+instructor.getId();
        try {
            stm=connect.createStatement();
            stm.execute(sql);
            actualizar=true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar ");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Instructor instructor) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM instructor WHERE id_instructor="+instructor.getId();
        try {
            stm=connect.createStatement();
            stm.execute(sql);
            eliminar=true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

}
