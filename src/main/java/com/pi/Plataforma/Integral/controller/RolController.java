package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Rol;
import com.pi.Plataforma.Integral.service.IRolService;
import com.pi.Plataforma.Integral.service.implement.RolServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class RolController {


    //llama service para registrar rol
    public void registrar(Rol rol ) {
        IRolService dao= new RolServiceImpl();
        dao.registrar(rol);
    }

    //llama al service para actualizar un rol
    public void actualizar(Rol rol) {
        IRolService dao= new RolServiceImpl();
        dao.actualizar(rol);
    }

    //llama al service para eliminar un rol
    public void eliminar(Rol rol) {
        IRolService dao= new RolServiceImpl();
        dao.eliminar(rol);
    }

    //llama al servie para obtener todos los usuarios
    public void verUsuario(){
        List<Rol> rol = new ArrayList<Rol>();
        IRolService dao= new  RolServiceImpl();
        rol=dao.obtener();
    }

}
