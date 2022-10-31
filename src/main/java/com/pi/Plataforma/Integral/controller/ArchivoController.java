package com.pi.Plataforma.Integral.controller;


import com.pi.Plataforma.Integral.models.Archivo;

import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.service.IArchivoService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.ArchivoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/archivo")
@CrossOrigin(origins = "*")
public class ArchivoController {

    @Autowired
    private IArchivoService archivoService;


    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Archivo archivo){
        archivoService.save(archivo);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> nuevo(@RequestBody Long id){
        archivoService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
