package com.pi.Plataforma.Integral.controller;


import com.pi.Plataforma.Integral.models.Municipio;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IMunicipioService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.MunicipioServicelmpl;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/municipio")
@CrossOrigin(origins = "*")
public class MunicipioController {
    private final IMunicipioService municipioService;

    public MunicipioController(IMunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping("/getById/{id_municipio}")
    public ResponseEntity<?> getById(@PathVariable(name = "id_municipio") Long id_municipio) {
        Municipio municipio = municipioService.getById(id_municipio);
        return new ResponseEntity<>(municipio, HttpStatus.OK);
    }

    @GetMapping("/getMunicipio")
    public ResponseEntity<?> getMunicipio() {
        List<Municipio> response = municipioService.getBrokers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public void registrar(Municipio municipio ) {
        IMunicipioService dao= new MunicipioServicelmpl();
        dao.registrar(municipio);
    }

    //llama al service para actualizar un ussurioooo
    public void actualizar(Municipio municipio) {
        IMunicipioService dao= new MunicipioServicelmpl();
        dao.actualizar(municipio);
    }

    //llama al service para eliminar un ussurioooo
    public void eliminar(Municipio municipio) {
        IMunicipioService dao= new MunicipioServicelmpl();
        dao.eliminar(municipio);
    }

    //llama al servie para obtener todos los usuarios
    public void verMunicipio(){
        List<Municipio> municipio = new ArrayList<Municipio>();
        IMunicipioService dao= new MunicipioServicelmpl();
        municipio=dao.obtener();
    }


}