package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Direccion;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDireccionService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.DireccionServiceImpl;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/direccion")
@CrossOrigin(origins = "*")
public class DireccionController {
   private IDireccionService direccionService;

    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Direccion direccion){
        direccionService.save(direccion);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
