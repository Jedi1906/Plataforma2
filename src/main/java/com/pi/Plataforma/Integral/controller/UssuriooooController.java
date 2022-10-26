package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


public class UssuriooooController {

    private final IUssuriooooService ussuriooooService;

    public UssuriooooController(IUssuriooooService ussuriooooService) {
        this.ussuriooooService = ussuriooooService;
    }
    @GetMapping("/getById/{idussurioooo}")
    public ResponseEntity<?> getById(@PathVariable(name = "idussurioooo") Long idussurioooo){
        Ussurioooo ussurioooo = ussuriooooService.getById(idussurioooo);
        return new ResponseEntity<>(ussurioooo, HttpStatus.OK);
    }
    @GetMapping("/getUsuario")
    public ResponseEntity<?> getUsuario(){
        List<Ussurioooo> response = ussuriooooService.getBrokers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/saveUsuario")
    public ResponseEntity<?> saveUsuario( @RequestBody Ussurioooo ussurioooo){
        ussuriooooService.saveBroker(ussurioooo);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    @PostMapping("/updatepassword")
    public ResponseEntity<?> updatepassword(@RequestBody Ussurioooo ussurioooo){
        ussuriooooService.updatepassword(ussurioooo);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    public void registrar(Ussurioooo ussurioooo ) {
        IUssuriooooService dao= new UssuriooooImpl();
        dao.registrar(ussurioooo);
    }

    //llama al service para actualizar un ussurioooo
    public void actualizar(Ussurioooo ussurioooo) {
        IUssuriooooService dao= new UssuriooooImpl();
        dao.actualizar(ussurioooo);
    }

    //llama al service para eliminar un ussurioooo
    public void eliminar(Ussurioooo ussurioooo) {
        IUssuriooooService dao= new  UssuriooooImpl();
        dao.eliminar(ussurioooo);
    }

    //llama al servie para obtener todos los usuarios
    public void verUsuario(){
        List<Ussurioooo> ussurioooo = new ArrayList<Ussurioooo>();
        IUssuriooooService dao= new  UssuriooooImpl();
        ussurioooo=dao.obtener();
    }

}


