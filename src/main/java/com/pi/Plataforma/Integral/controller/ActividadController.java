package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.service.IActividadService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividad")
@CrossOrigin(origins = "*")
public class ActividadController {

    private IActividadService actividadService;

    @GetMapping("/getAll")
    public ResponseEntity<?> nuevo(@RequestBody Actividad actividad){
        actividadService.save(actividad);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> nuevo(@RequestBody Long id){
        actividadService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
