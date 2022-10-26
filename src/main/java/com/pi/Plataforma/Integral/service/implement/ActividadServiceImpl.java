package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IActividadDao;
import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActividadServiceImpl implements IActividadService {

    @Autowired
    private IActividadDao actividadDao;

    public ActividadServiceImpl(IActividadDao actividadDao) {
        this.actividadDao = actividadDao;
    }


    @Override
    public boolean registrar(Actividad actividad){

        boolean registrar = false;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO actividad values (NULL,'"+actividad.getNombre()+"','"+actividad.getCupo()+"','"+actividad.getHorario()+"')'";


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
    public List<Actividad> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM actividad ORDER BY id_actividad";

        List<Actividad> listaActividad= new ArrayList<Actividad>();

        try {

            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Actividad c=new Actividad();
                c.setId(rs.getLong(1));
                c.setNombre(rs.getString(2));
                c.setCupo(rs.getString(3));
                c.setHorario(rs.getString(4));
                listaActividad.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la tabla");
            e.printStackTrace();
        }

        return listaActividad;
    }

    @Override
    public boolean actualizar(Actividad actividad) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE actividad SET id_actividad='"+actividad.getId()+"', nombre='"+actividad.getNombre()+"', cupo='"+actividad.getCupo()+"', horario='"+actividad.getHorario()+"','" +" WHERE id_actividad="+actividad.getId();
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
    public boolean eliminar(Actividad actividad) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM actividad WHERE id_actividad="+actividad.getId();
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



    @Override
    public List<Actividad> getAll() {
        return actividadDao.findAll();
    }
}
