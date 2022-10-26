package com.pi.Plataforma.Integral.service.implement;


import com.pi.Plataforma.Integral.dao.IArchivoDao;
import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArchivoServiceImpl implements IArchivoService {

    @Autowired
    private  IArchivoDao archivoDao;



    @Override
    public boolean registrar(Archivo archivo){

        boolean registrar = false;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO archivo_carga values (NULL,'"+archivo.getNombre_archivo()+"','"+archivo.getRuta()+"','"+archivo.getUssurioooo()+"')'";


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
    public List<Archivo> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM archivo_carga ORDER BY id_carga";

        List<Archivo> listaArchivo= new ArrayList<Archivo>();

        try {

            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Archivo c=new Archivo();
                c.setId(rs.getLong(1));
                c.setNombre_archivo(rs.getString(2));
                c.setRuta(rs.getString(3));
                //c.setUssurioooo(rs.getLong(4));
                listaArchivo.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la tabla");
            e.printStackTrace();
        }

        return listaArchivo;
    }


    @Override
    public boolean actualizar(Archivo archivo) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE archivo_carga SET id_carga='"+archivo.getId()+"', nombre_archivo='"+archivo.getNombre_archivo()+"', ruta='"+archivo.getRuta()+"', id_usuario='"+archivo.getUssurioooo()+"','" +" WHERE id_carga="+archivo.getId();
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
    public boolean eliminar(Archivo archivo) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM archivo_carga WHERE id_carga="+archivo.getId();
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
    public List<Archivo> getAll() {
        return archivoDao.findAll();
    }
}


