package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IDireccionDao;
import com.pi.Plataforma.Integral.models.Direccion;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class DireccionServiceImpl implements IDireccionService {

    @Autowired
    private  IDireccionDao direccionDao;


    @Override
    public Direccion findByAll() {
        return null;
    }

    @Override
    public Direccion getById(Long id_direccion) {
        return null;
    }

    @Override
    public List<Direccion> getBrokers() {
        return null;
    }



    @Override
    public boolean registrar(Direccion direccion){

        boolean registrar = false;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO direccion values (NULL,'"+direccion.getNombre()+"','"+direccion.getCalle()+"','"+direccion.getNumero_ext()+"','"+direccion.getNumero_int()+"','"+direccion.getCp()+"','"+direccion.getColonia()+"','"+direccion.getMunicipio()+"','"+direccion.getEstado()+"')'";


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
    public List<Direccion> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM direccion ORDER BY id_direccion";

        List<Direccion> listaDireccion= new ArrayList<Direccion>();

        try {

            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Direccion c=new Direccion();
                c.setId(rs.getLong(1));
                c.setNombre(rs.getString(2));
                c.setCalle(rs.getString(3));
                c.setNumero_ext(rs.getString(4));
                c.setNumero_int(rs.getString(5));
                c.setCp(rs.getString(6));
                //c.setColonia();
                //c.setMunicipio();
                //c.setEstado();

                listaDireccion.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la tabla");
            e.printStackTrace();
        }

        return listaDireccion;
    }


    @Override
    public boolean actualizar(Direccion direccion) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE direccion SET id_direccion='"+direccion.getId()+"', nombre='"+direccion.getNombre()+"', calle='"+direccion.getCalle()+"', numero_ext='"+direccion.getNumero_ext()+"', numero_int='"+direccion.getNumero_int()+"', cp='"+direccion.getCp()+"',id_colonia='"+direccion.getColonia()+"', id_municipio='"+direccion.getMunicipio()+"', id_estado='"+direccion.getEstado()+"','" +" WHERE id_direccion="+direccion.getId();
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
    public boolean eliminar(Direccion direccion) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM direccion WHERE id_direccion="+direccion.getId();
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
