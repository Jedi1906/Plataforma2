package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IRolDao;
import com.pi.Plataforma.Integral.models.Rol;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IRolService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class RolServiceImpl implements IRolService {


    private IRolDao rolDao;


    @Override
    public List<Rol> getAll() {
        return rolDao.findAll();
    }

    @Override
    public boolean registrar(Rol rol){

        boolean registrar = false;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO rol values (NULL,'"+rol.getRol_nombre()+"','"+rol.getUssurioooo()+"')'";


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
    public List<Rol> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM rol ORDER BY id_rol";

        List<Rol> listaRol= new ArrayList<Rol>();

        try {

            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Rol c=new Rol();
                c.setId(rs.getLong(1));
                c.setRol_nombre(rs.getString(2));
                //c.setUssurioooo();
                listaRol.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la tabla");
            e.printStackTrace();
        }

        return listaRol;
    }

    @Override
    public boolean actualizar(Rol rol) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE rol SET id_rol='"+rol.getId()+"', rol_nombre='"+rol.getRol_nombre()+"','" +" WHERE id_rol="+rol.getId();
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
    public boolean eliminar(Rol rol) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM rol WHERE id_rol="+rol.getId();
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