package com.pi.Plataforma.Integral.service.implement;


import com.pi.Plataforma.Integral.dao.IEstadoDao;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Service
public class EstadoServiceImpl implements IEstadoService {
    @Autowired
    private IEstadoDao estadoDao;



    @Override
    public boolean registrar(Estado estado){

        boolean registrar = false;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO estado values (NULL,'"+estado.getNombre_estado()+"')'";


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
    public List<Estado> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM estado ORDER BY id_estado";

        List<Estado> listaEstado= new ArrayList<Estado>();

        try {

            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Estado c=new Estado();
                c.setId(rs.getLong(1));
                c.setNombre_estado(rs.getString(2));

                listaEstado.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la tabla");
            e.printStackTrace();
        }

        return listaEstado;
    }


    @Override
    public boolean actualizar(Estado estado) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE estado SET id_estado='"+estado.getId()+"', nombre_estado='"+estado.getNombre_estado()+"','" +" WHERE id_estado="+estado.getId();
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
    public boolean eliminar(Estado estado) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM estado WHERE id_estado="+estado.getId();
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



    @Transactional(readOnly = true)
    public Estado findByAll() {
        return null;
        //return estadoDao.findByAll();
    }


    public Estado getById(Long id_estado) {
        return null;
        //return estadoDao.getById(id_estado);
    }

    @Override
    public List<Estado> getBrokers() {
        return null;
    }
}
