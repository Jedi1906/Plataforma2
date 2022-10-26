package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.AsistenciaDao;
import com.pi.Plataforma.Integral.dao.IActividadDao;
import com.pi.Plataforma.Integral.dao.IInstructorDao;
import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Instructor;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class AsistenciaServiceImpl implements IAsistenciaService {

    @Autowired
    private final AsistenciaDao asistenciaDao;

    private final IUssuriooooDao ussuriooooDao;

    private final IInstructorDao instructorDao;

    private final IActividadDao actividadDao;

    public AsistenciaServiceImpl(AsistenciaDao asistenciaDao, IInstructorDao instructorDao, IUssuriooooDao ussuriooooDao, IActividadDao actividadDao)
    {
        this.asistenciaDao=asistenciaDao;
        this.actividadDao=actividadDao;
        this.instructorDao=instructorDao;
        this.ussuriooooDao=ussuriooooDao;
    }
    public AsistenciaServiceImpl(){}
    @Override
    @Transactional
    public Asistencia save(Asistencia asistencia){
        Asistencia asistencia1 = new Asistencia();
        asistencia1.setFecha(asistencia.getFecha());
        asistencia1.setUbicacion(asistencia.getUbicacion());
        asistencia1.setValidacion(asistencia.getValidacion());
        /*
        asistencia1.setActividad(null);
        asistencia1.setInstructor(null);
        asistencia1.setUssurioooo(null);
        */
        asistenciaDao.updateAllRelations(
                asistencia.getId(),asistencia.getInstructor().getId()
                ,asistencia.getUssurioooo().getId(),
                asistencia.getActividad().getId()
        );
        return asistenciaDao.getById(asistencia1.getId());
    }

    @Override
    public Asistencia update(Asistencia asistencia) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Asistencia> getAll() {
        return asistenciaDao.findAll();
    }

    @Override
    public Asistencia getById(Long id) {
        return null;
    }

    @Override
    public List<Ussurioooo> getUssurioooo() {
        return null;
    }

    @Override
    public List<Instructor> getInstructor() {
        return null;
    }

    @Override
    public List<Actividad> getActividad() {
        return null;
    }


    @Override
    public boolean registrar(Asistencia asistencia){

        boolean registrar = false;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO asistencia values (NULL,'"+asistencia.getFecha()+"','"+asistencia.getUbicacion()+"','"+asistencia.getValidacion()+"','"+asistencia.getActividad()+"','"+asistencia.getUssurioooo()+"','"+asistencia.getInstructor()+"')'";


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
    public List<Asistencia> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM asistenia ORDER BY id_asistencia";

        List<Asistencia> listaAsistencia= new ArrayList<Asistencia>();

        try {

            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Asistencia c=new Asistencia();
                c.setId(rs.getLong(1));
                c.setFecha(rs.getString(2));
                c.setUbicacion(rs.getString(3));
                c.setValidacion(rs.getString(4));
                //c.setActividad();
                //c.setUssurioooo();
                //c.getInstructor()

                listaAsistencia.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la tabla");
            e.printStackTrace();
        }

        return listaAsistencia;
    }


    @Override
    public boolean actualizar(Asistencia asistencia) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE asistencia SET id_asistencia='"+asistencia.getId()+"', fecha='"+asistencia.getFecha()+"', ubicacion='"+asistencia.getUbicacion()+"', validacion='"+asistencia.getValidacion()+"', id_actividad='"+asistencia.getActividad()+"', id_usuario='"+asistencia.getUssurioooo()+"', id_instructor='"+asistencia.getInstructor()+"','" +" WHERE id_asistencia="+asistencia.getId();
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
    public boolean eliminar(Asistencia asistencia) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM asistencia WHERE id_asistencia="+asistencia.getId();
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
