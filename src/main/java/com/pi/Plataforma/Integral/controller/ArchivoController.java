package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.service.IArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/archivo")
@CrossOrigin(origins = "*")
public class ArchivoController {

    @Autowired
    private IArchivoService archivoService;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Archivo archivo){
        archivoService.save(archivo);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/getArchivos")
    public ResponseEntity<?> TraerArchivos(){
        List<Archivo>  archivos= archivoService.get();
        return new ResponseEntity<>(archivos,HttpStatus.OK);
    }

    @GetMapping("/getArchivo")
    public ResponseEntity<?> TraerArchivo(){
        List<Archivo>  archivos= archivoService.getAll();
        return new ResponseEntity<>(archivos,HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> nuevo(@RequestBody Long id){
        archivoService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
