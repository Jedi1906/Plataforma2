package com.pi.Plataforma.Integral.service.implement;


import com.pi.Plataforma.Integral.dao.IDonanteDao;
import com.pi.Plataforma.Integral.dao.IEstadoDao;
import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Donante;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDonanteService;
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
public class DonanteServiceImpl implements IDonanteService {

    @Autowired
    private  IDonanteDao donanteDao;

    private final IEstadoDao estadoDao;

    private final IUssuriooooDao ussuriooooDao;

    public DonanteServiceImpl(IDonanteDao donanteDao, IEstadoDao estadoDao, IUssuriooooDao ussuriooooDao)
    {
        this.donanteDao=donanteDao;
        this.estadoDao=estadoDao;
        this.ussuriooooDao=ussuriooooDao;
    }

    @Override
    @Transactional
    public Donante save(Donante donante){
        Long id_usuario = donante.getUssurioooo().getId();
        donante.setUssurioooo(null);

        Long id_estado = donante.getEstado().getId();
        donante.setEstado(null);

        Donante donanteSave = donanteDao.save(donante);

        donanteDao.updateAllRelations(donanteSave.getId(), id_estado, id_usuario);


        return  donanteDao.getById(donante.getId());

    }

    @Override
    public List<Donante> getAll() {return donanteDao.findAll();}

    @Override
    public Donante getById(Long id) {
        return donanteDao.getById(id);
    }

    @Override
    public List<Ussurioooo> getUssurioooo() {
        return null;
    }

    @Override
    public List<Estado> getEstado() {
        return null;
    }


    @Override
    public boolean registrar(Donante donante){

        boolean registrar = false;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO donante values (NULL,'"+donante.getTipo_donacion()+"','"+donante.getValidacion()+"','"+donante.getTelefono_contacto()+"','"+donante.getProviene_de()+"','"+donante.getObservaciones()+"','"+donante.getUssurioooo()+"','"+donante.getEstado()+"')'";


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
    public List<Donante> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM donante ORDER BY id_donante";

        List<Donante> listaDonante= new ArrayList<Donante>();

        try {

            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Donante c=new Donante();
                c.setId(rs.getLong(1));
                c.setTipo_donacion(rs.getString(2));
                c.setValidacion(rs.getString(3));
                c.setTelefono_contacto(rs.getInt(4));
                c.setProviene_de(rs.getString(5));
                c.setObservaciones(rs.getString(6));
                //c.setUssurioooo();
                //c.setEstado();

                listaDonante.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la tabla");
            e.printStackTrace();
        }

        return listaDonante;
    }


    @Override
    public boolean actualizar(Donante donante) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE donante SET id_donante='"+donante.getId()+"', tipo_donacion='"+donante.getTipo_donacion()+"', validacion='"+donante.getValidacion()+"', telefono_contacto='"+donante.getTelefono_contacto()+"', proviene_de='"+donante.getProviene_de()+"', observaciones='"+donante.getObservaciones()+"', id_usuario='"+donante.getUssurioooo()+"',id_estado='"+donante.getEstado()+"','" +" WHERE id_donante="+donante.getId();
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
    public boolean eliminar(Donante donante) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM donante WHERE id_donante="+donante.getId();
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
