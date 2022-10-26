package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IColoniaDao;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Municipio;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IMunicipioService;
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
public class MunicipioServicelmpl implements IMunicipioService {
    @Autowired
    private IColoniaDao coloniaDao;

    @Transactional(readOnly = true)
    public Municipio findByAll(){
        return null;
        //return municipioDao.findByAll();
    }

    @Override
    public Municipio FindByAll() {
        return null;
    }

    public Municipio getById(Long id_municipio){
        return null;

        //return municipioDao.getById(id_municipio);
    }

    @Override
    public List<Municipio> getBrokers() {
        return null;
    }


    @Override
    public boolean registrar(Municipio municipio){

        boolean registrar = false;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO municipio values (NULL,'"+municipio.getNombre_municipio()+"','"+municipio.getEstado()+"')'";


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
    public List<Municipio> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM municipio ORDER BY id_municipio";

        List<Municipio> listaMunicipio= new ArrayList<Municipio>();

        try {

            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Municipio c=new Municipio();
                c.setId(rs.getLong(1));
                c.setNombre_municipio(rs.getString(2));
                //c.setEstado();

                listaMunicipio.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la tabla");
            e.printStackTrace();
        }

        return listaMunicipio;
    }


    @Override
    public boolean actualizar(Municipio municipio) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE municipio SET id_municipio='"+municipio.getId()+"', nombre_municipio='"+municipio.getNombre_municipio()+"', id_estado='"+municipio.getEstado()+"','" +" WHERE id_municipio="+municipio.getId();
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
    public boolean eliminar(Municipio municipio) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM municipio WHERE id_municipio="+municipio.getId();
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
