package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.models.Colonia;
import com.pi.Plataforma.Integral.models.Municipio;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IColoniaService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class ColoniaServicelmpl implements IColoniaService {
    @Override
    public Colonia findByAll() {
        return null;
    }

    @Override
    public Colonia getById(Long id_colonia) {
        return null;
    }

    @Override
    public List<Colonia> getBrokers() {
        return null;
    }


    @Override
    public boolean registrar(Colonia colonia){

        boolean registrar = false;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO colonia values (NULL,'"+colonia.getNombre_colonia()+"','"+colonia.getCp()+"','"+colonia.getCiudad()+"','"+colonia.getAsentamiento()+"','"+colonia.getMunicipio()+"')'";


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
    public List<Colonia> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM colonia ORDER BY id_colonia";

        List<Colonia> listaColinia= new ArrayList<Colonia>();

        try {

            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Colonia c=new Colonia();
                c.setId(rs.getLong(1));
                c.setNombre_colonia(rs.getString(2));
                c.setCp(rs.getString(3));
                c.setCiudad(rs.getString(4));
                c.setAsentamiento(rs.getString(5));
                //c.setMunicipio();


                listaColinia.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la tabla");
            e.printStackTrace();
        }

        return listaColinia;
    }


    @Override
    public boolean actualizar(Colonia colonia) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE colonia SET id_colonia='"+colonia.getId()+"', nombre_colonia='"+colonia.getNombre_colonia()+"', cp='"+colonia.getCp()+"', ciudad='"+colonia.getCiudad()+"', asentamiento='"+colonia.getAsentamiento()+"', id_municipio='"+colonia.getMunicipio()+"','" +" WHERE id_colonia="+colonia.getId();
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
    public boolean eliminar(Colonia colonia) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM colonia WHERE id_colonia="+colonia.getId();
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
