package com.pi.Plataforma.Integral.controller;


import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Municipio;
import com.pi.Plataforma.Integral.models.Ussurioooo;
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

    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Municipio municipio){
        municipioService.save(municipio);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @GetMapping("/getMunicipio")
    public ResponseEntity<?> TraerMunicipio(){
        List<Municipio> municipios = municipioService.getAll();
        return new ResponseEntity<>(municipios,HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> nuevo(@RequestBody Long id){
        municipioService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}