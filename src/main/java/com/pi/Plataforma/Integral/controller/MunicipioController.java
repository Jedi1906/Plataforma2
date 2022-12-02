package com.pi.Plataforma.Integral.controller;


import com.pi.Plataforma.Integral.models.*;
import com.pi.Plataforma.Integral.service.IMunicipioService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.MunicipioServicelmpl;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/municipio")
@CrossOrigin(origins = "*")
public class MunicipioController {
    @Autowired
    private IMunicipioService municipioService;

    public  MunicipioController(IMunicipioService municipioService){this.municipioService=municipioService;}

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Municipio municipio){
        municipioService.save(municipio);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/getEstado/estado")
    public ResponseEntity<?> getEstado(@PathVariable(name = "estado") Long id_estado){
        List<Municipio> response = municipioService.getEstado(id_estado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/getMunicipio")
    public ResponseEntity<?> TraerMunicipio(){
        List<Municipio> municipios = municipioService.getAll();
        return new ResponseEntity<>(municipios,HttpStatus.OK);
    }

    @GetMapping("/getMunicipios")
    public ResponseEntity<?> TraerMunicipios(){
        List<Municipio>  municipios= municipioService.get();
        return new ResponseEntity<>(municipios,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        municipioService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}