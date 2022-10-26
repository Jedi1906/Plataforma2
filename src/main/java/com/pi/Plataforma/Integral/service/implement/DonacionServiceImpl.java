package com.pi.Plataforma.Integral.service.implement;


import com.pi.Plataforma.Integral.dao.IDonacionDao;
import com.pi.Plataforma.Integral.dao.IDonanteDao;
import com.pi.Plataforma.Integral.dao.IEventoDao;
import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Donacion;
import com.pi.Plataforma.Integral.models.Evento;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDonacionService;
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
public class DonacionServiceImpl implements IDonacionService {

    @Autowired
    private IUssuriooooDao ussuriooooDao;

    @Override
    public Donacion save(Donacion donacion) {
        return null;
    }

    @Override
    public List<Donacion> getAll() {
        return null;
    }

    @Override
    public Donacion getById(Long id) {
        return null;
    }

    @Override
    public List<Ussurioooo> getUssurioooo() {
        return null;
    }

    @Override
    public List<Donacion> getBrokers() {
        return null;
    }

    @Override
    public boolean registrar(Donacion donacion){

        boolean registrar = false;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO donacion values (NULL,'"+donacion.getTipo_donacion()+"','"+donacion.getFecha_registro()+"','"+donacion.getStock()+"','"+donacion.getFecha_act()+"','"+donacion.isValidado()+"','"+donacion.isStatus()+"','"+donacion.getUssurioooo()+"')'";


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
    public List<Donacion> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM donacion ORDER BY id_donacion";

        List<Donacion> listaDonacion= new ArrayList<Donacion>();

        try {

            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Donacion c=new Donacion();
                c.setId(rs.getLong(1));
                c.setTipo_donacion(rs.getString(2));
                c.setFecha_registro(rs.getDate(3));
                c.setStock(rs.getString(4));
                c.setFecha_act(rs.getDate(5));
                c.setValidado(rs.getBoolean(6));
                c.setStatus(rs.getBoolean(7));
                //c.setUssurioooo();
                listaDonacion.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la tabla");
            e.printStackTrace();
        }

        return listaDonacion;
    }


    @Override
    public boolean actualizar(Donacion donacion) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE donacion SET id_donacion='"+donacion.getId()+"', tipo_donacion='"+donacion.getTipo_donacion()+"', fecha_registro='"+donacion.getFecha_registro()+"', stock='"+donacion.getStock()+"', fecha_act='"+donacion.getFecha_act()+"', status='"+donacion.isStatus()+"',validado='"+donacion.isValidado()+"','" +" WHERE id_donacion="+donacion.getId();
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
    public boolean eliminar(Donacion donacion) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM donacion WHERE id_donacion="+donacion.getId();
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
