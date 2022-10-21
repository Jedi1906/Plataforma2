package com.pi.Plataforma.Integral.controller;


import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.service.IActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/archivo")
@CrossOrigin(origins = "*")
public class ArchivoController {

    @Autowired
    private  IActividadService actividadService;


    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        List<Actividad> response = actividadService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
