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

    /*@GetMapping("/getById/{id_usuario}")
    public ResponseEntity<?> getById(@PathVariable(name = "id_usuario") Long id){
        Ussurioooo ussurioooo = ussuriooooService.getById(id);
        return new ResponseEntity<>(ussurioooo, HttpStatus.OK);
    }
    @GetMapping("/getUsuario")
    public ResponseEntity<?> getUsuario(){
        List<Ussurioooo> response = ussuriooooService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/updatepassword")
    public ResponseEntity<?> updatepassword(@RequestBody Ussurioooo ussurioooo){
        ussuriooooService.updatepassword(ussurioooo);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    */
    @PostMapping("/saveUsuario")
    public ResponseEntity<?> saveUsuario( @RequestBody Ussurioooo ussurioooo){
        ussuriooooService.save(ussurioooo);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> nuevo(@RequestBody Long id){
        ussuriooooService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}


