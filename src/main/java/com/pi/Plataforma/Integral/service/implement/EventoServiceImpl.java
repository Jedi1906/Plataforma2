package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IEventoDao;
import com.pi.Plataforma.Integral.models.Evento;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventoServiceImpl implements IEventoService {
    @Autowired
    private IEventoDao eventoDao;



    @Override
    public Evento findByAll() {
        return null;
    }

    @Override
    public Evento getById(Long id_evento) {
        return null;
    }

    @Override
    public List<Evento> getBrokers() {
        return null;
    }


    @Override
    public boolean registrar(Evento evento){

        boolean registrar = false;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO evento values (NULL,'"+evento.getDescripcion()+"','"+evento.getFecha()+"','"+evento.getUbicacion()+"','"+evento.getUrl()+"','"+evento.getImagen()+"','"+evento.getInstrucciones()+"','"+evento.getUssurioooo()+"')'";


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
    public List<Evento> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM evento ORDER BY id_evento";

        List<Evento> listaEvento= new ArrayList<Evento>();

        try {

            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Evento c=new Evento();
                c.setId(rs.getLong(1));
                c.setDescripcion(rs.getString(2));
                c.setFecha(rs.getDate(3));
                c.setUbicacion(rs.getString(4));
                c.setUrl(rs.getString(5));
                c.setImagen(rs.getString(6));
                c.setInstrucciones(rs.getString(7));
               // c.setUssurioooo();

                listaEvento.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la tabla");
            e.printStackTrace();
        }

        return listaEvento;
    }


    @Override
    public boolean actualizar(Evento evento) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE evento SET id_uvento='"+evento.getId()+"', descripcion='"+evento.getDescripcion()+"', fecha='"+evento.getFecha()+"', ubicacion='"+evento.getUbicacion()+"', url='"+evento.getUrl()+"', imagen='"+evento.getImagen()+"',instrucciones='"+evento.getInstrucciones()+"', id_usuario='"+evento.getUssurioooo()+"','" +" WHERE id_evento="+evento.getId();
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
    public boolean eliminar(Evento evento) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM evento WHERE id_evento="+evento.getId();
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
