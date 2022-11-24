package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Direccion;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDireccionService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.DireccionServiceImpl;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/direccion")
@CrossOrigin(origins = "*")
public class DireccionController {
   @Autowired
   private IDireccionService direccionService;

    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Direccion direccion){
        direccionService.save(direccion);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/getDirreccion")
    public ResponseEntity<?> TraerDireccion(){
        List<Direccion> direccions = direccionService.getAll();
        return new ResponseEntity<>(direccions,HttpStatus.OK);
    }
    @PostMapping("/delete")
    public ResponseEntity<?> nuevo(@RequestBody Long id){
        direccionService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
