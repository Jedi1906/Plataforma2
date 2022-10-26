package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.*;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UssuriooooImpl implements IUssuriooooService {
    @Autowired
    private IUssuriooooDao ussuriooooDao;

@Override
public boolean registrar(Ussurioooo ussurioooo){

    boolean registrar = false;

    Statement stm= null;
    Connection con=null;

    String sql="INSERT INTO ussurioooo values (NULL,'"+ussurioooo.getNombre()+"','"+ussurioooo.getApellido()+"','"+ussurioooo.getFecha_creaci()+"','"+ussurioooo.getCorreo()+"','"+ussurioooo.getContraseña()+"','"+ussurioooo.getStatus()+"','"+ussurioooo.getTelefono()+"','"+ussurioooo.getFecha_actual()+"','"+ussurioooo.getGenero()+"')'";


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
    public List<Ussurioooo> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM ussurioooo ORDER BY id_usuario";

        List<Ussurioooo> listaUssurioooo= new ArrayList<Ussurioooo>();

        try {

            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Ussurioooo c=new Ussurioooo();
                c.setId(rs.getLong(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setFecha_creaci(rs.getDate(4));
                c.setCorreo(rs.getString(5));
                c.setContraseña(rs.getString(6));
                c.setStatus(rs.getString(7));
                c.setTelefono(rs.getString(8));
                c.setFecha_actual(rs.getDate(9));
                c.setGenero(rs.getString(10));

                listaUssurioooo.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la tabla");
            e.printStackTrace();
        }

        return listaUssurioooo;
    }


    @Override
    public boolean actualizar(Ussurioooo ussurioooo) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE ussuarioooo SET id_usuario='"+ussurioooo.getId()+"', nombre='"+ussurioooo.getNombre()+"', apellido='"+ussurioooo.getApellido()+"', fecha_creaci='"+ussurioooo.getCorreo()+"', correo='"+ussurioooo.getCorreo()+"', contraseña='"+ussurioooo.getContraseña()+"', status='"+ussurioooo.getStatus()+"',telefono='"+ussurioooo.getTelefono()+"', fecha_actual='"+ussurioooo.getFecha_actual()+"', genero='"+ussurioooo.getGenero()+"','" +" WHERE id_usuario="+ussurioooo.getId();
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
    public boolean eliminar(Ussurioooo ussurioooo) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM ussurioooo WHERE id_usuario="+ussurioooo.getId();
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
    @Transactional(readOnly = true)
    public Ussurioooo findByEmail(String email) {
        return null;
        //return ussuriooooDao.findByCorreo(email);
    }

    @Override
    public Ussurioooo getById(Long idussurioooo) {
        return null;
        //return ussuriooooDao.getById(idussurioooo);
    }

    //Método para insertar gerente /broker
    @Override
    @Transactional
    public void saveBroker(Ussurioooo ussurioooo) {
    /*List<Rol> role = new ArrayList<>();
    role.add(rolDao.getRolById(ussurioooo.getRolList().get(0).getId()));
    persona.setRolList(role);
    String passwordBcrypt = passwordEncoder.encode(persona.getContraseña());
    ussurioooo.setContraseña(passwordBcrypt);
    ussurioooo.setGerente(null);
    ussuriooooDao.save(ussurioooo);*/
    }

    //Devuelve Gerentes
    @Override
    public List<Ussurioooo> getBrokers() {
        return null;
        //return ussuriooooDao.getByRolList(2L,1L);
    }

    @Override
    public void updateBroker(Ussurioooo ussurioooo) {

    }

    @Override
    @Transactional
    public void updatepassword(Ussurioooo ussurioooo) {
    /*String passwordBcrypt = passwordEncoder.encode(ussurioooo.getContraseña());
    ussuriooooDao.updatePassword(ussurioooo.getId(), passwordBcrypt);*/
    }

    @Override
    public void sendRecoverPassword(Ussurioooo ussurioooo) {

    }
}
